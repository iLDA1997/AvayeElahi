package com.noobs_team.avayeelahi.Data;

public class HolidayList {
    private String holidayDayOfWeek;
    private String holidaySubject;
    private String holidayShamsi;
    private String holidayMiladi;
    private String holidayGhamari;


    public HolidayList(String holidayDayOfWeek, String holidaySubject, String holidayShamsi, String holidayMiladi, String holidayGhamari){
        this.holidayDayOfWeek = holidayDayOfWeek;
        this.holidaySubject = holidaySubject;
        this.holidayShamsi = holidayShamsi;
        this.holidayMiladi = holidayMiladi;
        this.holidayGhamari = holidayGhamari;
    }

    public void setHolidayDayOfWeek (String holidayDayOfWeek){
        this.holidayDayOfWeek = holidayDayOfWeek;
    }
    public void setHolidaySubject (String holidaySubject){
        this.holidaySubject = holidaySubject;
    }
    public void setHolidayShamsi (String holidayShamsi){
        this.holidayShamsi = holidayShamsi;
    }
    public void setHolidayMiladi (String holidayMiladi){
        this.holidayMiladi = holidayMiladi;
    }
    public void setHolidayGhamari (String holidayGhamari){
        this.holidayGhamari = holidayGhamari;
    }
    public String getHolidayDayOfWeek (){
        return holidayDayOfWeek;
    }
    public String getHolidaySubject (){
        return holidaySubject;
    }
    public String getHolidayShamsi (){
        return holidayShamsi;
    }
    public String getHolidayMiladi (){
        return holidayMiladi;
    }
    public String getHolidayGhamari (){
        return holidayGhamari;
    }

    @Override
    public String toString() {
        return holidayDayOfWeek;
    }
}