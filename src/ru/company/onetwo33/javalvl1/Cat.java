package ru.company.onetwo33.javalvl1;

public class Cat extends Animal {

    private static int countCats = 0;
    double maxJump;
    double maxRun;

    public Cat(String name, int age, String color, double maxJump, double maxRun) {
        super(name, age, color);
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        countCats++;
    }

    @Override
    public void printCount() {
        System.out.println(countCats);
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
