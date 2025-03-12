package Lesson05.firstTask;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        CatalogueOfStudents catalogue = new CatalogueOfStudents();

        Student student1 = new Student("Пётр", 302, 2, new ArrayList<>(Arrays.asList(4, 2, 5)));
        Student student2 = new Student("Василий", 303, 1, new ArrayList<>(Arrays.asList(2, 2, 3)));
        Student student3 = new Student("Михаил", 405, 3, new ArrayList<>(Arrays.asList(4, 4, 5)));
        Student student4 = new Student("Александр", 222, 1, new ArrayList<>(Arrays.asList(2, 2, 2)));
        Student student5 = new Student("Николай", 804, 4, new ArrayList<>(Arrays.asList(4, 2, 3)));

        catalogue.addStudent(student1);
        catalogue.addStudent(student2);
        catalogue.addStudent(student3);
        catalogue.addStudent(student4);
        catalogue.addStudent(student5);

        catalogue.printStudents(1);

        catalogue.transferStudentsByNextCourse();
        catalogue.deleteStudentWithLowGPA();
    }
}
