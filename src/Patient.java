import java.util.ArrayList;

public class Patient extends Person {
    //attributes
    private ArrayList<String> medications = new ArrayList<String>();
    private ArrayList<String> prescriptions = new ArrayList<String>();

    //methods, replace arraylist string with arraylist medications/prescriptions once those classes are done
    public Patient(int id, String name, int age, String phone, ArrayList<String> medications, ArrayList<String> prescriptions){
        super(id, name, age, phone);
        this.medications = medications;
        this.prescriptions = prescriptions;
    }

    public void setMedications(ArrayList<String> meds){
        this.medications = meds;
    }
    public void setPrescriptions(ArrayList<String> prescripts){
        this.prescriptions = prescripts;
    }

    public ArrayList<String> getMedications(){
        return this.medications;
    }
    public ArrayList<String> getPrescriptions(){
        return this.prescriptions;
    }

    public void addMedication(String med){
        this.medications.add(med);
    }
    public void addPrescription(String pres){
        this.prescriptions.add(pres);
    }
    public void removeMedication(String med){
        int index = this.medications.indexOf(med);
        if (index >= 0){
            this.medications.removeIf(n -> n == med);
        } else {
            System.out.println("Medication not found. Please ensure that you have the correct spelling and capitalization.");
        }
    }
    public void removePrescription(String pres){
        int index = this.prescriptions.indexOf(pres);
        if (index >= 0){
            this.prescriptions.removeIf(n -> n == pres);
        } else {
            System.out.println("Prescription not found. Please ensure that you have the correct spelling and capitalization.");
        }
    }
    public String getOneMedication(String med){
        int index = this.medications.indexOf(med);
        if (index >= 0){
            return this.medications.get(index);
        } else {
            return "Medication not found. Please ensure that you have the correct spelling and capitalization.";
        }
    }
    public String getOnePrescription(String pres){
        int index = this.prescriptions.indexOf(pres);
        if (index >= 0){
            return this.prescriptions.get(index);
        } else {
            return "Prescription not found. Please ensure that you have the correct spelling and capitalization.";
        }
    }

}
