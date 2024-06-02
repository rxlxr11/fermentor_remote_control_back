package com.rxlxr.fermentor_remote_control_back;


import com.rxlxr.mqtt.PubAndSub;
import com.rxlxr.mqtt.entities.Data;
import com.rxlxr.mqtt.entities.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FermentorRemoteControlBackApplication {
    public static PubAndSub pubAndSub ;
    //public static Data myData;
    public static Data fermentor1Data;
    public static Data fermentor2Data;

    public static String target = "fermentor_01";
    public static void main(String[] args) throws Exception {
        SpringApplication.run(FermentorRemoteControlBackApplication.class, args);

        //myData = new Data();
        fermentor1Data = new Data();
        fermentor2Data = new Data();
        String DeviceSecret = "0abfb2d23af04f7d440aa0854c029606";
        String DeviceName = "remote01";
        Product product_aliyun = new Product(DeviceName,DeviceSecret);
        pubAndSub = new PubAndSub(product_aliyun);
        pubAndSub.connect();

        pubAndSub.listen();

    }

}
