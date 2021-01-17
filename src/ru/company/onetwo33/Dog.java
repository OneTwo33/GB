package ru.company.onetwo33;

public class Dog extends Animal {

    private static int COUNT_DOGS = 0;
    double maxJump;
    double maxRun;
    double maxSwim;

    public Dog(String name, int age, String color) {
        super(name, age, color);
        maxJump = Animal.getRandParameter(0, 3.5);
        maxRun = Animal.getRandParameter(250, 600);
        maxSwim = Animal.getRandParameter(0, 15);
        COUNT_DOGS++;
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
        if (this.maxSwim <= value)
            System.out.println("run: true");
        else
            System.out.println("run: false");
    }

    @Override
    public void jump(double value) {
        if (this.maxJump <= value)
            System.out.println("run: true");
        else
            System.out.println("run: false");
    }

    @Override
    public void printCount() {
        System.out.println(COUNT_DOGS);
    }
}
