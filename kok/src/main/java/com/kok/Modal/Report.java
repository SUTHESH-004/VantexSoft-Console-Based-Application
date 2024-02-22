package com.kok.Modal;

public class Report {
    String name;
    String PresentOrNot;
    String Output;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPresentOrNot() {
        return PresentOrNot;
    }
    public void setPresentOrNot(String presentOrNot) {
        if(presentOrNot.equals("P")){
        PresentOrNot = "Present";
        }
        else
        {
            PresentOrNot="Absent";
        }
    }
    public String getOutput() {
        return Output;
    }
    public void setOutput(String output) {
        Output = output;
    }
    
    
}
