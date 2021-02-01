package ru.company.onetwo33.javalvl1;

import java.util.Random;

public class TestAnimals {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 1, "Black", getRandParameter(0, 3), getRandParameter(100, 300));
        Dog dog = new Dog("Rex", 4, "White", getRandParameter(0, 3.5), getRandParameter(250, 600), getRandParameter(0, 15));

        dog.printCount();
        dog.run(450);
        dog.jump(1.5);
        dog.swim(7);
        cat.printCount();
        cat.jump(0.78);
        cat.run(248);
        cat.swim(45);
        Animal.printAllCount();
    }

//    рандомные значения лучше генерить вне классов и передавать их как параметры. конструктора.
//    К примеру, мы захотим написать тесты на наш код, и для этого нам нужно будет создать сущности с определенными характеристиками,
//    чтобы был предсказуемый тестовый сценарий. Из-за того, что поля всегда имеют рандомные значения, мы этого сделать не сможем.
    public static double getRandParameter(double from, double to) {
        Random r = new Random();
        double randomValue = from + (to - from) * r.nextDouble();
        return randomValue;
    }
}
