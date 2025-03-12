package Lesson05.firstTask;

import java.util.HashSet;
import java.util.Set;

public class CatalogueOfStudents {
    private final Set<Student> students;
    private final double minimumGPALevel = 3.0;

    public CatalogueOfStudents() {
        students = new HashSet<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudentWithLowGPA() {
        students.removeIf(student -> {
            if (student.studentGPA() < minimumGPALevel) {
                System.out.println(student.getName() + " удален, " + "его GPA - " + student.studentGPA());
                return true;
            }
            return false;
        });
    }

    public void transferStudentsByNextCourse() {
        students.forEach(student -> {
            if (student.studentGPA() >= minimumGPALevel) {
                student.setCourse(student.getCourse() + 1);
                System.out.println(student.getName() + " переведен на следующий курс, " + "его GPA - " + student.studentGPA());
            }
        });
    }

    public void printStudents(int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName() + " находится на " + student.getCourse() + " курсе");
            }
        }
    }
}
