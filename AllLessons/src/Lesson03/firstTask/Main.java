package Lesson03.firstTask;

public class Main {
    public static void main(String[] args) {

        Bowl bowl = new Bowl(10);
        Cat[] cats = {
                new Cat("Белка"),
                new Cat("Стрелка"),
                new Cat("Бублик")
        };

        System.out.println("Количество котов - " + Cat.catCount());

        for (Cat cat : cats) {
            cat.eatFromBowl(bowl, 5);
        }

        bowl.addFood(10);

        Dog dog1 = new Dog("Мухтар");
        dog1.run(200);
        dog1.swim(50);
        System.out.println("Количество собак - " + Dog.dogCount());
    }
}
