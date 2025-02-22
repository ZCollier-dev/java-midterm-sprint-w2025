import java.util.Scanner;

public class Person {
    private static int idCounter = 1;
    private int id;
    private String name;
    private int age;
    private String phoneNumber;

    // Constructor with parameters
    public Person(String name, int age, String phoneNumber) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // Interactive constructor using Scanner
    public Person(Scanner scanner) {
        this.id = idCounter++;
        this.name = getInput(scanner, "Enter Name: ");
        this.age = Integer.parseInt(getInput(scanner, "Enter Age: "));
        this.phoneNumber = getInput(scanner, "Enter Phone Number: ");
    }

    private static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Phone: " + phoneNumber;
    }
}
