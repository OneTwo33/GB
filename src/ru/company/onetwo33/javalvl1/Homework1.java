package ru.company.onetwo33.javalvl1;

public class Homework1 {
    public static void main(String[] args) {
        // Задание 2
        byte b = 100;
        short s = 10_000;
        int i = 1_000_000_000;
        long l = 100_000_000_000L;

        float f = 3.33F;
        double d = 3.3333D;

        char c = 'a';

        boolean bool = true;

        // Задание 3
        System.out.println(exp(3, 2, 4, 7));

        // Задание 4
        System.out.println(isSumInRange10To20(9, 1));

        // Задание 5
        printPositiveOrNegative(-1);

        // Задание 6
        System.out.println(isPositive(0));

        // Задание 7
        printGreeting("Алексей");

        // Задание 8
        isLeapYear(2020);
    }

    public static float exp(float a, float b, float c, float d) {
        return a * (b + (c/d));
    }

    public static boolean isSumInRange10To20(int a, int b) {
        int sum = a + b;
        return (sum >= 10) && (sum <= 20);
    }

    public static void printPositiveOrNegative(int num) {
        System.out.println(num >= 0 ? "Число положительное" : "Число отрицательное");
    }

    public static boolean isPositive(int num) {
        return num >= 0;
    }

    public static void printGreeting(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void isLeapYear(int year) {
        if (year % 400 == 0) {
            System.out.println("Високосный");
        } else if (year % 100 == 0) {
            System.out.println("Не високосный");
        } else if (year % 4 == 0) {
            System.out.println("Високосный");
        } else
            System.out.println("Не високосный");
    }
}
