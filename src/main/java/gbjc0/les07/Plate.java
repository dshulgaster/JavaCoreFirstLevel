package gbjc0.les07;

public class Plate {
    private static int ADDFOOD = 50;

    protected int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    // устарел, используем методы addFood() и getFood()
    public void setFood(int food) {
        this.food = food;
    }

    public void addFood(int food) {
        this.food += food;
    }

    public void minusFood(int appetite) {
        this.food -= appetite;
    }

    public void minusFoodOld(int minusFood) {   // не совсем по заданию, поэтому временно не используется
        // проверка, что еды не стало меньше 0!
        while (true) {
//            System.out.println("this.food = " + this.food + "; minusFood = " + minusFood);
            if (this.food > minusFood) {
                this.food -= minusFood;
                break;
            } else if (this.food == minusFood) {
                this.food = 0;
                System.out.println("Хозяин, я съел всю еду, в тарелке ничего не осталось! " +
                        "Наложи еще перед следующей кормёжкой!");
                break;
            } else {
                System.out.println("Хозяин, я съел всю еду и мне не хватило! Наложи еще хотя бы " + ADDFOOD);
                this.addFood(ADDFOOD);
            }
        }
    }



    public boolean isMoreFood(int appetite) {
        if (this.food >= appetite) {
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}
