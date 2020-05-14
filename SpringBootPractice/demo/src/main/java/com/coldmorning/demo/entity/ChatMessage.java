package com.coldmorning.demo.entity;

public class ChatMessage {

    private String from;
    private String text;
    private String time;
    // getters and setters

    public String getFrom() {
        return from;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
