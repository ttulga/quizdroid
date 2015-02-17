package edu.washington.ttulga.quizdroid;

import java.io.Serializable;

public class Quiz implements Serializable {
    private String question;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    private int indexOfCorrect;

    public Quiz() {
    }

    public String getQuestion() {
        return question;
    }

    public String getAns1() {
        return ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public int getIndexOfCorrect() {
        return indexOfCorrect;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAns1(String answer) {
        this.ans1 = answer;
    }

    public void setAns2(String answer) {
        this.ans2 = answer;
    }

    public void setAns3(String answer) {
        this.ans3 = answer;
    }

    public void setAns4(String answer) {
        this.ans4 = answer;
    }

    public void setIndexOfCorrect(int index) {
        this.indexOfCorrect = index;
    }
}
