import java.time.LocalDate;
import java.util.UUID;

class Doctor {
    private String name;
    private String specialization;
    
    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSpecialization() {
        return specialization;
    }
}

class Patient {
    private String name;
    private int age;
    
    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
}

class Medication {
    private String name;
    private String dosage;
    
    public Medication(String name, String dosage) {
        this.name = name;
        this.dosage = dosage;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDosage() {
        return dosage;
    }
}

class Prescription {
    private String id;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    
    public Prescription(Doctor doctor, Patient patient, Medication medication) {
        this.id = UUID.randomUUID().toString();
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.issueDate = LocalDate.now();
        this.expiryDate = issueDate.plusYears(1);
    }
    
    public String getId() {
        return id;
    }
    
    public Doctor getDoctor() {
        return doctor;
    }
    
    public Patient getPatient() {
        return patient;
    }
    
    public Medication getMedication() {
        return medication;
    }
    
    public LocalDate getIssueDate() {
        return issueDate;
    }
    
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    
    public void printPrescriptionDetails() {
        System.out.println("Prescription ID: " + id);
        System.out.println("Doctor: " + doctor.getName() + " (" + doctor.getSpecialization() + ")");
        System.out.println("Patient: " + patient.getName() + ", Age: " + patient.getAge());
        System.out.println("Medication: " + medication.getName() + " (" + medication.getDosage() + ")");
        System.out.println("Issue Date: " + issueDate);
        System.out.println("Expiry Date: " + expiryDate);
    }
}


