package ru.company.onetwo33;

public class Main {
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
        System.out.println(isRangeTenToTwenty(9));

        // Задание 5
        printPositiveOrNegative(-1);

        // Задание 6
        System.out.println(isPositive(0));

        // Задание 7
        printGreeting("Алексей");

        // Задание 8
        System.out.println(isLeapYear(2020));
    }

    public static float exp(float a, float b, float c, float d) {
        return a * (b + (c/d));
    }

    public static boolean isRangeTenToTwenty(int num) {
        return (num >= 10) && (num <= 20);
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

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else return year % 4 == 0;
    }
}
