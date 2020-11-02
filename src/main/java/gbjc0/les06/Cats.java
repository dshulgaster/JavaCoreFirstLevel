package gbjc0.les06;

public class Cats extends Animals {
//    private static int limitDistanceRunning = 200;
//    private static int limitDistanceSwimming = 0;
//    private static int limitDistanceJumping = 2;
//    public static String kindOfAnimal = "Cat";
    public String color;
    public static int countCats;

    public void setParameters(int limitDistanceRunning, int limitDistanceSwimming, int limitDistanceJumping) {
        super.limitDistanceRunning = limitDistanceRunning;
        super.limitDistanceSwimming = limitDistanceSwimming;
        super.limitDistanceJumping = limitDistanceJumping;
        //        super.limitDistanceRunning = 200;
        //        super.limitDistanceSwimming = 0;
        //        super.limitDistanceJumping = 2;
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

    public Cats(String name) {
        super(name);
        countCats++;
    }

    public Cats(String name, String color) {
        super(name);
        this.color = color;
        countCats++;
    }

    @Override
    public String toString() {
        return "Cats{" +
                "color=" + color +
                ", name='" + name + '\'' +
                '}';
    }
}
