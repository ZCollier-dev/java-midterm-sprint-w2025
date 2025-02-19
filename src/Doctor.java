import java.util.ArrayList;

public class Doctor extends Person {
    //attributes
    private String specialization;
    private ArrayList<Patient> patients = new ArrayList<Patient>();

    //methods
    public Doctor(String name, int age, String phone, String specialization, ArrayList<Patient> patients){
        super(name, age, phone);
        this.specialization = specialization;
        this.patients = patients;
    }

    public void setSpecialization(String spec){
        this.specialization = spec;
    }
    public void setPatients(ArrayList<Patient> patients){
        this.patients = patients;
    }
    public String getSpecialization(){
        return this.specialization;
    }
    public ArrayList<Patient> getPatients(){
        return this.patients;
    }

    public void addPatient(Patient patient){
        this.patients.add(patient);
    }
    public void removePatient(Patient patient){
        int index = this.patients.indexOf(patient);
        if (index >= 0){
            this.patients.removeIf(n -> n == patient);
        } else {
            System.out.println("Patient not found. Please ensure that you have the correct spelling and capitalization.");
        }
    }
    public Patient getOnePatient(Patient patient){
        int index = this.patients.indexOf(patient);
        if (index >= 0){
            return this.patients.get(index);
        } else {
            System.out.println("Patient not found. Please ensure that you have the correct spelling and capitalization.");
            return patient;
        }
    }
}
