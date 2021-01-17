package ru.company.onetwo33;

public class TestAnimals {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 1, "Black");
        Dog dog = new Dog("Rex", 4, "White");

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
}
