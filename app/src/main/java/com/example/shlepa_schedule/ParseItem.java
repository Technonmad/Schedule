package com.example.shlepa_schedule;

public class ParseItem {

    private String groupNumber;
    private String className;

    public ParseItem(String groupUrl, String classUrl){
        this.groupNumber = groupUrl;
        this.className = classUrl;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
