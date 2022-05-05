package com.example.shlepa_schedule;

public class Directions {

    private String direction;

    public static final Directions[] directions = {
            new Directions("ФСГН"),
            new Directions("ИСАУ-1"),
            new Directions("ИСАУ-2"),
            new Directions("ИФИ"),
            new Directions("ФЕИН"),
    };

    private Directions(String direction){
        this.direction = direction;
    }

    public String getDirection(){
        return direction;
    }

}
