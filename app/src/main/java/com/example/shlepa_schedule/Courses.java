package com.example.shlepa_schedule;

public class Courses {
    private String kurs;

    public static final Courses[] kurses = {
            new Courses("1 Курс"),
            new Courses("2 Курс"),
            new Courses("3 Курс"),
            new Courses("4 Курс"),
    };

    private Courses(String kurs){
        this.kurs = kurs;
    }

    public String getKurs(){
        return kurs;
    }
}
