package ru.company.onetwo33;

public abstract class Animal {
//    капсом именуются только static final поля, то есть константы. В данном случае надо просто countAnimals
//    private static int COUNT_ANIMALS = 0;
    private static int countAnimals = 0;

    private String name;
    private int age;
    private String color;

    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
        countAnimals++;
    }

//    так как методы всегда переопределяются в дочерних классах, делаем их абстрактными
//    public void run(double value) {}
//
//    public void swim(double value) {}
//
//    public void jump(double value) {}

    public abstract void run(double value);

    public abstract void swim(double value);

    public abstract void jump(double value);

    public void printCount() {}

    public static void printAllCount() {
        System.out.println(countAnimals);
    }

}
