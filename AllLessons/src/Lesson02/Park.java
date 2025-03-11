package Lesson02;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private String parkName;
    private final List<Attractions> attractions;

    public Park(String parkName) {
        attractions = new ArrayList<>();
        this.parkName = parkName;
    }

    public void addAttraction(Attractions attraction) {
        attractions.add(attraction);
    }

    public void attractionsInfo() {
        System.out.println("Парк: " + parkName);
        for (Attractions attraction : attractions) {
            System.out.println("Аттракцион: " + attraction.attractionName + ", Открытие: " + attraction.openingTime + ", Закрытие: " + attraction.closingTime + ", Стоимость: " + attraction.cost);
        }
    }

    public class Attractions {
        private final String attractionName;
        private final String openingTime;
        private final String closingTime;
        private final int cost;

        public Attractions(String attractionName, String openingTime, String closingTime, int cost) {
            this.attractionName = attractionName;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Park park = new Park("Климова");
        Attractions mountains = park.new Attractions("Горки", "10:20", "22:00", 200);
        Attractions carousel = park.new Attractions("Карусель", "11:40", "21:30", 150);
        park.addAttraction(mountains);
        park.addAttraction(carousel);
        park.attractionsInfo();
    }
}


