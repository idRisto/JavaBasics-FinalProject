package com.testi.demo;

public class OnlineCourse extends Course{
    private String url;

    public OnlineCourse(String courseName, String teacher, String url){
        super(courseName, teacher);
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString(){
        return courseName + "--" + teacher + "--" + url + "--online";
    }
}
