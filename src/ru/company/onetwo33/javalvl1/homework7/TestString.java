package ru.company.onetwo33.javalvl1.homework7;

public class TestString {
    public static void main(String[] args) {
        String s = "I like Java!!!";
        // a) Напишите метод, который принимает в качестве параметра любую строку, например “I like Java!!!”.
        print(s);
        // б) Распечатать последний символ строки. Используем метод String.charAt().
        System.out.println(s.charAt(s.length()-1));
        // в) Проверить, заканчивается ли ваша строка подстрокой “!!!”. Используем метод String.endsWith().
        System.out.println(s.endsWith("!!!"));
        // г) Проверить, начинается ли ваша строка подстрокой “I like”. Используем метод String.startsWith().
        System.out.println(s.startsWith("I like"));
        // д) Проверить, содержит ли ваша строка подстроку “Java”. Используем метод String.contains().
        System.out.println(s.contains("Java"));
        // e) Найти позицию подстроки “Java” в строке “I like Java!!!”.
        System.out.println(s.indexOf("Java"));
        // ж) Заменить все символы “а” на “о”.
        System.out.println(s.replace("a", "o"));
        // з) Преобразуйте строку к верхнему регистру.
        System.out.println(s.toUpperCase());
        // и) Преобразуйте строку к нижнему регистру.
        System.out.println(s.toLowerCase());
        // к) Вырезать строку Java c помощью метода String.substring().
        System.out.println(s.substring(2, 6));
    }

    public static void print(String s) {
        System.out.println(s);
    }
}
