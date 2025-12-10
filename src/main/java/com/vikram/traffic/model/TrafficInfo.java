package com.vikram.traffic.model;

public class TrafficInfo{
    private int congestionLevel;

    public TrafficInfo(int congestionLevel){
        this.congestionLevel = congestionLevel;
    }
    public int getCongestionLevel(){
        return congestionLevel;
    }


    public String toString(){
        return "Level " + congestionLevel;
    }
}
