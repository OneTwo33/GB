package ru.company.onetwo33;

import java.util.Arrays;

public class Homework2 {
    public static void main(String[] args) {
        // Задание 1
        int[] arr = {0, 1, 0, 1, 1, 0};

        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    arr[i] = 1;
                    break;
                case 1:
                    arr[i] = 0;
                    break;
                default:
                    break;
            }
        }

        // Задание 2
        int[] arr2 = new int[8];
        int num = 0;

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = num;
            num += 3;
        }

        // Задание 3
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) arr3[i] *= 2;
        }

        // Задание 4
        int[][] arr4 = new int[5][5];

        for (int i = 0; i < arr4.length; i++) {
            arr4[i][i] = 1;
            arr4[i][arr4.length-1-i] = 1;
        }

        // Задание 5
        int[] arr5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, -9, 1};
        int max = arr5[0];
        int min = arr5[0];

        for (int j : arr5) {
            if (j > max) max = j;
            if (j < min) min = j;
        }

        // Задание 6
        int[] arr6 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(arr6));

        // Задание 7
        int[] arr7 = {1, 2, 3, 4, 5};
        shiftArr(arr7, -3);
        Arrays.stream(arr7).forEach(System.out::println);
    }

    public static boolean checkBalance(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = 0; j <= i; j++) {
                sumLeft += arr[j];
            }
            for (int k = arr.length-1; k > i; k--) {
                sumRight += arr[k];
            }
            if (sumLeft == sumRight) return true;
        }
        return false;
    }

    public static void shiftArr(int[] arr, int n) {
        if (n > 0) { // сдвиг вправо
            for (int i = 0; i < n; i++) {
                int temp = arr[arr.length-1];
                for (int j = arr.length-1; j > 0; j--) {
                    arr[j] = arr[j-1];
                }
                arr[0] = temp;
            }
        } else // сдвиг влево
        for (int i = 0; i < -n; i++) {
            int temp = arr[0];
            for (int j = 0; j < arr.length-1; j++) {
                arr[j] = arr[j+1];
            }
            arr[arr.length-1] = temp;
        }

    }
}
