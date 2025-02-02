package Lesson03.firstTask;

public class Cat extends Animal {
    int satiety;
    private static int catCount = 0;

    public Cat(String name) {
        super(name);
        catCount++;
        this.satiety = 0;
    }

    @Override
    public void run(int length) {
        if (length > 200) {
            System.out.println("Кот " + this.animalName + " так далеко не побежит");
        } else {
            System.out.println("Кот " + this.animalName + " пробежал " + length + " метров");
        }
    }

    @Override
    public void swim(int length) {
        System.out.println("Кот " + this.animalName + " не может плавать");
    }

    public static int catCount() {
        return catCount;
    }

    public boolean eatFromBowl(Bowl bowl, int amount) {
        if (bowl.getFoodAmount() >= amount) {
            bowl.reduceAmount(amount);
            satiety = satiety + amount;
            System.out.println(true + " : Кот " + this.animalName + " поел," + " сытость: " + this.satiety);
            return true;
        } else {
            System.out.println(false + " : В миске недостаточно еды для кота - " + this.animalName + " сытость: " + this.satiety);
            return false;
        }
    }

}