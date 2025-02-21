import java.util.ArrayList;

public class Doctor extends Person {
    //attributes
    private String specialization;
    private ArrayList<String> patientIds = new ArrayList<String>();

    //methods
    public Doctor(String name, int age, String phone, String specialization, ArrayList<String> patients){
        super(name, age, phone);
        this.specialization = specialization;
        this.patientIds = patients;
    }

    public void setSpecialization(String spec){
        this.specialization = spec;
    }
    public void setPatients(ArrayList<String> patients){
        this.patientIds = patients;
    }
    public String getSpecialization(){
        return this.specialization;
    }
    public ArrayList<String> getPatients(){
        return this.patientIds;
    }

    public void addPatient(String patient){
        this.patientIds.add(patient);
    }
    public void removePatient(String patient){
        int index = this.patientIds.indexOf(patient);
        if (index >= 0){
            this.patientIds.removeIf(n -> n == patient);
        } else {
            System.out.println("Patient not found.");
        }
    }
    public String getOnePatient(String patient){
        int index = this.patientIds.indexOf(patient);
        if (index >= 0){
            return this.patientIds.get(index);
        } else {
            return "Patient not found.";
        }
    }
}
