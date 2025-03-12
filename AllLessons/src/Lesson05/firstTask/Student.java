package Lesson05.firstTask;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private Integer group;
    private Integer course;
    private ArrayList<Integer> grades;

    public Student(String name, Integer group, Integer course, ArrayList<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double studentGPA() {
        int totalSum = 0;
        if (grades.isEmpty()) {
            throw new IllegalStateException("Оценки отсутствуют.");
        }
        for (int grades : grades) {
            totalSum += grades;
        }
        return totalSum / grades.toArray().length;
    }

}


