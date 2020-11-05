package gbjc0.les06;

public abstract class Animals {
    protected String name;
    protected String kindOfAnimal;
    protected int limitDistanceRunning;
    protected int limitDistanceSwimming;
    protected int limitDistanceJumping;
    public static int countAnimal;

    public abstract void setParameters(int limitDistanceRunning, int limitDistanceSwimming, int limitDistanceJumping);

    public void setKindOfAnimal(String kindOfAnimal) {
        this.kindOfAnimal = kindOfAnimal;
    }

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    public Animals(String name) {
        this.name = name;
        countAnimal++;
    }

    public void infoAboutAnimal() {
        System.out.println("Животное зовется " + name);
    }

    public void animalRunning(int distance) {
//        this.distance = distance;
        System.out.println(" пробежал " + distance + " метров.");
    }

    public void animalSwimming(int distance) {
        System.out.println(" проплыл " + distance + " метров.");
    }

    public void animalJumping(int heght) {
        System.out.println(" подпрыгнул на " + heght + " метров.");
    }

    public abstract boolean isAbleRunning(int distance);
    public abstract boolean isAbleSwiming(int distance);
    public abstract boolean isAbleJumping(int distance);

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                '}';
    }
}