import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

// Medication class
class Medication {
    private String id;
    private String name;
    private String dose;
    private int quantityInStock;
    private LocalDate expiryDate;

    public Medication(String name, String dose, int quantityInStock) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.dose = dose;
        this.quantityInStock = quantityInStock;
        this.expiryDate = generateRandomExpiryDate();
    }

    private LocalDate generateRandomExpiryDate() {
        Random random = new Random();
        int years = random.nextInt(10) - 5;
        int days = random.nextInt(365);
        return LocalDate.now().plusYears(years).plusDays(days);
    }

    public void setName(String name) { this.name = name; }
    public void setDosage(String dose) { this.dose = dose; }
    public void setQuantityInStock(int quantity) { this.quantityInStock = quantity; }
    public void setExpiryDate(LocalDate expiry){this.expiryDate = expiry;}
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDosage() { return dose; }
    public int getQuantityInStock() { return quantityInStock; }
    public LocalDate getExpiryDate() { return expiryDate; }
}
