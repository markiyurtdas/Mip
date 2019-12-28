package com.marki.mipan.model;

public class User {
    private static final User ourInstance = new User();

    public static User getInstance() {
        return ourInstance;
    }

    private User() {
    }
}
