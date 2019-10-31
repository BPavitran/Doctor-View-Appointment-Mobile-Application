package com.example.bosspavi.patientmanagement;

public class Time {
    private String Day,Time;

    public Time(String Day,String Time){
        this.setDay(Day);
        this.setTime(Time);
    }

    public String getDay(){
        return Day;
    }

    public void setDay(String day){
        Day=day;
    }

    public String getTime(){
        return Time;
    }

    public void setTime(String time){
        Time=time;
    }
}
