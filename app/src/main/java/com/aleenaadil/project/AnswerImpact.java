package com.aleenaadil.project;

public class AnswerImpact {
    private int temp;
    private int co2;
    private int seaLevel;
    private int airPollution;
    private int oceanAcidification;
    private int bioDiversity;
    private int greenhouseGases;
    private int weatherEvents;
    private int deaths;
    private int socialInequity;

    public  AnswerImpact(){
        temp=0;
        co2=0;
        seaLevel=0;
        airPollution=0;
        oceanAcidification=0;
        bioDiversity=0;
        greenhouseGases=0;
        weatherEvents=0;
        deaths=0;
        socialInequity=0;
    }

    public AnswerImpact(int temp, int co2, int seaLevel, int airPollution, int oceanAcidification, int bioDiversity, int greenhouseGases, int weatherEvents, int deaths, int socialInequity) {
        this.temp = temp;
        this.co2 = co2;
        this.seaLevel = seaLevel;
        this.airPollution = airPollution;
        this.oceanAcidification = oceanAcidification;
        this.bioDiversity = bioDiversity;
        this.greenhouseGases = greenhouseGases;
        this.weatherEvents = weatherEvents;
        this.deaths = deaths;
        this.socialInequity = socialInequity;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getCo2() {
        return co2;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    public int getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(int seaLevel) {
        this.seaLevel = seaLevel;
    }

    public int getAirPollution() {
        return airPollution;
    }

    public void setAirPollution(int airPollution) {
        this.airPollution = airPollution;
    }

    public int getOceanAcidification() {
        return oceanAcidification;
    }

    public void setOceanAcidification(int oceanAcidification) {
        this.oceanAcidification = oceanAcidification;
    }

    public int getBioDiversity() {
        return bioDiversity;
    }

    public void setBioDiversity(int bioDiversity) {
        this.bioDiversity = bioDiversity;
    }

    public int getGreenhouseGases() {
        return greenhouseGases;
    }

    public void setGreenhouseGases(int greenhouseGases) {
        this.greenhouseGases = greenhouseGases;
    }

    public int getWeatherEvents() {
        return weatherEvents;
    }

    public void setWeatherEvents(int weatherEvents) {
        this.weatherEvents = weatherEvents;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getSocialInequity() {
        return socialInequity;
    }

    public void setSocialInequity(int socialInequity) {
        this.socialInequity = socialInequity;
    }
}
