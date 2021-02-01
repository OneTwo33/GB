package ru.company.onetwo33;

public class Dog extends Animal {

    private static int countDogs = 0;
    double maxJump;
    double maxRun;
    double maxSwim;

    public Dog(String name, int age, String color, double maxJump, double maxRun, double maxSwim) {
        super(name, age, color);
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        countDogs++;
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
        System.out.println(countDogs);
    }
}
