package com.corgicode.demo;

// A class that represents a ball object
class Ball {
    // Attributes of a ball
    private String color; // the color of the ball

    // Constructor of a ball
    public Ball(String color) {
        this.color = color;
    }

// Methods of a ball

    // A method that returns the color of the ball
    public String getColor() {
        return this.color;
    }

    // A method that throws the ball
    public void throwBall() {
        System.out.println("The " + this.getColor() + " ball is thrown.");
    }
}
