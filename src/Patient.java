import java.util.ArrayList;
import java.util.Scanner;

public class Patient extends Person {
    private ArrayList<String> medicationIds = new ArrayList<>();
    private ArrayList<String> prescriptionIds = new ArrayList<>();

    // Constructor with parameters
    public Patient(String name, int age, String phone) {
        super(name, age, phone);
    }

    // Interactive constructor using Scanner
    public Patient(Scanner scanner) {
        super(
            getInput(scanner, "Enter Patient Name: "),
            Integer.parseInt(getInput(scanner, "Enter Patient Age: ")),
            getInput(scanner, "Enter Patient Phone Number: ")
        );
    }

    private static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void setMedications(ArrayList<String> meds) {
        this.medicationIds = meds;
    }

    public void setPrescriptions(ArrayList<String> prescripts) {
        this.prescriptionIds = prescripts;
    }

    public ArrayList<String> getMedications() {
        return this.medicationIds;
    }

    public ArrayList<String> getPrescriptions() {
        return this.prescriptionIds;
    }

    public void addMedication(String med) {
        this.medicationIds.add(med);
    }

    public void addPrescription(String pres) {
        this.prescriptionIds.add(pres);
    }

    public void removeMedication(String med) {
        if (this.medicationIds.contains(med)) {
            this.medicationIds.remove(med);
        } else {
            System.out.println("Medication not found.");
        }
    }

    public void removePrescription(String pres) {
        if (this.prescriptionIds.contains(pres)) {
            this.prescriptionIds.remove(pres);
        } else {
            System.out.println("Prescription not found.");
        }
    }

    public String getOneMedication(String med) {
        if (this.medicationIds.contains(med)) {
            return med;
        } else {
            return "Medication not found.";
        }
    }

    public String getOnePrescription(String pres) {
        if (this.prescriptionIds.contains(pres)) {
            return pres;
        } else {
            return "Prescription not found.";
        }
    }

    @Override
    public String toString() {
        return "Patient Name: " + getName() + ", Age: " + getAge() + ", Phone: " + getPhoneNumber() + ", Medications: " + medicationIds + ", Prescriptions: " + prescriptionIds;
    }
}
