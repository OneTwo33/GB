package ru.company.onetwo33;

public class Cat extends Animal {

    private static int COUNT_CATS = 0;
    double maxJump;
    double maxRun;

    public Cat(String name, int age, String color) {
        super(name, age, color);
        maxJump = Animal.getRandParameter(0, 3);
        maxRun = Animal.getRandParameter(100, 300);
        COUNT_CATS++;
    }

    @Override
    public void printCount() {
        System.out.println(COUNT_CATS);
    }

    @Override
    public void run(double value) {
        if (this.maxRun <= value)
            System.out.println("run: true");
        else
            System.out.println("run: false");
    }

    @Override
    public void swim(double value) {
        System.out.println("Кошки не умеют плавать");
    }

    @Override
    public void jump(double value) {
        if (this.maxJump <= value)
            System.out.println("jump: true");
        else
            System.out.println("jump: false");
    }
}
