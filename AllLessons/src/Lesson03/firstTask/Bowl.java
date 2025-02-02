package Lesson03.firstTask;

public class Bowl {
    private int aBowlOfFood;

    public Bowl(int bowl) {
        this.aBowlOfFood = bowl;
    }

    public void reduceAmount(int amount) {
        if (amount <= aBowlOfFood) {
            aBowlOfFood -= amount;
        } else {
            System.out.println("В миске больше нет еды");
        }
    }

    public int getFoodAmount() {
        return aBowlOfFood;
    }

    public void addFood (int food) {
        System.out.println("Добавили в миску " + food + " еды");
        aBowlOfFood = aBowlOfFood + food;
    }

}
