package gbjc0.les07;

public abstract class Animals {
    protected String name;
    protected String kindOfAnimal;
    protected int limitDistanceRunning, limitDistanceSwimming, limitDistanceJumping;
    protected int appetite;
    public static int countAnimal;
    protected boolean satiety;

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    public Animals(String name) {
        this.name = name;
        this.satiety = false;
        countAnimal++;
    }

    public Animals(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
        countAnimal++;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void setKindOfAnimal(String kindOfAnimal) {
        this.kindOfAnimal = kindOfAnimal;
    }

    public void infoAboutAnimal() {
        System.out.println("Животное зовется " + name);
    }

    public void animalRunning(int distance) {
        System.out.println(" пробежал " + distance + " метров.");
    }

    public void animalSwimming(int distance) {
        System.out.println(" проплыл " + distance + " метров.");
    }

    public void animalJumping(int heght) {
        System.out.println(" подпрыгнул на " + heght + " метров.");
    }

    public void animalEating(Plate plate) {
        System.out.println("Я, " + name + ", иду кушать!");
        //plate.minusFood(appetite);
        if (plate.isMoreFood(appetite)) {   // еды больше, удалось покушать
            this.satiety = true;    // аппетит удовлетворен -> true
            plate.minusFood(appetite);
            System.out.println("Ну вот я и поел! В тарелке осталось " + plate.getFood() +
                    "; мой параметр сытности = " + this.satiety);
        } else {
            this.satiety = false;    // аппетит НЕ удовлетворен -> false
            System.out.println("Мне не хватило еды ( Мой параметр сытности = " + this.satiety);
        }

    }

    public abstract boolean isAbleRunning(int distance);
    public abstract boolean isAbleSwiming(int distance);
    public abstract boolean isAbleJumping(int distance);
    public abstract void setParameters(int limitDistanceRunning, int limitDistanceSwimming, int limitDistanceJumping,
                                       int appetite);

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                '}';
    }
}