package com.marki.mipan.model;

public class Message {
    private long time;
    private String text;

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "time=" + time +
                ", text='" + text + '\'' +
                '}';
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
