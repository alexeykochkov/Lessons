package Lesson02;

public class Employee {
    private String name;
    private String job_title;
    private String email;
    private String telephone_number;
    private int salary;
    private int age;

    public Employee(String name, String job_title, String email, String telephone_number, int salary, int age) {
        this.name = name;
        this.job_title = job_title;
        this.email = email;
        this.telephone_number = telephone_number;
        this.salary = salary;
        this.age = age;
    }

    public void printInfoEmployee() {
        System.out.println("Name: " + name);
        System.out.println("Job Title: " + job_title);
        System.out.println("Email: " + email);
        System.out.println("Telephone Number: " + telephone_number);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {

        Employee[] emplArray = new Employee[5];

        emplArray[0] = new Employee("Bob", "Grave Digger", "bob@gg.com", "+78885553322", 2300, 18);
        emplArray[1] = new Employee("Eric", "Cockroach Seller", "eric@gg.com", "+78889995544", 2100, 20);
        emplArray[2] = new Employee("Marty", "Crocodile Finder", "marty@gg.com", "+78884445566", 4500, 30);
        emplArray[3] = new Employee("Sally", "Frog Rescuer", "sally@gg.com", "+78888884422", 3200, 25);
        emplArray[4] = new Employee("Dolly", "Carries Pencils", "dolly@gg.com", "+78881112255", 7500, 40);

        for (Employee person : emplArray) {
            System.out.println("-------------");
            person.printInfoEmployee();
        }
    }
}
