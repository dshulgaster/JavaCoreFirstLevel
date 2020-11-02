package gbjc0.les06;

import java.util.Random;

public class MainLifeOfAnimals {
    public static Random random = new Random();
    public static Cats[] cat = new Cats[3];
    public static Dogs[] dog = new Dogs[3];

    public static void main(String[] args) {
        /*
        // проверка работы toString для родителя
        Animals animal = new Animals("Черепашка-ниндзя");
        System.out.println(animal.toString());
        animal.animalRunning(450);
        animal.animalSwimming(217);
        animal.animalJumping(7);
        System.out.println();
        */

        fillCats();         // заполняем котов
        fillDogs();         // заполняем собак
        checkAnimal(cat);   // проверяем котов
        checkAnimal(dog);   // проверяем собак
    }

    public static void checkAnimal(Animals[] animal) {
        int personalDistanceRunning, personalDistanceSwimming, personalDistanceJumping;
        for (int i = 0; i < animal.length; i++) {
            //animal[i].setParameters();
            System.out.println("Животное " + (i+1) + " (" + animal[i].getKindOfAnimal() + "): " + animal[i].toString());
            animal[i].infoAboutAnimal();
            System.out.println("Ограничение: бег = " + animal[i].limitDistanceRunning +
                    "; прыжок = " + animal[i].limitDistanceJumping + "; заплыв = " + animal[i].limitDistanceSwimming);
            personalDistanceRunning = 50 + random.nextInt(250);
            if (cat[i].isAbleRunning(personalDistanceRunning)) {
                System.out.println("True для бега: " + personalDistanceRunning);
                cat[i].animalRunning(personalDistanceRunning);
            } else System.out.println("False для бега: " + personalDistanceRunning);
            personalDistanceJumping = random.nextInt(3);

            if (cat[i].isAbleJumping(personalDistanceJumping)) {
                System.out.println("True для прыжка: " + personalDistanceJumping);
                cat[i].animalJumping(personalDistanceJumping);
            } else System.out.println("False для прыжка: " + personalDistanceJumping);

            personalDistanceSwimming = random.nextInt(50);
            if (cat[i].isAbleSwiming(personalDistanceSwimming)) {
                System.out.println("True для заплыва: " + personalDistanceSwimming);
                cat[i].animalJumping(personalDistanceJumping);
            } else System.out.println("False для заплыва: " + personalDistanceSwimming);
            System.out.println();
        }
    }

    public static void fillCats() {
        cat[0] = new Cats("Бесстрашный котяра Матроскин", "black");
        cat[0].setParameters(200, 0, 2);
        cat[1] = new Cats("Отчаянный кот Василий", "red");
        cat[1].setParameters(190, 0, 3);
        cat[2] = new Cats("Милая кошечка Маруся", "white");
        cat[2].setParameters(210, 0, 3);
    }

    public static void fillDogs() {
        dog[0] = new Dogs("Бесшабашный Шарик", "braun");
        dog[0].setParameters(450, 1, 10);
        dog[1] = new Dogs("Добродушный Бетховен", "red");
        dog[1].setParameters(480, 2, 8);
        dog[2] = new Dogs("Грозный Хуч", "white");
        dog[2].setParameters(500, 0, 12);
    }

}
