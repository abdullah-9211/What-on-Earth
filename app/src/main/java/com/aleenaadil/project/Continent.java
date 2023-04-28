package com.aleenaadil.project;

public class Continent {
    private String name;
    private AnswerImpact stats;

    public Continent(){
        name = "";
        stats = new AnswerImpact();
    }

    public Continent(String name, AnswerImpact stats) {
        this.name = name;
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnswerImpact getStats() {
        return stats;
    }

    public void setStats(AnswerImpact stats) {
        this.stats = stats;
    }
}
