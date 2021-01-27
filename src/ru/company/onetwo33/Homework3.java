package ru.company.onetwo33;

import java.util.Random;
import java.util.Scanner;

public class Homework3 {

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        String secretWord = words[random.nextInt(words.length)];

        System.out.println("Какое слово я загадал?");

        while (true) {
            String guess = scan.nextLine();
            if (secretWord.equals(guess)) {
                System.out.println("Вы отгадали!");
                break;
            }

            // Узнаем минимальную длину слова для сравнения, чтобы не вылететь за пределы массива
            int minLengthWord = Math.min(secretWord.length(), guess.length());

            // Маска для подсказки из 15 символов
            String guessedLetter = "###############";

            // Сравниваем посимвольно загаданное и введенное пользователем слово, формируем подсказку
            for (int i = 0; i < minLengthWord; i++) {
                if (secretWord.charAt(i) == guess.charAt(i)) {
                    char[] chars = guessedLetter.toCharArray();
                    chars[i] = secretWord.charAt(i);
                    guessedLetter = String.valueOf(chars);
                }
            }
            System.out.println(guessedLetter);
            System.out.println("Попробуйте еще раз!");
        }
    }
}
