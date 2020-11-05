package gbjc0.les07;

public class Cats extends Animals {
    public String color;
    public static int countCats;

    public Cats(String name) {
        super(name);
        countCats++;
    }

    public Cats(String name, String color) {
        super(name);
        this.color = color;
        countCats++;
    }

    public void setParameters(int limitDistanceRunning, int limitDistanceSwimming, int limitDistanceJumping,
                              int appetite) {
        super.limitDistanceRunning = limitDistanceRunning;
        super.limitDistanceSwimming = limitDistanceSwimming;
        super.limitDistanceJumping = limitDistanceJumping;
        super.appetite = appetite;
        super.kindOfAnimal = "Cat";
    }

    public boolean isAbleRunning(int distance) {
        return distance <= limitDistanceRunning;
    }

    public boolean isAbleSwiming(int distance) {
        return  distance <= limitDistanceSwimming;
    }

    public boolean isAbleJumping(int distance) {
        return distance <= limitDistanceJumping;
    }

    @Override
    public String toString() {
        return "Cats{" +
                "color=" + color +
                ", name='" + name + '\'' +
                ", appetite=" + appetite +
                '}';
    }
}
