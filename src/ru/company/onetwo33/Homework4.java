package ru.company.onetwo33;

import java.util.Random;
import java.util.Scanner;

public class Homework4 {

    private static final int SIZE = 5;
    private static final char[][] map = new char[SIZE][SIZE];

    private static final char DOT_EMPTY = '*';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final int countWin = 4;

    public static final Scanner SCANNER = new Scanner(System.in);


    public static void main(String[] args) {
        initializeGame();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkEndGame(DOT_X)) break;

            computerTurn();
            printMap();
            if (checkEndGame(DOT_O)) break;
        }
    }

    private static boolean checkEndGame(char symbol) {
        if (checkWin(symbol)) {
            System.out.println(isHumanTurn(symbol) ? "Человек победил!" : "Компьютер победил!");
            return true;
        }
        if (isMapFull()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static boolean isMapFull() {
        for (char[] rows : map) {
            for (char cellValue : rows) {
                if (cellValue == DOT_EMPTY) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean checkWin(char symbol) {
        int count = 0;

        // check rows
        for (int columnIndex = 0; columnIndex < SIZE; columnIndex++) {
            count = 0;
            for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
                if (count >= countWin) return true;
                if (map[columnIndex][rowIndex] == symbol) count++;
                else count = 0;
            }
        }

        // check reverse rows
        for (int columnIndex = SIZE - 1; columnIndex >= 0; columnIndex--) {
            count = 0;
            for (int rowIndex = SIZE - 1; rowIndex >= 0; rowIndex--) {
                if (count >= countWin) return true;
                if (map[columnIndex][rowIndex] == symbol) count++;
                else count = 0;
            }
        }

        // check columns
        for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
            count = 0;
            for (int columnIndex = 0; columnIndex < SIZE; columnIndex++) {
                if (count >= countWin) return true;
                if (map[columnIndex][rowIndex] == symbol) count++;
                else count = 0;
            }
        }

        // check reverse columns
        for (int rowIndex = SIZE - 1; rowIndex >= 0; rowIndex--) {
            count = 0;
            for (int columnIndex = SIZE - 1; columnIndex >= 0; columnIndex--) {
                if (count >= countWin) return true;
                if (map[columnIndex][rowIndex] == symbol) count++;
                else count = 0;
            }
        }

        // check diagonal 1
        count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (count >= countWin) return true;
            if (map[i][i] == symbol) count++;
            else count = 0;
        }

        // check reverse diagonal 1
        count = 0;
        for (int i = SIZE - 1; i >= 0; i--) {
            if (count >= countWin) return true;
            if (map[i][i] == symbol) count++;
            else count = 0;
        }

        // check diagonal 2
        count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (count >= countWin) return true;
            if (map[i][map.length - 1 - i] == symbol) count++;
            else count = 0;
        }

        // check reverse diagonal 2
        count = 0;
        for (int i = SIZE - 1; i >= 0; i--) {
            if (count >= countWin) return true;
            if (map[i][map.length - 1 - i] == symbol) count++;
            else count = 0;
        }

        return false;
    }

    private static int[] preCheckWin() {
        int count = 0;

        // check rows
        for (int columnIndex = 0; columnIndex < SIZE; columnIndex++) {
            count = 0;
            for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
                if (map[columnIndex][rowIndex] == DOT_EMPTY && count == countWin - 1) return new int[]{columnIndex, rowIndex};
                if (map[columnIndex][rowIndex] == DOT_X) count++;
                else count = 0;
            }
        }

        // check reverse rows
        for (int columnIndex = SIZE - 1; columnIndex >= 0; columnIndex--) {
            count = 0;
            for (int rowIndex = SIZE - 1; rowIndex >= 0; rowIndex--) {
                if (map[columnIndex][rowIndex] == DOT_EMPTY && count == countWin - 1) return new int[]{columnIndex, rowIndex};
                if (map[columnIndex][rowIndex] == DOT_X) count++;
                else count = 0;
            }
        }

        // check columns
        for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
            count = 0;
            for (int columnIndex = 0; columnIndex < SIZE; columnIndex++) {
                if (map[columnIndex][rowIndex] == DOT_EMPTY && count == countWin - 1) return new int[]{columnIndex, rowIndex};
                if (map[columnIndex][rowIndex] == DOT_X) count++;
                else count = 0;
            }
        }

        // check reverse columns
        for (int rowIndex = SIZE - 1; rowIndex >= 0; rowIndex--) {
            count = 0;
            for (int columnIndex = SIZE - 1; columnIndex >= 0; columnIndex--) {
                if (map[columnIndex][rowIndex] == DOT_EMPTY && count == countWin - 1) return new int[]{columnIndex, rowIndex};
                if (map[columnIndex][rowIndex] == DOT_X) count++;
                else count = 0;
            }
        }

        // check diagonal 1
        count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == DOT_EMPTY && count == countWin - 1) return new int[]{i, i};
            if (map[i][i] == DOT_X) count++;
            else count = 0;
        }

        // check reverse diagonal 1
        count = 0;
        for (int i = SIZE - 1; i >= 0; i--) {
            if (map[i][i] == DOT_EMPTY && count == countWin - 1) return new int[]{i, i};
            if (map[i][i] == DOT_X) count++;
            else count = 0;
        }

        // check diagonal 2
        count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][map.length - 1 - i] == DOT_EMPTY && count == countWin - 1) return new int[]{i, map.length - 1 - i};
            if (map[i][map.length - 1 - i] == DOT_X) count++;
            else count = 0;
        }

        // check reverse diagonal 2
        count = 0;
        for (int i = SIZE - 1; i >= 0; i--) {
            if (map[i][map.length - 1 - i] == DOT_EMPTY && count == countWin - 1) return new int[]{i, map.length - 1 - i};
            if (map[i][map.length - 1 - i] == DOT_X) count++;
            else count = 0;
        }

        return null;
    }

    private static void humanTurn() {
        int rowIndex = -1;
        int colIndex = -1;
        do {
            System.out.print("Введите номер строки: ");
            if (!SCANNER.hasNextInt()) {
                SCANNER.nextLine();
                System.out.println("Введите число!");
                continue;
            }
            rowIndex = SCANNER.nextInt() - 1;

            System.out.print("Введите номер столбца: ");
            if (!SCANNER.hasNextInt()) {
                SCANNER.nextLine();
                System.out.println("Введите число!");
                continue;
            }
            colIndex = SCANNER.nextInt() - 1;

//        String data = SCANNER.nextLine(); // 1 3
//        String[] parts = data.split(" ");
//        int rowIndex = Integer.parseInt(parts[0]);
//        int colIndex = Integer.parseInt(parts[1]);
        } while (!isValidCell(rowIndex, colIndex, DOT_X));

        map[rowIndex][colIndex] = DOT_X;
    }

    private static void computerTurn() {
        int rowIndex;
        int colIndex;
        if (preCheckWin() != null) {
            int[] coordinate = preCheckWin();
            rowIndex = coordinate[0];
            colIndex = coordinate[1];
        } else {
            Random rand = new Random();
            do {
                rowIndex = rand.nextInt(SIZE);
                colIndex = rand.nextInt(SIZE);
            } while (!isValidCell(rowIndex, colIndex, DOT_O));
        }

        map[rowIndex][colIndex] = DOT_O;
    }

    private static boolean isValidCell(int rowIndex, int colIndex, char symbol) {
        if (!isArrayIndexValid(rowIndex) || (!isArrayIndexValid(colIndex))) {
            System.out.println("Индексы строки и колонки должны быть в диапазоне от 1 до " + SIZE);
            return false;
        }
        if (map[rowIndex][colIndex] != DOT_EMPTY) {
            if (isHumanTurn(symbol)) {
                System.out.println("Данная ячейка уже занята!");
            }
            return false;
        }
        return true;
    }

    private static boolean isHumanTurn(char symbol) {
        return symbol == DOT_X;
    }

    private static boolean isArrayIndexValid(int index) {
        return index >= 0 && index < SIZE;
    }

    private static void printMap() {
        printHeader();
        printMapState();
        System.out.println();
    }

    private static void printMapState() {
        for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
            System.out.print((rowIndex + 1) + " ");
            for (int colIndex = 0; colIndex < SIZE; colIndex++) {
                System.out.print(map[rowIndex][colIndex] + " ");
            }
            System.out.println();
        }
    }

    private static void printHeader() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void initializeGame() {
        for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
            for (int colIndex = 0; colIndex < SIZE; colIndex++) {
                map[rowIndex][colIndex] = DOT_EMPTY;
            }
        }
    }

}
