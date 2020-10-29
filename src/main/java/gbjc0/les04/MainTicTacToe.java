package gbjc0.les04;

import java.util.Random;
import java.util.Scanner;

public class MainTicTacToe {
    public static char[][] feild;
    public static final int SIZE = 5;   // размер поля
    public static final int DOTS_TO_WIN = 4;    // необходимая длина ряда для выигрыша
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';   // за крестики играет человек
    public static final char DOT_O = 'O';   // за нолики играет компьютер
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
//        System.out.println("Крестики-нолики");
        initFeild();
        printFeild();
        while (true) {
            humanTurn();
            printFeild();
            if (isWin(feild, DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (!hasEmptyCells(feild)) {
                System.out.println("Ничья");
                break;
            }
            compTurn();
            printFeild();
            if (isWin(feild, DOT_O)) {
                System.out.println("Победил компьютер (нолики)");
                break;
            }
            if (!hasEmptyCells(feild)) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    // ход пользователя
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y в пределах размера поля " + SIZE );
            y = sc.nextInt() - 1;
            x = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        feild[y][x] = DOT_X;
    }

    // ход компьютера
    public static void compTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        feild[y][x] = DOT_O;
    }

    public static boolean hasEmptyCells(char[][] field) {
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == DOT_EMPTY)
                    return true;
            }
        }
        return false;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (feild[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static boolean isWin(char[][] field, char player) {
        // проверка равенства элементов SIZE раз (в общем случае, для определенного кол-во нужно проверять не с SIZE)
        // для более универсального случая требуетс проверка непрерывности крестиков или ноликов
        int countWinHorizontal, countWinVertikal, countWinDiagonal1, countWinDiagonal2;
        countWinDiagonal1 = 0;
        countWinDiagonal2 = 0;
        for (int i = 0; i < SIZE; i++) {
            countWinHorizontal = 0; // проверка равенства по горизонтали
            for (int j = 0; j < SIZE; j++) {

                // проверка вертикали
                countWinVertikal = 0;
                if (i == 0) { // для первой строчки проверяем соблюдается ли хоть одно равенство по столбцам
                    //ДОРАБОТАТЬ: третий цикл здесь не нужен - то же, что и для горизонтали, только не [i][j], a [j][i]
                    for (int k = 0; k < SIZE; k++) {    // пробуем через новый перебор, иначе непонятно как по столбцам пройтись
                        if (field[k][j] == player) {
                            countWinVertikal++;
                            if (countWinVertikal == DOTS_TO_WIN) {  // для частного случая поля 3*3 сравниваем с SIZE
                                return true;
                            }
                        } else countWinVertikal = 0;   // проверка на непрерывность символов для победы
                    }
                }

                // проверка горизонтали
                if (field[i][j] == player) {
                    countWinHorizontal++;
                    if (countWinHorizontal == DOTS_TO_WIN) {    // для частного случая поля 3*3 сравниваем с SIZE
                        return true;
                    }
                } else countWinHorizontal = 0;  // проверка на непрерывность символов для победы

                // проверка прямой диагонали
                if (i == j && field[i][j] == player) {
//                    System.out.println("i, j, player " + i + " " + j + " " + player);
                    countWinDiagonal1++;
                    if (countWinDiagonal1 == DOTS_TO_WIN) { // для частного случая поля 3*3 сравниваем с SIZE
                        return true;
                    }
                } else if (i == j) countWinDiagonal1 = 0;   // проверка на непрерывность символов для победы
                // несколько кривовато - сделано, чтобы не сильно ломать работающий код,
                // о логика верная (вроде бы) - обнуляем только в случае, если это не диагональ, а
                // увеличиваем счетчик, если это и диагональ, и значение равно требуемому

                // проверка обратной диагонали (можно в одну проверку, но для наглядности в учебных целях
                // не стал объединять "два if" в один
                if (i + j == SIZE - 1 && field[i][j] == player) {
//                    System.out.println("i, j, player " + i + " " + j + " " + player);
                    countWinDiagonal2++;
                    if (countWinDiagonal2 == DOTS_TO_WIN) { // для частного случая поля 3*3 сравниваем с SIZE
                        return true;
                    }
                } else if (i + j == SIZE - 1) countWinDiagonal2 = 0;   // проверка на непрерывность символов для победы
                // + см. комментарий по другой диагонали
            }
        }

        /*
        if (field[0][0] == player && field[0][1] == player && field[0][2] == player)
            return true;
        if (field[1][0] == player && field[1][1] == player && field[1][2] == player)
            return true;
        if (field[2][0] == player && field[2][1] == player && field[2][2] == player)
            return true;

        if (field[0][0] == player && field[1][0] == player && field[2][0] == player)
            return true;
        if (field[0][1] == player && field[1][1] == player && field[2][1] == player)
            return true;
        if (field[0][2] == player && field[1][2] == player && field[2][2] == player)
            return true;

        if (field[0][0] == player && field[1][1] == player && field[2][2] == player)
            return true;
        if (field[2][0] == player && field[1][1] == player && field[0][2] == player)
            return true;
        */

        return false;
    }

    public static void initFeild() {
        feild = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                feild[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printFeild() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(feild[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
