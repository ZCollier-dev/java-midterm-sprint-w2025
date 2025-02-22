import java.time.LocalDate;
import java.util.Scanner;

class Prescription {
    private static int idCounter = 1;
    private String id;
    private String doctorId;
    private String patientId;
    private String medicationId;
    private LocalDate issueDate;
    private LocalDate expiryDate;

    // Constructor with parameters
    public Prescription(String doctor, String patient, String medication) {
        this.id = "PRES" + idCounter++;
        this.doctorId = doctor;
        this.patientId = patient;
        this.medicationId = medication;
        this.issueDate = LocalDate.now();
        this.expiryDate = issueDate.plusYears(1);
    }

    // Interactive constructor using Scanner
    public Prescription(Scanner scanner) {
        this.id = "PRES" + idCounter++;
        System.out.print("Enter Doctor ID: ");
        this.doctorId = scanner.nextLine();
        System.out.print("Enter Patient ID: ");
        this.patientId = scanner.nextLine();
        System.out.print("Enter Medication ID: ");
        this.medicationId = scanner.nextLine();
        this.issueDate = LocalDate.now();
        this.expiryDate = issueDate.plusYears(1);
    }

    public String getId() {
        return id;
    }

    public String getDoctor() {
        return doctorId;
    }

    public String getPatient() {
        return patientId;
    }

    public String getMedication() {
        return medicationId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void printPrescriptionDetails() {
        System.out.println("==== Prescription Details ====");
        System.out.println("Prescription ID: " + id);
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Medication ID: " + medicationId);
        System.out.println("Issue Date: " + issueDate);
        System.out.println("Expiry Date: " + expiryDate);
    }
}
