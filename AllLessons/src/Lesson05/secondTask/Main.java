package Lesson05.secondTask;

public class Main {

    public static void main(String[] args) {

        TelephoneDirectory directory = new TelephoneDirectory();

        Human alice = new Human("Алиса", "+1234567890");
        Human bobFirst = new Human("Боб", "+0987654321");
        Human bobSecond = new Human("Боб", "+2544554");

        directory.addEntry(alice);
        directory.addEntry(bobFirst);
        directory.addEntry(bobSecond);

        directory.findByName("Боб");
    }
}
