package com.rxlxr.fermentor_remote_control_back.controller;


import com.rxlxr.fermentor_remote_control_back.entities.Result;
import com.rxlxr.fermentor_remote_control_back.service.RemoteService;
import com.rxlxr.mqtt.entities.TargetData;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.rxlxr.fermentor_remote_control_back.FermentorRemoteControlBackApplication.target;

@Slf4j
@RestController
public class RemoteController {
    @Autowired
    private RemoteService remoteService;
//    private static Logger log = LoggerFactory.getLogger(PerController.class);
    @CrossOrigin
    @RequestMapping("/home")
    public Result all(@RequestParam(required = false) String targetDevice){

        log.info("获取全部数据");
        target = targetDevice;
        Result  r = remoteService.dataHandle();
        System.out.println("发送给前端" + r.getValue().toString());
        return r;
    }

    @CrossOrigin
    @RequestMapping("/heatSet")
    public Result SetHeat(@RequestBody TargetData a) throws MqttException {
        log.info(a.toString());
        return remoteService.heatSet(a);
    }

    @CrossOrigin
    @RequestMapping("/frozeSet")
    public Result SetFroze(@RequestBody TargetData a) throws MqttException {
        log.info(a.toString());
        return remoteService.frozeSet(a);
    }

    @CrossOrigin
    @RequestMapping("/acidSet")
    public Result SetAcid(@RequestBody TargetData a) throws MqttException {
        log.info(a.toString());
        return remoteService.acidSet(a);
    }

    @CrossOrigin
    @RequestMapping("/stirSet")
    public Result SetStir(@RequestBody TargetData a) throws MqttException {
        log.info(a.toString());
        return remoteService.stirSet(a);
    }


    @CrossOrigin
    @RequestMapping("/alkaliSet")
    public Result SetAlkali(@RequestBody TargetData a) throws MqttException {
        log.info(a.toString());
        return remoteService.alkaliSet(a);
    }
    @CrossOrigin
    @RequestMapping("/systemState")
    public Result SetSys(@RequestBody TargetData a) throws MqttException {
        log.info(a.toString());
        return remoteService.systemState(a);
    }

    @CrossOrigin
    @RequestMapping("/controlWay")
    public Result SetControl(@RequestBody TargetData a) throws MqttException {
        log.info(a.toString());
        return remoteService.controlWay(a);
    }

//
//    @CrossOrigin
//    @RequestMapping("/uploadImage")
//    public Result SetImage(@RequestBody String base64) throws MqttException {
//        remoteService.sendImage(base64);
//        Result r =  new Result();
//        r.setMessage(true);
//        return r;
//    }

}
