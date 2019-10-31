package com.example.bosspavi.patientmanagement;

public class Appointment {
    private String Name,Surname,Phone,Date;

    public Appointment(String Name,String Surname,String Phone,String Date){
        this.setName(Name);
        this.setSurname(Surname);
        this.setPhone(Phone);
        this.setDate(Date);
    }

    public String getName(){
        return Name;
    }

    public void setName(String name){
        Name=name;
    }

    public String getSurname(){
        return Surname;
    }

    public void setSurname(String surname){
        Surname=surname;
    }

    public String getPhone(){
        return Phone;
    }

    public void setPhone(String phone){
        Phone=phone;
    }

    public String getDate(){
        return Date;
    }

    public void setDate(String date){
        Date=date;
    }
}
