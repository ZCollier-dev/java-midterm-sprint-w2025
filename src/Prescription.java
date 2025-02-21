import java.time.LocalDate;
import java.util.UUID;

class Prescription {
    private String id;
    private String doctorId;
    private String patientId;
    private String medicationId;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    
    public Prescription(String doctor, String patient, String medication) {
        this.id = UUID.randomUUID().toString();
        this.doctorId = doctor;
        this.patientId = patient;
        this.medicationId = medication;
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
        System.out.println("Prescription ID: " + id);
        System.out.println("Doctor ID: " + this.doctorId);
        System.out.println("Patient ID: " + this.patientId);
        System.out.println("Medication ID: " + this.medicationId);
        System.out.println("Issue Date: " + issueDate);
        System.out.println("Expiry Date: " + expiryDate);
    }
}


