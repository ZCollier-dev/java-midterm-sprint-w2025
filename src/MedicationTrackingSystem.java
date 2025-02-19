import java.util.ArrayList;

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
        doctors.removeIf(doctor -> doctor.getName().equalsIgnoreCase(name));
    }

    public void deletePatient(String name) {
        patients.removeIf(patient -> patient.getName().equalsIgnoreCase(name));
    }

    public void deleteMedication(String name) {
        medications.removeIf(medication -> medication.getName().equalsIgnoreCase(name));
    }

    public void searchMedication(String name) {
        for (Medication medication : medications) {
            if (medication.getName().equalsIgnoreCase(name)) {
                System.out.println("Medication found: " + medication.getName() + ". Number in stock: " + medication.getQuantityInStock());
                return;
            }
        }
        System.out.println("Medication not found.");
    }

    public void checkExpiredMedications() {
        for (Medication medication : medications) {
            if (medication.getExpiryDate().isBefore(java.time.LocalDate.now())) {
                System.out.println("Expired medications on file: " + medication.getName());
            }
        }
    }

    public void restockMedication(String name, int amount) {
        for (Medication medication : medications) {
            if (medication.getName().equalsIgnoreCase(name)) {
                medication.setQuantityInStock(medication.getQuantityInStock() + amount);
                System.out.println(name + " , amount restocked: " + amount);
                return;
            }
        }
        System.out.println("Medication not found.");
    }

    public void printAllDoctors() {
        for (Doctor doctor : doctors) {
            System.out.println("Doctor: " + doctor.getName() + ", Specialization: " + doctor.getSpecialization());
        }
    }

    public void printAllPatients() {
        for (Patient patient : patients) {
            System.out.println("Patient: " + patient.getName() + ", Age: " + patient.getAge() + ", Phone Number: " + patient.getPhone());
        }
    }

    public void printAllMedications() {
        for (Medication medication : medications) {
            System.out.println("Medication: " + medication.getName() + ", Dosage: " + medication.getDosage() + ", In stock: " + medication.getQuantityInStock() + ", Expiry: " + medication.getExpiryDate());
        }
    }

    public void printAllPrescriptions() {
        for (Prescription prescription : prescriptions) {
            prescription.printPrescriptionDetails();
        }
    }

    public void assignPatientToDoctor(String doctorName, String patientName) {
        Doctor doctor = null;
        for (Doctor doc : doctors) {
            if (doc.getName().equalsIgnoreCase(doctorName)) {
                doctor = doc;
                break;
            }
        }
        if (doctor != null) {
            for (Patient patient: patients) {
                if (patient.getName().equalsIgnoreCase(patientName)) {
                    doctor.addPatient(patientName);
                    System.out.println("Patient " + patientName + "has been assigned to Dr. " + doctorName);
                    return;
                }
            }
            System.out.println("Patient " + patientName + "not found.");
        } else {
            System.out.println("Doctor " + doctorName + "not found.");
        }
    }

    public void systemReport() {
        System.out.println("==== SYSTEM REPORT: ====");
        System.out.println("Doctors: " + doctors.size());
        System.out.println("Patients: " + patients.size());
        System.out.println("Medications: " + medications.size());
        System.out.println("Prescriptions: " + prescriptions.size());
    }

}
