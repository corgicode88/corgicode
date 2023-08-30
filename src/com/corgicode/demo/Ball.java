package com.corgicode.demo;

class Ball {
    private String color; // the color of the ball

    public Ball(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void throwBall() {
        System.out.println("The " + this.getColor() + " ball is thrown.");
    }
}
