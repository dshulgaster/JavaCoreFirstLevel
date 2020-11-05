package gbjc0.les07;

public class Dogs extends Animals {
    public String color;
    public static int countDogs;

    public Dogs(String name) {
        super(name);
        countDogs++;
    }

    public Dogs(String name, String color) {
        super(name);
        this.color = color;
        countDogs++;
    }

    public void setParameters(int limitDistanceRunning, int limitDistanceSwimming, int limitDistanceJumping,
                              int appetite) {
        super.limitDistanceRunning = limitDistanceRunning;
        super.limitDistanceSwimming = limitDistanceSwimming;
        super.limitDistanceJumping = limitDistanceJumping;
        super.appetite = appetite;
        super.kindOfAnimal = "Dog";
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
        return "Dogs{" +
                "color=" + color +
                ", name='" + name + '\'' +
                ", appetite=" + appetite +
                '}';
    }
}
