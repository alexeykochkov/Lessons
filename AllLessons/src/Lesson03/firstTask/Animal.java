
package Lesson03.firstTask;

import java.util.Random;

public class Animal {

    protected final String animalName;

    public Animal(String name) {
        this.animalName = name;
    }

    public void run(int length) {
        System.out.println(animalName + " пробежал " + length + " метров.");
    }

    public void swim(int length) {
        System.out.println(animalName + " проплыл " + length + " метров.");
    }

}
