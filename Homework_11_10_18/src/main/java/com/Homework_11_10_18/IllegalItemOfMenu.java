package com.Homework_11_10_18;

public class IllegalItemOfMenu extends RuntimeException{
    public IllegalItemOfMenu() {
    }

    public IllegalItemOfMenu(String message) {
        super(message);
    }
}
