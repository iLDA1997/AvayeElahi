package com.noobs_team.avayeelahi.Data;

public class AsmaAllahList {
    private String allahNameFa;
    private String allahNameEn;
    private String nameMeaning;


    public AsmaAllahList(String allahNameFa, String allahNameEn, String nameMeaning){
        this.allahNameFa = allahNameFa;
        this.allahNameEn = allahNameEn;
        this.nameMeaning = nameMeaning;
    }

    public void setAllahNameFa (String allahNameFa){
        this.allahNameFa = allahNameFa;
    }
    public void setAllahNameEn (String allahNameEn){
        this.allahNameEn = allahNameEn;
    }
    public void setNameMeaning (String nameMeaning){
        this.nameMeaning = nameMeaning;
    }
    public String getAllahNameFa (){
        return allahNameFa;
    }
    public String getAllahNameEn (){
        return allahNameEn;
    }
    public String getNameMeaning (){
        return nameMeaning;
    }

    @Override
    public String toString() {
        return allahNameFa;
    }
}