package edu.washington.ttulga.quizdroid;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mbmtuvshin on 2/16/15.
 */
public class Topic implements Serializable{
    private String title;
    private String shortDesc;
    private String longDesc;
    private ArrayList<Quiz> questions;

    public Topic() {
        //questions = new ArrayList<Quiz>();
    }

    public String getTitle() {
        return title;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public ArrayList<Quiz> getQuestions() {
        return questions;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShortDesc(String desc) {
        this.shortDesc = desc;
    }

    public void setLongDesc(String desc) {
        this.longDesc = desc;
    }

    public void setQuestions(ArrayList<Quiz> questions) {
        this.questions = questions;
    }
}
