import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MedicationTrackingSystem {
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;
    private ArrayList<Prescription> prescriptions;
    private ArrayList<Medication> medications;

    public MedicationTrackingSystem() {
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
        this.medications = new ArrayList<>();
    }

    // Adding new entities
    public void addDoctor(Scanner scanner) {
        Doctor doctor = new Doctor(scanner);
        doctors.add(doctor);
        System.out.println("Doctor added successfully.");
    }

    public void addPatient(Scanner scanner) {
        Patient patient = new Patient(scanner);
        patients.add(patient);
        System.out.println("Patient added successfully.");
    }

    public void addMedication(Scanner scanner) {
        Medication medication = new Medication(scanner);
        medications.add(medication);
        System.out.println("Medication added successfully.");
    }

    public void addPrescription(Scanner scanner) {
        Prescription prescription = new Prescription(scanner);
        prescriptions.add(prescription);
        System.out.println("Prescription added successfully.");
    }

    // Deleting entities
    public void deletePatient(Scanner scanner) {
        System.out.print("Enter Patient Name to Delete: ");
        String name = scanner.nextLine();
        patients.removeIf(patient -> patient.getName().equalsIgnoreCase(name));
        System.out.println("Patient deleted successfully.");
    }

    public void deleteDoctor(Scanner scanner) {
        System.out.print("Enter Doctor Name to Delete: ");
        String name = scanner.nextLine();
        doctors.removeIf(doctor -> doctor.getName().equalsIgnoreCase(name));
        System.out.println("Doctor deleted successfully.");
    }

    public void deleteMedication(Scanner scanner) {
        System.out.print("Enter Medication Name to Delete: ");
        String name = scanner.nextLine();
        medications.removeIf(med -> med.getName().equalsIgnoreCase(name));
        System.out.println("Medication deleted successfully.");
    }

    // Editing entities
    public void editPatient(Scanner scanner) {
        System.out.print("Enter Patient Name to Edit: ");
        String name = scanner.nextLine();
        patients.stream().filter(patient -> patient.getName().equalsIgnoreCase(name)).findFirst().ifPresent(patient -> {
            System.out.print("Enter new phone number: ");
            patient.setPhoneNumber(scanner.nextLine());
            System.out.print("Enter new age: ");
            patient.setAge(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Patient details updated.");
        });
    }

    public void editDoctor(Scanner scanner) {
        System.out.print("Enter Doctor Name to Edit: ");
        String name = scanner.nextLine();
        doctors.stream().filter(doctor -> doctor.getName().equalsIgnoreCase(name)).findFirst().ifPresent(doctor -> {
            System.out.print("Enter new phone number: ");
            doctor.setPhoneNumber(scanner.nextLine());
            System.out.print("Enter new specialization: ");
            doctor.setSpecialization(scanner.nextLine());
            System.out.println("Doctor details updated.");
        });
    }

    public void editMedication(Scanner scanner) {
        System.out.print("Enter Medication Name to Edit: ");
        String name = scanner.nextLine();
        medications.stream().filter(med -> med.getName().equalsIgnoreCase(name)).findFirst().ifPresent(med -> {
            System.out.print("Enter new dosage: ");
            med.setDosage(scanner.nextLine());
            System.out.print("Enter new quantity: ");
            med.setQuantityInStock(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Medication details updated.");
        });
    }

    // Search functionalities
    public void searchPatientByName(Scanner scanner) {
        System.out.print("Enter Patient Name to Search: ");
        String name = scanner.nextLine();
        patients.stream().filter(patient -> patient.getName().equalsIgnoreCase(name)).forEach(System.out::println);
    }

    public void searchDoctorByName(Scanner scanner) {
        System.out.print("Enter Doctor Name to Search: ");
        String name = scanner.nextLine();
        doctors.stream().filter(doctor -> doctor.getName().equalsIgnoreCase(name)).forEach(System.out::println);
    }

    public void searchMedicationByName(Scanner scanner) {
        System.out.print("Enter Medication Name to Search: ");
        String name = scanner.nextLine();
        medications.stream().filter(med -> med.getName().equalsIgnoreCase(name)).forEach(System.out::println);
    }

    // Assign patient to doctor
    public void assignPatientToDoctor(Scanner scanner) {
        System.out.print("Enter Doctor Name: ");
        String doctorName = scanner.nextLine();
        System.out.print("Enter Patient Name: ");
        String patientName = scanner.nextLine();
        doctors.stream().filter(doc -> doc.getName().equalsIgnoreCase(doctorName)).findFirst().ifPresent(doc -> {
            patients.stream().filter(patient -> patient.getName().equalsIgnoreCase(patientName)).findFirst().ifPresent(patient -> {
                doc.addPatient(patient.getName());
                System.out.println("Patient assigned to doctor successfully.");
            });
        });
    }

    // Print prescriptions by doctor
    public void printPrescriptionsByDoctor(Scanner scanner) {
        System.out.print("Enter Doctor Name: ");
        String doctorName = scanner.nextLine();
        System.out.println("Prescriptions issued by Dr. " + doctorName + ":");
        prescriptions.stream()
                .filter(prescription -> prescription.getDoctor().equalsIgnoreCase(doctorName))
                .forEach(Prescription::printPrescriptionDetails);
    }

    // Existing methods remain unchanged
    public void printAllDoctors() {
        doctors.forEach(System.out::println);
    }

    public void printAllPatients() {
        patients.forEach(System.out::println);
    }

    public void printAllMedications() {
        medications.forEach(System.out::println);
    }

    public void printAllPrescriptions() {
        prescriptions.forEach(Prescription::printPrescriptionDetails);
    }

    public void checkExpiredMedications() {
        System.out.println("Expired Medications:");
        medications.stream().filter(med -> med.getExpiryDate().isBefore(LocalDate.now())).forEach(System.out::println);
    }

    public void restockMedication(Scanner scanner) {
        System.out.print("Enter Medication Name to Restock: ");
        String name = scanner.nextLine();
        System.out.print("Enter Quantity to Add: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        medications.stream().filter(med -> med.getName().equalsIgnoreCase(name)).findFirst().ifPresentOrElse(
            med -> {
                med.setQuantityInStock(med.getQuantityInStock() + quantity);
                System.out.println("Medication restocked successfully.");
            },
            () -> System.out.println("Medication not found.")
        );
    }

    public void systemReport() {
        System.out.println("==== SYSTEM REPORT ====");
        System.out.println("Total Doctors: " + doctors.size());
        System.out.println("Total Patients: " + patients.size());
        System.out.println("Total Medications: " + medications.size());
        System.out.println("Total Prescriptions: " + prescriptions.size());
    }
}
