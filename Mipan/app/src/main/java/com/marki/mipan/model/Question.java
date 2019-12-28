package com.marki.mipan.model;

public class Question {
    public String[] getCheck_values() {
        return check_values;
    }

    public void setCheck_values(String[] check_values) {
        this.check_values = check_values;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIs_required() {
        return is_required;
    }

    public void setIs_required(boolean is_required) {
        this.is_required = is_required;
    }

    public String getQ_type() {
        return q_type;
    }

    public void setQ_type(String q_type) {
        this.q_type = q_type;
    }

    private String[] check_values;
    private String description;
    private boolean is_required;
    private String q_type;
}
