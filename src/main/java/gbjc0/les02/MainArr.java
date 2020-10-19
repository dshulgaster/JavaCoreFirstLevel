package gbjc0.les02;

import java.util.Arrays;

public class MainArr {
    public static void main(String[] args) {
        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0.
        int arraySize1 = 10;
        int[] arr1 = new int[arraySize1];
        // заполняем массив
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int)(Math.random() * 2);
        }
        System.out.println("1. Заменить в массиве 0 на 1, 1 на 0");
        System.out.println(Arrays.toString(arr1) + " - первоначальный массив");

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0) {
                arr1[i] = 1;
            } else if (arr1[i] == 1) arr1[i] = 0;
        }
        System.out.println(Arrays.toString(arr1) + " - итоговый массив");

        // 2. Задать пустой целочисленный массив размером 8.
        // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21.
        int[] arr2 = new int[8];
        // заполняем массив
        int delta2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = delta2;
            delta2 += 3;
        }
        System.out.println("2. Заполнить массив значениями 0 3 6 9 12 15 18 21.");
        System.out.println(Arrays.toString(arr2) + " - заполненный массив");

        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом
        // и числа, меньшие 6, умножить на 2;
        int[] arr3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("3. В массиве числа, меньшие 6, умножить на 2.");
        System.out.println(Arrays.toString(arr3) + " - первоначальный массив");
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] = arr3[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr3) + " - итоговый массив");

        // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое) и
        // с помощью цикла(-ов) заполнить его диагональные элементы единицами
        System.out.println("4. Заполнить диагональ квадратной матрицы единицами");
        int[][] arr4 = new int[5][5];
        // заполняем массив (по диаганали 1-ми)
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                if (i == j) {
                    arr4[i][j] = 1;
                } else {
                    arr4[i][j] = (int)(Math.random() * 10);
                }
            }
        }
        // выводим массив
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println(" ");
        }

        // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный
        // элементы (без помощи интернета)
        int[] arr5 = new int[15];
        System.out.println("5. Найдем минимальные и максимальные элементы массива");
        // заполняем массив
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = (int)(Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr5));

        // ищем минимум
        int min5 = arr5[0];
        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] < min5) {
                min5 = arr5[i];
            }
        }
        System.out.println("Минимальное значение в массиве: " + min5);

        // ищем максимум
        int max5 = arr5[0];
        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] > max5) {
                max5 = arr5[i];
            }
        }
        System.out.println("Максимальное значение в массиве: " + max5);

        /*
        6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен
              вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
              Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
              checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||,
              эти символы в массив не входят.
        */
        System.out.println("6. Ищем есть ли в массиве место, где левая и правая от нее части равны.");
        // проверочный пример: int[] arr6 = {5, 4, 3, 1, 0, 0, 1, 1, 3, 1, 5, 3, 4, 3, 2}
        // int[] arr6 = arr5.clone(); // вместо клонирования уже готового массива, решил написать отдельный метод дл заполнения массива
        int[] arr6 = fullArr(50, 0, 10);

        System.out.println(Arrays.toString(arr6));
        // Для проверки левой и правой частей массива используем метод checkEquelArr()
        // checkEquelArrTest(arr6); // тестовая проверка

        if (checkEquelArr(arr6)) {
            System.out.println("Левая и правая части равны на определенном отрезке");
        } else {
            System.out.println("Таких комбинаций нет!");
        }


        /*
        7. **** Написать метод, которому на вход подается одномерный массив и число n
        (может быть положительным, или отрицательным), при этом метод должен сместить все элементы
        массива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        */
        System.out.println("7. Смещаем массив на N");
        int[] arr7 = fullArr(8, -9, 9);
        int shift = 3;
        System.out.println(Arrays.toString(arr7) + " - исходный массив.");
        System.out.println("Сдвиг на N = " + shift);
        shiftArr(arr7, shift);
        System.out.println(Arrays.toString(arr7) + " - смещенный массив.");
    }

    public static void shiftArr(int[] arr, int shift) {
        int buffer;
        for (int i = arr.length-1; i >= 0; i--) {
            if (i - shift >= 0) {
                buffer = arr[i];
                arr[i] = arr[i - shift];
                arr[i - shift] = buffer;
            }
        }
//        System.out.println(Arrays.toString(arr) + " - промужеточно смещенный массив.");
//        // тестирую некорректное начало "хвостика"
        System.out.println("Элемент " + arr.length % shift + " сдвинуть на " + arr.length % shift + " и так " + (shift - arr.length % shift) + " ячейки");
//        // корректирую некорректное начало "хвостика"
//        int firstShiftElement = arr.length % shift;
//        for (int i = 0; i < shift; i++) {
//            buffer = arr[i];
//            arr[i] = arr[firstShiftElement];
//            arr[firstShiftElement] = buffer;
//        }


        // первые числа массива смог заполнить только нулями
        for (int j = 0; j < shift; j++) {
            arr[j] = 0;
        }
    }

    // заполняем массив случайными числами, задаем размер массива, max и min значение в нем
      public static int[] fullArr(int sizeArr, int min, int max) {
        int[] arr = new int[sizeArr];
        // заполняем массив
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((int) (Math.random() * (max - min + 1)) + min);
        }
        return arr;
    }

    // проверка равенство левой и правой части массива
    public static void checkEquelArrTest(int[] arr) {
        int rightPart, leftPart;
        for (int i = 0; i < arr.length; i++) {
            rightPart = 0;
            leftPart = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j <= i) {
                    leftPart += arr[j];
                } else {
                    rightPart += arr[j];
                }
            }
            if (leftPart == rightPart) {
                System.out.println("Левая и правая часть равны!");
                System.out.println("Левая часть: " + leftPart + " . Правая часть: " + rightPart + "; последний индекс левой части: " + i);
            }
        }
    }

    // проверка равенство левой и правой части массива
    public static boolean checkEquelArr(int[] arr) {
        boolean checkBoolean = false;
        int rightPart, leftPart;
        for (int i = 0; i < arr.length; i++) {
            rightPart = 0;
            leftPart = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j <= i) {
                    leftPart += arr[j];
                } else {
                    rightPart += arr[j];
                }
            }
            if (leftPart == rightPart) {
                checkBoolean = true;
            }
        }
        return checkBoolean;
    }

}
