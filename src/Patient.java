import java.util.ArrayList;

public class Patient extends Person {
    //attributes
    private ArrayList<String> medicationIds = new ArrayList<String>();
    private ArrayList<String> prescriptionIds = new ArrayList<String>();

    //methods, replace arraylist string with arraylist medications/prescriptions once those classes are done
    public Patient(String name, int age, String phone, ArrayList<String> medications, ArrayList<String> prescriptions){
        super(name, age, phone);
        this.medicationIds = medications;
        this.prescriptionIds = prescriptions;
    }

    public void setMedications(ArrayList<String> meds){
        this.medicationIds = meds;
    }
    public void setPrescriptions(ArrayList<String> prescripts){
        this.prescriptionIds = prescripts;
    }

    public ArrayList<String> getMedications(){
        return this.medicationIds;
    }
    public ArrayList<String> getPrescriptions(){
        return this.prescriptionIds;
    }

    public void addMedication(String med){
        this.medicationIds.add(med);
    }
    public void addPrescription(String pres){
        this.prescriptionIds.add(pres);
    }
    public void removeMedication(String med){
        int index = this.medicationIds.indexOf(med);
        if (index >= 0){
            this.medicationIds.removeIf(n -> n == med);
        } else {
            System.out.println("Medication not found.");
        }
    }
    public void removePrescription(String pres){
        int index = this.prescriptionIds.indexOf(pres);
        if (index >= 0){
            this.prescriptionIds.removeIf(n -> n == pres);
        } else {
            System.out.println("Prescription not found.");
        }
    }
    public String getOneMedication(String med){
        int index = this.medicationIds.indexOf(med);
        if (index >= 0){
            return this.medicationIds.get(index);
        } else {
            return "Medication not found.";
        }
    }
    public String getOnePrescription(int pres){
        int index = this.prescriptionIds.indexOf(pres);
        if (index >= 0){
            return this.prescriptionIds.get(index);
        } else {
            return "Prescription not found.";
        }
    }

}
