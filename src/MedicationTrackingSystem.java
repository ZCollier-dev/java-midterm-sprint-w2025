import java.time.LocalDate;
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
        for (Patient patient : patients){
            if (patient.getId().equalsIgnoreCase(prescription.getPatient())){
                patient.addPrescription(prescription.getId());
                patient.addMedication(prescription.getMedication());
                break;
            }
        }
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    public void updateDoctorAge(String name, int age){
        for (Doctor doctor : doctors){
            if (doctor.getName().equalsIgnoreCase(name)){
                doctor.setAge(age);
            }
        }
    }

    public void updateDoctorPhone(String name, String phone){
        for (Doctor doctor : doctors){
            if (doctor.getName().equalsIgnoreCase(name)){
                doctor.setPhone(phone);
            }
        }
    }

    public void updatePatientAge(String name, int age){
        for (Patient patient : patients){
            if (patient.getName().equalsIgnoreCase(name)){
                patient.setAge(age);
            }
        }
    }
    public void updatePatientPhone(String name, String phone){
        for (Patient patient : patients){
            if (patient.getName().equalsIgnoreCase(name)){
                patient.setPhone(phone);
            }
        }
    }

    public void updateMedicationDose(String name, String dose){
        for (Medication medication : medications){
            if (medication.getName().equalsIgnoreCase(name)){
                medication.setDosage(dose);
            }
        }
    }

    public void updateMedicationExpiry(String name, LocalDate expiryDate){
        for (Medication medication : medications){
            if (medication.getName().equalsIgnoreCase(name)){
                medication.setExpiryDate(expiryDate);
            }
        }
    }

    public void deleteDoctor(String name) {
        String id = null;
        for (Doctor doctor : doctors){
            if (doctor.getName().equalsIgnoreCase(name)){
                id = doctor.getId();
                break;
            }
        }
        if (id != null){
            String finalId = id;
            doctors.removeIf(doctor -> doctor.getId().equalsIgnoreCase(finalId));
        }
    }

    public void deletePatient(String name) {
        String id = null;
        for (Patient patient : patients){
            if (patient.getName().equalsIgnoreCase(name)){
                id = patient.getId();
                break;
            }
        }
        if (id != null){
            String finalId = id;
            for (Doctor doctor : doctors){
                doctor.removePatient(finalId);
            }
            patients.removeIf(patient -> patient.getId().equalsIgnoreCase(finalId));
        }
    }

    public void deleteMedication(String name) {
        String id = null;
        for (Medication med : medications){
            if (med.getName().equalsIgnoreCase(name)){
                id = med.getId();
                break;
            }
        }
        if (id != null){
            String finalId = id;
            medications.removeIf(medication -> medication.getId().equalsIgnoreCase(finalId));
        }

    }

    public void searchMedication(String name) {
        for (Medication medication : medications) {
            if (medication.getName().equalsIgnoreCase(name)) {
                System.out.println("Medication found: " + medication.getName() + ". Number in stock: " + medication.getQuantityInStock());
                System.out.println("Dosage: " + medication.getDosage() + ". Expiry Date: " + medication.getExpiryDate());
                return;
            }
        }
        System.out.println("Medication not found.");
    }

    public void searchPatient(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                ArrayList<String> meds = patient.getMedications();
                ArrayList<String> prescripts = patient.getPrescriptions();

                System.out.println("Patient found: " + patient.getName() + ". Age: " + patient.getAge() + ". Phone #: " + patient.getPhone());
                System.out.println("Medications: ");
                for (String id : meds) {
                    for (Medication medication : medications){
                        if (medication.getId().equalsIgnoreCase(id)){
                            System.out.println(medication.getName());
                            break;
                        }
                    }
                }
                System.out.println("Prescription IDs: ");
                for (String id : prescripts) {
                    System.out.println(id);
                }
                return;
            }
        }
        System.out.println("Medication not found.");
    }

    public void searchDoctor(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                ArrayList<String> patientIds = doctor.getPatients();

                System.out.println("Doctor found: " + doctor.getName() + ". Specialization: " + doctor.getSpecialization() + "Phone #: " + doctor.getPhone());
                System.out.println("Patients: ");
                for (String id : patientIds) {
                    for (Patient patient : patients){
                        if (patient.getId().equalsIgnoreCase(id)){
                            System.out.println(patient.getName());
                            break;
                        }
                    }
                }
                return;
            }
        }
        System.out.println("Medication not found.");
    }

    public void doctorPrescriptionsIssued(String doctorName) {
        String docId = null;
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(doctorName)) {
                docId = doctor.getId();
                break;
            }
        }
        if (docId != null) {
            System.out.println("Doctor " + doctorName + "'s Prescriptions: ");
            for (Prescription prescription : prescriptions){
                if (prescription.getDoctor().equalsIgnoreCase(docId)){
                    System.out.println(prescription.getId());
                }
            }
        } else {
            System.out.println("Doctor not found.");
        }
    }

    public void checkExpiredMedications() {
        for (Medication medication : medications) {
            if (medication.getExpiryDate().isBefore(LocalDate.now())) {
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
                    String patientId = patient.getId();
                    doctor.addPatient(patientId);
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
