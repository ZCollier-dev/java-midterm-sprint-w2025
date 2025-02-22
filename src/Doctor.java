import java.util.ArrayList;
import java.util.Scanner;

public class Doctor extends Person {
    private String specialization;
    private ArrayList<String> patientIds = new ArrayList<>();

    // Constructor with parameters
    public Doctor(String name, int age, String phone, String specialization, ArrayList<String> patients) {
        super(name, age, phone);
        this.specialization = specialization;
        this.patientIds = patients;
    }

    // Interactive constructor using Scanner
    public Doctor(Scanner scanner) {
        super(
            getInput(scanner, "Enter Doctor's Name: "),
            Integer.parseInt(getInput(scanner, "Enter Doctor's Age: ")),
            getInput(scanner, "Enter Doctor's Phone Number: ")
        );
        this.specialization = getInput(scanner, "Enter Doctor's Specialization: ");
    }

    private static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setPatients(ArrayList<String> patients) {
        this.patientIds = patients;
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public ArrayList<String> getPatients() {
        return this.patientIds;
    }

    public void addPatient(String patient) {
        this.patientIds.add(patient);
    }

    public void removePatient(String patient) {
        if (this.patientIds.contains(patient)) {
            this.patientIds.remove(patient);
        } else {
            System.out.println("Patient not found.");
        }
    }

    public String getOnePatient(String patient) {
        if (this.patientIds.contains(patient)) {
            return patient;
        } else {
            return "Patient not found.";
        }
    }

    @Override
    public String toString() {
        return "Doctor Name: " + getName() + ", Age: " + getAge() + ", Phone: " + getPhoneNumber() + ", Specialization: " + specialization + ", Patients: " + patientIds.toString();
    }
}
