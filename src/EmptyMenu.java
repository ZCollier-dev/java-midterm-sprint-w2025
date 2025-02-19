
import java.util.Scanner;

public class EmptyMenu {
    public static void main(String[] args) {
        // Ensure MedicationTrackingSystem class is correctly referenced
        MedicationTrackingSystem system = new MedicationTrackingSystem();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("===== Welcome To The Pharmacy Med Tracking System!=====");
            System.out.println("1: Add A New Patient");
            System.out.println("2: Add A New Doctor");
            System.out.println("3: Add A New Medication");
            System.out.println("4: Assign Patient To Doctor");
            System.out.println("5: Print All Doctors");
            System.out.println("6: Print All Patients");
            System.out.println("7: Print All Medications");
            System.out.println("8: Print All Prescriptions");
            System.out.println("9: Delete A Doctor");
            System.out.println("10: Delete A Patient");
            System.out.println("11: Delete A Medication");
            System.out.println("12: Check Expired Medications");
            System.out.println("13: Restock Medication");
            System.out.println("14: Exit");
            System.out.print("Enter your choice: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
                continue;
            }
            
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (option) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter patient age: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid age input.");
                        scanner.next();
                        break;
                    }
                    int patientAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter patient phone number: ");
                    String patientPhone = scanner.nextLine();
                    system.addPatient(new Patient(patientName, patientAge, patientPhone));
                    break;
                case 2:
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter doctor age: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid age input.");
                        scanner.next();
                        break;
                    }
                    int doctorAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter doctor phone number: ");
                    String doctorPhone = scanner.nextLine();
                    System.out.print("Enter doctor specialization: ");
                    String specialization = scanner.nextLine();
                    system.addDoctor(new Doctor(doctorName, doctorAge, doctorPhone, specialization));
                    break;
                case 3:
                    System.out.print("Enter medication name: ");
                    String medName = scanner.nextLine();
                    System.out.print("Enter dosage: ");
                    String dosage = scanner.nextLine();
                    System.out.print("Enter stock quantity: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid stock input.");
                        scanner.next();
                        break;
                    }
                    int stock = scanner.nextInt();
                    scanner.nextLine();
                    system.addMedication(new Medication(medName, dosage, stock));
                    break;
                case 4:
                    System.out.print("Enter doctor name: ");
                    String docName = scanner.nextLine();
                    System.out.print("Enter patient name: ");
                    String patName = scanner.nextLine();
                    system.assignPatientToDoctor(docName, patName);
                    break;
                case 5:
                    system.printAllDoctors();
                    break;
                case 6:
                    system.printAllPatients();
                    break;
                case 7:
                    system.printAllMedications();
                    break;
                case 8:
                    system.printAllPrescriptions();
                    break;
                case 9:
                    System.out.print("Enter doctor name to delete: ");
                    String delDocName = scanner.nextLine();
                    system.deleteDoctor(delDocName);
                    break;
                case 10:
                    System.out.print("Enter patient name to delete: ");
                    String delPatName = scanner.nextLine();
                    system.deletePatient(delPatName);
                    break;
                case 11:
                    System.out.print("Enter medication name to delete: ");
                    String delMedName = scanner.nextLine();
                    system.deleteMedication(delMedName);
                    break;
                case 12:
                    system.checkExpiredMedications();
                    break;
                case 13:
                    System.out.print("Enter medication name to restock: ");
                    String restockMedName = scanner.nextLine();
                    System.out.print("Enter quantity to add: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid quantity input.");
                        scanner.next();
                        break;
                    }
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    system.restockMedication(restockMedName, quantity);
                    break;
                case 14:
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
