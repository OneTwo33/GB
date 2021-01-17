package ru.company.onetwo33;

import java.util.Random;

public abstract class Animal {

    private static int COUNT_ANIMALS = 0;

    private String name;
    private int age;
    private String color;

    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
        COUNT_ANIMALS++;
    }

    public void run(double value) {}

    public void swim(double value) {}

    public void jump(double value) {}

    public void printCount() {}

    public static void printAllCount() {
        System.out.println(COUNT_ANIMALS);
    }

    public static double getRandParameter (double from, double to) {
        Random r = new Random();
        double randomValue = from + (to - from) * r.nextDouble();
        return randomValue;
    }

}
