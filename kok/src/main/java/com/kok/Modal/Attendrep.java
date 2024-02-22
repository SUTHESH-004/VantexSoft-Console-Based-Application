package com.kok.Modal;

public class Attendrep {
    String name ;
    int No_of_days;
    int No_presentdays;
    int output;
    public void setOutput(int output) {
        this.output = output;
    }
    public int getOutput() {
        return output;
    }
    public void setNo_of_days(int no_of_days) {
        No_of_days = no_of_days;
    }
    public void setNo_presentdays(int no_presentdays) {
        No_presentdays = no_presentdays;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getNo_of_days() {
        return No_of_days;
    }
    public int getNo_presentdays() {
        return No_presentdays;
    }
}
