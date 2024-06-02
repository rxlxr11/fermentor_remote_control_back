package com.rxlxr.mqtt.entities;

import lombok.Data;


@Data
public class Product {
    private String ProductKey = "h63zP9JyuCi";
    private String ProductSecret = "CcsucaVzfcL7gkCb";
    private String DeviceSecret;
    private String DeviceName;

    private String port = "1883";
    private String broker ;

    public Product (String deviceName,String deviceSecret){
        this.DeviceSecret = deviceSecret;
        this.DeviceName = deviceName;
        this.broker = "ssl://" + this.ProductKey + ".iot-as-mqtt.cn-shanghai.aliyuncs.com" + ":" + port;
    }
}
