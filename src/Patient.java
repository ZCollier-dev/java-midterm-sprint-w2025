import java.util.ArrayList;

public class Patient extends Person {
    //attributes
    private ArrayList<String> medications = new ArrayList<String>();
    private ArrayList<Integer> prescriptionIds = new ArrayList<Integer>();

    //methods, replace arraylist string with arraylist medications/prescriptions once those classes are done
    public Patient(int id, String name, int age, String phone, ArrayList<String> medications, ArrayList<Integer> prescriptions){
        super(id, name, age, phone);
        this.medications = medications;
        this.prescriptionIds = prescriptions;
    }

    public void setMedications(ArrayList<String> meds){
        this.medications = meds;
    }
    public void setPrescriptions(ArrayList<Integer> prescripts){
        this.prescriptionIds = prescripts;
    }

    public ArrayList<String> getMedications(){
        return this.medications;
    }
    public ArrayList<Integer> getPrescriptions(){
        return this.prescriptionIds;
    }

    public void addMedication(String med){
        this.medications.add(med);
    }
    public void addPrescription(int pres){
        this.prescriptionIds.add(pres);
    }
    public void removeMedication(String med){
        int index = this.medications.indexOf(med);
        if (index >= 0){
            this.medications.removeIf(n -> n == med);
        } else {
            System.out.println("Medication not found. Please ensure that you have the correct spelling and capitalization.");
        }
    }
    public void removePrescription(int pres){
        int index = this.prescriptionIds.indexOf(pres);
        if (index >= 0){
            this.prescriptionIds.removeIf(n -> n == pres);
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
    public int getOnePrescription(int pres){
        int index = this.prescriptionIds.indexOf(pres);
        if (index >= 0){
            return this.prescriptionIds.get(index);
        } else {
            System.out.println("Prescription not found. Please ensure that you have the correct spelling and capitalization.");
            return -1;
        }
    }

}
