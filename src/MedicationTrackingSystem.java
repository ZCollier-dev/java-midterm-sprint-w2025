import java.util.ArrayList;

public class MedicationTrackingSystem {
    // Attributes
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

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    public void deleteDoctor(String name) {
        doctors.removeIf(doc -> doc.getName().equalsIgnoreCase(name));
    }

    public void deletePatient(String name) {
        patients.removeIf(pat -> pat.getName().equalsIgnoreCase(name));
    }

    public void deleteMedication(String name) {
        medications.removeIf(med -> med.getName().equalsIgnoreCase(name));
    }
}
