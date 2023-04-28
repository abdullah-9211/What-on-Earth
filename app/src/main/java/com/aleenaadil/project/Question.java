package com.aleenaadil.project;

public class Question {
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private int coins1;
    private int coins2;
    private int coins3;
    private AnswerImpact answerImpact1;
    private AnswerImpact answerImpact2;
    private AnswerImpact answerImpact3;

    public Question(){
        question="";
        option1="";
        option2="";
        option3="";
        coins1=0;
        coins2=0;
        coins3=0;
        answerImpact1=new AnswerImpact();
        answerImpact2=new AnswerImpact();
        answerImpact3=new AnswerImpact();
    }

    public Question(String question, String option1, String option2, String option3, int coins1, int coins2, int coins3, AnswerImpact answerImpact1, AnswerImpact answerImpact2, AnswerImpact answerImpact3) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.coins1 = coins1;
        this.coins2 = coins2;
        this.coins3 = coins3;
        this.answerImpact1 = answerImpact1;
        this.answerImpact2 = answerImpact2;
        this.answerImpact3 = answerImpact3;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getCoins1() {
        return coins1;
    }

    public void setCoins1(int coins1) {
        this.coins1 = coins1;
    }

    public int getCoins2() {
        return coins2;
    }

    public void setCoins2(int coins2) {
        this.coins2 = coins2;
    }

    public int getCoins3() {
        return coins3;
    }

    public void setCoins3(int coins3) {
        this.coins3 = coins3;
    }

    public AnswerImpact getAnswerImpact1() {
        return answerImpact1;
    }

    public void setAnswerImpact1(AnswerImpact answerImpact1) {
        this.answerImpact1 = answerImpact1;
    }

    public AnswerImpact getAnswerImpact2() {
        return answerImpact2;
    }

    public void setAnswerImpact2(AnswerImpact answerImpact2) {
        this.answerImpact2 = answerImpact2;
    }

    public AnswerImpact getAnswerImpact3() {
        return answerImpact3;
    }

    public void setAnswerImpact3(AnswerImpact answerImpact3) {
        this.answerImpact3 = answerImpact3;
    }
}
