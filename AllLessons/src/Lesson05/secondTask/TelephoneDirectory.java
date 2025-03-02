package Lesson05.secondTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneDirectory {
    private Map<String, List<Human>> directory;

    public TelephoneDirectory() {
        directory = new HashMap<>();
    }

    public void addEntry(Human human) {
        String name = human.getName();
        if (!directory.containsKey(name)) {
            directory.put(name, new ArrayList<>());
        }
        directory.get(name).add(human);
    }

    public void findByName(String name) {
        List<Human> humans = directory.get(name);
        if (humans != null && !humans.isEmpty()) {
            for (Human human : humans) {
                System.out.println(human.getName() + ": " + human.getTelephone());
            }
        } else {
            System.out.println("Нет людей с именем " + name);
        }
    }
}
