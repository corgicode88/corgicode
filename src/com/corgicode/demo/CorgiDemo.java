package com.corgicode.demo;

public class CorgiDemo {
    public static Corgi corgi = new Corgi("Brum Brao");
    public static Ball ball = new Ball("red");
    public static void main(String args[]) {
        CorgiGUI corgiGui = new CorgiGUI(corgi, ball);
    }
}
