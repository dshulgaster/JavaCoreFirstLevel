package gbjc0.les06;

import java.util.Random;

public class MainLifeOfAnimals {
    public static Random random = new Random();
    public final static int totalCats = 3;
    public final static int totalDogs = 4;
    public static Cats[] cat = new Cats[totalCats];
    public static Dogs[] dog = new Dogs[totalDogs];

    public static void main(String[] args) {
        fillCats();         // заполняем котов
        fillDogs();         // заполняем собак
        checkAnimal(cat);   // проверяем котов
        checkAnimal(dog);   // проверяем собак
        System.out.println("Всего животных: " + dog[0].countAnimal +
                "; кошек: " + cat[0].countCats +
                "; собак: " + dog[0].countDogs + ".");     // проверяем счетчик всех животных, кошек и собак
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
        dog[3] = new Dogs("Бульдог Спайк", "blue-white");
        dog[3].setParameters(600, 4, 15);
    }
}
