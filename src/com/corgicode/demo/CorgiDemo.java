package com.corgicode.demo;

public class CorgiDemo {
    public static void main(String args[]) {
        Corgi corgi = new Corgi("Brum Brao");
        Ball ball = new Ball("red");
        CorgiGUI corgiGui = new CorgiGUI(corgi, ball);
    }
}
