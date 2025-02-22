import java.util.Scanner;

public class EmptyMenu {
    public static void main(String[] args) {
        MedicationTrackingSystem system = new MedicationTrackingSystem();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("===== Welcome To The Pharmacy Med Tracking System! =====");
            System.out.println("1: Add A New Patient");
            System.out.println("2: Add A New Doctor");
            System.out.println("3: Add A New Medication");
            System.out.println("4: Add A New Prescription");
            System.out.println("5: Delete A Patient");
            System.out.println("6: Delete A Doctor");
            System.out.println("7: Delete A Medication");
            System.out.println("8: Edit Patient Details");
            System.out.println("9: Edit Doctor Details");
            System.out.println("10: Edit Medication Details");
            System.out.println("11: Search Patient by Name");
            System.out.println("12: Search Doctor by Name");
            System.out.println("13: Search Medication by Name");
            System.out.println("14: Assign Patient to Doctor");
            System.out.println("15: Print All Doctors");
            System.out.println("16: Print All Patients");
            System.out.println("17: Print All Medications");
            System.out.println("18: Print All Prescriptions");
            System.out.println("19: Check Expired Medications");
            System.out.println("20: Restock Medication");
            System.out.println("21: Generate System Report");
            System.out.println("22: Print Prescriptions Issued by a Doctor");
            System.out.println("23: Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    system.addPatient(scanner);
                    break;
                case 2:
                    system.addDoctor(scanner);
                    break;
                case 3:
                    system.addMedication(scanner);
                    break;
                case 4:
                    system.addPrescription(scanner);
                    break;
                case 5:
                    system.deletePatient(scanner);
                    break;
                case 6:
                    system.deleteDoctor(scanner);
                    break;
                case 7:
                    system.deleteMedication(scanner);
                    break;
                case 8:
                    system.editPatient(scanner);
                    break;
                case 9:
                    system.editDoctor(scanner);
                    break;
                case 10:
                    system.editMedication(scanner);
                    break;
                case 11:
                    system.searchPatientByName(scanner);
                    break;
                case 12:
                    system.searchDoctorByName(scanner);
                    break;
                case 13:
                    system.searchMedicationByName(scanner);
                    break;
                case 14:
                    system.assignPatientToDoctor(scanner);
                    break;
                case 15:
                    system.printAllDoctors();
                    break;
                case 16:
                    system.printAllPatients();
                    break;
                case 17:
                    system.printAllMedications();
                    break;
                case 18:
                    system.printAllPrescriptions();
                    break;
                case 19:
                    system.checkExpiredMedications();
                    break;
                case 20:
                    system.restockMedication(scanner);
                    break;
                case 21:
                    system.systemReport();
                    break;
                case 22:
                    system.printPrescriptionsByDoctor(scanner);
                    break;
                case 23:
                    exit = true;
                    System.out.println("Exiting The System! Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please enter a valid choice.");
            }
        }
        scanner.close();
    }
}
