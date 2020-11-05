package gbjc0.les07;

import java.util.Random;
import java.util.Scanner;

public class MainAnimalsEating {
    public static Random random = new Random();
    public static Scanner scaner = new Scanner(System.in);
    public final static int totalCats = 3;
    public final static int totalDogs = 4;
    public static Cats[] cat = new Cats[totalCats];
    public static Dogs[] dog = new Dogs[totalDogs];
    public static Plate[] catPlate = new Plate[totalCats];  // для каждого кота заведем свою тарелку
    public static Plate[] dogPlate = new Plate[totalCats];  // для каждой собаки заведем свою тарелку

    public static void main(String[] args) {
        fillCats();         // заполняем котов
        fillPlateForCats(cat, catPlate); // заполняем тарелки для котов
        eatingCat(cat); // кормим кошек - каждую из своей тарелки

        System.out.println("А собаки поедят из одной миски!!!");
        fillDogs();         // заполняем собак
        // заполняем одну тарелку для собак
        dogPlate[0] = new Plate((int)(fullRandomMinMax(0, 3) * dog[0].getAppetite()));     // массив - на случай расширения задачи
        eatingDog(dog); // кормим собак - всех из одной тарелки

        System.out.println("Кошек кормить не будем, но если ты хочешь покормить собак, нажми 'y'");
        if (isContinue()) {
            System.out.println("Сейчас у собак в миске кол-во еды = " + dogPlate[0].getFood() +
                    ". А суммарный их аппетит = " + countSumAppetite(dog) + ".");
            System.out.println("Чтобы накормить всех собак, тебе нужно добавить не менее " +
                    (countSumAppetite(dog) - dogPlate[0].getFood()) +
                    " - помни об этом и введи количество еды, которую добавим в общую миску: ");
            dogPlate[0].addFood(scaner.nextInt());
            System.out.println("Теперь у собак в миске кол-во еды = " + dogPlate[0].getFood() +
                    ". Пусть еще поедят...");
            eatingDog(dog);
        } else {
            System.out.println("Очень жаль, собачки будут голодными ( Пока, жадина!");
        }

//        checkAnimal(cat);   // проверяем котов
//        checkAnimal(dog);   // проверяем собак
//        System.out.println("Всего животных: " + dog[0].countAnimal +
//                "; кошек: " + cat[0].countCats +
//                "; собак: " + dog[0].countDogs + ".");     // проверяем счетчик всех животных, кошек и собак
    }

    public static void checkAnimal(Animals[] animal) {
        int personalDistanceRunning, personalDistanceSwimming, personalDistanceJumping;
        for (int i = 0; i < animal.length; i++) {
            System.out.println("Животное " + (i+1) + " (" + animal[i].getKindOfAnimal() + "): " + animal[i].toString());
            animal[i].infoAboutAnimal();
            System.out.println("Ограничение: бег = " + animal[i].limitDistanceRunning +
                    "; прыжок = " + animal[i].limitDistanceJumping + "; заплыв = " + animal[i].limitDistanceSwimming);
            personalDistanceRunning = 50 + random.nextInt(250);
            if (animal[i].isAbleRunning(personalDistanceRunning)) {
                System.out.print("True для бега: ");
                animal[i].animalRunning(personalDistanceRunning);
            } else System.out.println("False для бега: " + personalDistanceRunning);
            personalDistanceJumping = random.nextInt(3);

            if (animal[i].isAbleJumping(personalDistanceJumping)) {
                System.out.print("True для прыжка: ");
                animal[i].animalJumping(personalDistanceJumping);
            } else System.out.println("False для прыжка: " + personalDistanceJumping);

            personalDistanceSwimming = random.nextInt(50);
            if (animal[i].isAbleSwiming(personalDistanceSwimming)) {
                System.out.print("True для заплыва: ");
                animal[i].animalJumping(personalDistanceSwimming);
            } else System.out.println("False для заплыва: " + personalDistanceSwimming);
            System.out.println();
        }
    }

    public static void fillCats() {
        cat[0] = new Cats("Бесстрашный котяра Матроскин", "black");
        cat[0].setParameters(200, 0, 2, 100);
        cat[1] = new Cats("Отчаянный кот Василий", "red");
        cat[1].setParameters(190, 0, 3, 200);
        cat[2] = new Cats("Милая кошечка Маруся", "white");
        cat[2].setParameters(210, 0, 3, 150);
    }

    public static void fillDogs() {
        dog[0] = new Dogs("Бесшабашный Шарик", "braun");
        dog[0].setParameters(450, 1, 10, 40);
        dog[1] = new Dogs("Добродушный Бетховен", "red");
        dog[1].setParameters(480, 2, 8, 90);
        dog[2] = new Dogs("Грозный Хуч", "white");
        dog[2].setParameters(500, 0, 12, 120);
        dog[3] = new Dogs("Бульдог Спайк", "blue-white");
        dog[3].setParameters(600, 4, 15, 280);
    }

    public static void fillPlateForCats(Cats[] cat, Plate[] catPlate) {
        for (int i = 0; i < cat.length; i++) {
            catPlate[i] = new Plate((int)(fullRandomMinMax(0, 2) * cat[i].getAppetite()));
        }
    }

    // кормление кошек
    public static void eatingCat(Cats[] cat) {
        for (int i = 0; i < cat.length; i++) {
            System.out.println(catPlate[i].toString());
            System.out.println(cat[i].toString());
            cat[i].animalEating(catPlate[i]);
            System.out.println();
        }
    }

    // кормление собак
    public static void eatingDog(Dogs[] dog) {
        for (int i = 0; i < dog.length; i++) {
            System.out.println(dogPlate[0].toString());
            System.out.println(dog[i].toString());
            dog[i].animalEating(dogPlate[0]);
            System.out.println();
        }
    }

    // рандомно накладываем еду в тарелку
    // заполняем массив случайными числами, задаем размер массива, max и min значение в нем
    public static double fullRandomMinMax(int min, int max) {
        return (Math.random() * (max - min)) + min;
    }

    // суммарный аппетит собак
    public static int countSumAppetite(Dogs[] dog) {
        int sumAppetite = 0;
        for (int i = 0; i < dog.length; i++) {
            sumAppetite += dog[i].appetite;
        }
        return sumAppetite;
    }

    public static boolean isContinue() {
        char isYes = scaner.next().charAt(0);
        if (isYes == 'y') return true;
        else return false;
    }

}
