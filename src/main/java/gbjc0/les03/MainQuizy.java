package gbjc0.les03;

import java.util.Random;
import java.util.Scanner;

public class MainQuizy {
    public static final Scanner scaner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Хочешь поиграть в игру 1 или 2 (нажми для ответа 1 или 2)?");
        int numberGame = scaner.nextInt();
        if (numberGame == 1) {
            quiz1();
        } else {
            System.out.println("Вторую игру я еще не придумал");
        }

        /*
        2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
        Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
        apple – загаданное
        apricot - ответ игрока
        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        Для сравнения двух слов посимвольно, можно пользоваться:
        String str = "apple";
        str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        Играем до тех пор, пока игрок не отгадает слово
        Используем только маленькие буквы*/

    }

    public static void quiz1() {
        // 1. Написать программу, которая загадывает случайное число от 0 до 9,
        // и пользователю дается 3 попытки угадать это число. При каждой попытке
        // компьютер должен сообщить больше ли указанное пользователем число чем загаданное,
        // или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз?
        // 1 – да / 0 – нет»(1 – повторить, 0 – нет).
        System.out.println("1. Требуется отгадать задуманное программой число.");
        System.out.println("У вас 3 попытки. Погнали!");
        int countTrying = 3;                // количество попыток
        int quessedNumber;                  // число, введенное пользователем, в надежде угадать загаданное число

        Random random = new Random();
        int randomNumber = random.nextInt(10);
        int currentCount = 1;
        int isContinue = 0;     // закончим игру или продолжим
//        System.out.println(randomNumber);
        while (true) {
            System.out.println("Попытка №" + currentCount + ". Угадай число от 0 до 9, которое я загадал: ");
            quessedNumber = scaner.nextInt();
            if (quessedNumber == randomNumber) {
                System.out.println("Вы угадали число! Поздравляю, это действительно " + quessedNumber + "! Использовано " + countTrying + " попыток.");
                System.out.println("Продолжим игру? (1 - да; 0 - нет, закончим игру.)");
                isContinue = scaner.nextInt();
                if (isContinue == 1) {
                    currentCount = 1;
                    continue;
                } else {
                    System.out.println("Ну ок, тогда пока!");
                    break;
                }
            } else if (currentCount == countTrying) {
                System.out.println("Все попытки потрачены! Сегодня не Ваш день! Но может все не так? ");
                System.out.println("Продолжим игру? (1 - да; 0 (или любое другое) - нет, закончим игру.)");
                isContinue = scaner.nextInt();
                if (isContinue == 1) {
                    currentCount = 1;
                    continue;
                } else {
                    System.out.println("Ну ок, тогда пока!");
                    break;
                }
            } else {
                ++currentCount;
                System.out.println("Вы не угадали!");
                if (quessedNumber > randomNumber) {
                    System.out.println("Искомое число меньше.");
                } else {
                    System.out.println("Искомое число больше.");
                }
                System.out.println("У вас осталась " + currentCount + " попыток! Попробуй еще: ");
            }
        }


    }
}
