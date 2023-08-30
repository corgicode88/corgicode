package com.corgicode.demo;

class Corgi {
    private String name; // the name of the corgi
    private int energy; // the energy level of the corgi, from 0 to 100
    private int mood; // the mood of the corgi, from -50 to 50
    private boolean isPlaying; // whether the corgi is playing fetch or not

    public Corgi(String name) {
        this.name = name;
        this.energy = 100;
        this.mood = 0;
        this.isPlaying = false;
    }

    public String getName() {
        return this.name;
    }

    public int getEnergy() {
        return this.energy;
    }

    public int getMood() {
        return this.mood;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
        if (this.energy < 0) {
            this.energy = 0;
        }
        if (this.energy > 100) {
            this.energy = 100;
        }
    }

    public void setMood(int mood) {
        this.mood = mood;
        if (this.mood < -50) {
            this.mood = -50;
        }
        if (this.mood > 50) {
            this.mood = 50;
        }
    }

    public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public void bark() {
        System.out.println("Woof woof!");
        this.setEnergy(this.getEnergy() - 10); // barking reduces energy by 10
        this.setMood(this.getMood() + 10); // barking increases mood by 10
    }

    public void wagTail() {
        System.out.println("Wag wag wag!");
        this.setEnergy(this.getEnergy() - 5); // wagging tail reduces energy by 5
        this.setMood(this.getMood() + 5); // wagging tail increases mood by 5
    }

    public void playFetch(Ball ball) {
        System.out.println("Fetch!");
        ball.throwBall(); // throw the ball
        this.setPlaying(true); // set the playing status to true
        this.setEnergy(this.getEnergy() - 20); // playing fetch reduces energy by 20
        this.setMood(this.getMood() + 20); // playing fetch increases mood by 20
    }

    public void doTrick(String trick) {
        System.out.println("Trick: " + trick);
        switch (trick) { // different tricks have different effects on energy and mood
            case "sit":
                this.setEnergy(this.getEnergy() - 5);
                this.setMood(this.getMood() + 5);
                break;
            case "roll over":
                this.setEnergy(this.getEnergy() - 10);
                this.setMood(this.getMood() + 10);
                break;
            case "shake paw":
                this.setEnergy(this.getEnergy() - 5);
                this.setMood(this.getMood() + 5);
                break;
            case "speak":
                this.bark(); // calling the bark method
                break;
            default:
                System.out.println("Unknown trick");
                break;
        }

    }

    @Override
    public String toString() {
        return "Corgi{" +
                "name='" + name + '\'' +
                ", energy=" + energy +
                ", mood=" + mood +
                ", isPlaying=" + isPlaying +
                '}';
    }
}