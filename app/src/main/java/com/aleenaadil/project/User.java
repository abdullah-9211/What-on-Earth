package com.aleenaadil.project;

public class User {
    private String name;
    private String email;
    private String password;
    private int coins;
    private int year;
    private int deaths;
    private int population;
    private Continent asia, africa, europe, northAmerica, southAmerica, oceania;
    private double temperature;


    public User(){
        name = "";
        email = "";
        password = "";
        coins = 0;
        year = 0;
        deaths = 0;
        population = 0;
        asia = new Continent();
        africa = new Continent();
        europe = new Continent();
        northAmerica = new Continent();
        southAmerica = new Continent();
        oceania = new Continent();
        temperature = 0;
    }

    public User(String name, String email, String password, int coins, int days, int deaths, int population, Continent asia, Continent africa, Continent europe, Continent northAmerica, Continent southAmerica, Continent oceania, double temperature) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.coins = coins;
        this.year = days;
        this.deaths = deaths;
        this.population = population;
        this.asia = asia;
        this.africa = africa;
        this.europe = europe;
        this.northAmerica = northAmerica;
        this.southAmerica = southAmerica;
        this.oceania = oceania;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int days) {
        this.year = days;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Continent getAsia() {
        return asia;
    }

    public void setAsia(Continent asia) {
        this.asia = asia;
    }

    public Continent getAfrica() {
        return africa;
    }

    public void setAfrica(Continent africa) {
        this.africa = africa;
    }

    public Continent getEurope() {
        return europe;
    }

    public void setEurope(Continent europe) {
        this.europe = europe;
    }

    public Continent getNorthAmerica() {
        return northAmerica;
    }

    public void setNorthAmerica(Continent northAmerica) {
        this.northAmerica = northAmerica;
    }

    public Continent getSouthAmerica() {
        return southAmerica;
    }

    public void setSouthAmerica(Continent southAmerica) {
        this.southAmerica = southAmerica;
    }

    public Continent getOceania() {
        return oceania;
    }

    public void setOceania(Continent oceania) {
        this.oceania = oceania;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
