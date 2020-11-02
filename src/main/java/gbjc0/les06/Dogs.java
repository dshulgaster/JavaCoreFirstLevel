package gbjc0.les06;

public class Dogs extends Animals {
    public String color;

    public void setParameters(int limitDistanceRunning, int limitDistanceSwimming, int limitDistanceJumping) {
        super.limitDistanceRunning = limitDistanceRunning;
        super.limitDistanceSwimming = limitDistanceSwimming;
        super.limitDistanceJumping = limitDistanceJumping;
//        super.limitDistanceRunning = 500;
//        super.limitDistanceSwimming = 1;
//        super.limitDistanceJumping = 10;
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

    public Dogs(String name) {
        super(name);
    }

    public Dogs(String name, String color) {
        super(name);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dogs{" +
                "color=" + color +
                ", name='" + name + '\'' +
                '}';
    }
}
