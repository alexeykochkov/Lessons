package Lesson03.firstTask;

public class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int length) {
        if (length > 500) {
            System.out.println("Пёс " + this.animalName + " так далеко не бегает");
        } else {
            System.out.println("Пёс " + this.animalName + " пробежал " + length + " метров");
        }
    }

    @Override
    public void swim(int length) {
        if (length > 10) {
            System.out.println("Пёс " + this.animalName + " так далеко не плавает");
        } else {
            System.out.println("Пёс " + this.animalName + " проплыл " + length + " метров");
        }
    }

    public static int dogCount() {
        return dogCount;
    }
}
