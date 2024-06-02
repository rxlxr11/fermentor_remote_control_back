package com.rxlxr.fermentor_remote_control_back.service;



import com.rxlxr.fermentor_remote_control_back.entities.Result;
import com.rxlxr.mqtt.entities.TargetData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.rxlxr.fermentor_remote_control_back.FermentorRemoteControlBackApplication.*;

//import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
@Slf4j
@Service
public class RemoteService {


    @Autowired

    public Result dataHandle(){

        Result r = new Result();
        r.setCode(200);
        if (target.equals("fermentor_01"))
            r.setValue(fermentor1Data);
        else if (target.equals("fermentor_02"))
            r.setValue(fermentor2Data);
//        else
//            r.setValue(fermentor1Data);
        //System.out.println("发送给前端" + r.getValue().toString());
        r.setMessage("success");
        return r;
    }

    public Result heatSet(TargetData a){
        Result r = new Result();
        r.setCode(200);
        r.setMessage("success");
        String topic = "/h63zP9JyuCi/remote01/user/heatSet";
        a.setSet("heatSet");
        try {
            pubAndSub.publish(topic, a);
        }catch (Exception e){
            System.out.println(e);
        }
        return r;
    }
    public Result frozeSet(TargetData a){
        Result r = new Result();
        r.setCode(200);
        r.setMessage("success");
        a.setSet("frozeSet");
        String topic = "/h63zP9JyuCi/remote01/user/frozeSet";

//        TargetData d = new TargetData();
//        d.setProp(a);
        try {
            pubAndSub.publish(topic, a);
        }catch (Exception e){
            System.out.println(e);
        }

        return r;
    }
    public Result acidSet(TargetData a){
        Result r = new Result();
        r.setCode(200);
        r.setMessage("success");
        a.setSet("acidSet");
        String topic = "/h63zP9JyuCi/remote01/user/acidSet";
//        TargetData d = new TargetData();
//        d.setProp(a);
        try {
            pubAndSub.publish(topic, a);
        }catch (Exception e){
            System.out.println(e);
        }

        return r;
    }
    public Result alkaliSet(TargetData a){
        Result r = new Result();
        r.setCode(200);
        r.setMessage("success");
        a.setSet("alkaliSet");
        String topic = "/h63zP9JyuCi/remote01/user/alkaliSet";
//        TargetData d = new TargetData();
//        d.setProp(a);
        try {
            pubAndSub.publish(topic, a);
        }catch (Exception e){
            System.out.println(e);
        }

        return r;
    }
    public Result stirSet(TargetData a){
        Result r = new Result();
        r.setCode(200);
        r.setMessage("success");
        a.setSet("stirSet");
        String topic = "/h63zP9JyuCi/remote01/user/stirSet";
//        TargetData d = new TargetData();
//        d.setProp(a);
        try {
            pubAndSub.publish(topic, a);
        }catch (Exception e){
            System.out.println(e);
        }

        return r;
    }

    public Result systemState(TargetData a){
        Result r = new Result();
        r.setCode(200);
        r.setMessage("success");
        a.setSet("systemState");
        String topic = "/h63zP9JyuCi/remote01/user/systemState";
//        TargetData d = new TargetData();
//        d.setProp(a);
        try {
            pubAndSub.publish(topic, a);
        }catch (Exception e){
            System.out.println(e);
        }

        return r;
    }

    public Result controlWay(TargetData a){
        Result r = new Result();
        r.setCode(200);
        r.setMessage("success");
        a.setSet("controlWay");
        String topic = "/h63zP9JyuCi/remote01/user/controlWay";
//        TargetData d = new TargetData();
//        d.setProp(a);
        try {
            pubAndSub.publish(topic, a);
        }catch (Exception e){
            System.out.println(e);
        }

        return r;
    }


//    @Scheduled(fixedRate = 2500) // 每2.5秒执行一次
//    public data scheduleUpdate() {
//        log.info("update");
//        //System.out.println(data.temp_array[0]+" "+data.temp_array[1]);
//        data d = dataHandle();
//        return d;
//    }


}
