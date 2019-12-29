package com.marki.mipan.model;

import java.util.List;

public class FoodMenuWeek {
    private List<String> food_menu_list;

    public List<String> getFood_menu_list() {
        return food_menu_list;
    }

    public void setFood_menu_list(List<String> food_menu_list) {
        this.food_menu_list = food_menu_list;
    }

    @Override
    public String toString() {
        return "FoodMenuWeek{" +
                "food_menu_list=" + food_menu_list +
                '}';
    }
}
