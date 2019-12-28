package com.marki.mipan.model;

public class Message{
    private long time;
    private String messages;
    private int type;

    public Message( ) {
    }

    @Override
    public String toString() {
        return "Message{" +
                "time=" + time +
                ", messages='" + messages + '\'' +
                ", type=" + type +
                '}';
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}