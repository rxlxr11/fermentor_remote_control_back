package com.rxlxr.mqtt.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Data {
    private float temp = 0.0f;

    private float oxygen = 0.0f;
    private float ph = 0.0f;
    private float bubble = 0.0f;
    private String controlWay = "本地控制";
    private String systemState = "关机";
    private float heatSet = 0;
    private float acidSet = 0;
    private float frozeSet = 0;
    private float stirSet = 0;
    private float alkaliSet = 0;


}
