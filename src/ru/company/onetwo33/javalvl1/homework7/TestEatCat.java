package ru.company.onetwo33.javalvl1.homework7;

import java.util.Random;

public class TestEatCat {

    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        Plate plate = new Plate(100);
        Random r = new Random();

        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Barsik" + i, r.nextInt(50));
        }

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat.isFill());
            if (plate.getFood() < 25)
                plate.increaseFood(50);
            plate.info();
        }
    }
}
