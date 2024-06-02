package com.rxlxr.mqtt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rxlxr.mqtt.entities.Protocol;
import com.rxlxr.mqtt.entities.Receive;
import lombok.AllArgsConstructor;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import static com.rxlxr.fermentor_remote_control_back.FermentorRemoteControlBackApplication.fermentor1Data;
import static com.rxlxr.fermentor_remote_control_back.FermentorRemoteControlBackApplication.fermentor2Data;

@AllArgsConstructor
public class MessageArrive extends Thread{


    private String s;
    private MqttMessage mqttMessage;
    private Protocol protocol;
    public  void run() {
        System.out.println("Sub message");
        System.out.println("Topic : " + s);
        System.out.println(new String(mqttMessage.getPayload())); //打印输出消息payLoad
        String payLoad = new String(mqttMessage.getPayload());
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Receive receive = objectMapper.readValue(payLoad, Receive.class);
            if (receive.getSourceDevice().equals("fermentor_01"))
                fermentor1Data = receive.getProp();
            else if(receive.getSourceDevice().equals("fermentor_02"))
                fermentor2Data = receive.getProp();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
