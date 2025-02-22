import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

// Medication class
class Medication {
    private static int idCounter = 1;
    private String id;
    private String name;
    private String dose;
    private int quantityInStock;
    private LocalDate expiryDate;

    // Constructor with parameters
    public Medication(String name, String dose, int quantityInStock) {
        this.id = "MED" + idCounter++;
        this.name = name;
        this.dose = dose;
        this.quantityInStock = quantityInStock;
        this.expiryDate = generateRandomExpiryDate();
    }

    // Interactive constructor using Scanner
    public Medication(Scanner scanner) {
        this.id = "MED" + idCounter++;
        System.out.print("Enter Medication Name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter Dosage: ");
        this.dose = scanner.nextLine();
        System.out.print("Enter Quantity in Stock: ");
        this.quantityInStock = Integer.parseInt(scanner.nextLine());
        this.expiryDate = generateRandomExpiryDate();
    }

    // Generate random expiry date (can include past dates)
    private LocalDate generateRandomExpiryDate() {
        Random random = new Random();
        int years = random.nextInt(10) - 5; // From -5 to +4 years
        int days = random.nextInt(365);
        return LocalDate.now().plusYears(years).plusDays(days);
    }

    public void setName(String name) { this.name = name; }
    public void setDosage(String dose) { this.dose = dose; }
    public void setQuantityInStock(int quantity) { this.quantityInStock = quantity; }
    public void setExpiryDate(LocalDate expiry) { this.expiryDate = expiry; }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDosage() { return dose; }
    public int getQuantityInStock() { return quantityInStock; }
    public LocalDate getExpiryDate() { return expiryDate; }

    @Override
    public String toString() {
        return "Medication ID: " + id + ", Name: " + name + ", Dosage: " + dose + ", Quantity: " + quantityInStock + ", Expiry Date: " + expiryDate;
    }
}
