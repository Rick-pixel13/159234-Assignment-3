import javax.swing.*;

public abstract class Computer {
    private String category;
    private String type;
    private String id;
    private String brand;
    private int price;
    private String cpuFam;

    // constructor
    public Computer(String category, String type, String id, String brand, String cpu, int price) {
        setCategory(category);
        setType(type);
        setId(id);
        setBrand(brand);
        setCpuFam(cpu);
        setPrice(price);
    }

    // setters and getters
    public void setCategory(String category) {
        if (category.equals("Desktop")) {
            this.category = "Desktop PC";
        } else {
            this.category = category;
        }
    }
    public String getCategory() { return category; }
    public void setType(String type) { this.type = type; }
    public String getType() { return type; }
    public void setId(String id) { this.id = id;  }
    public String getId() { return id; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getBrand() {return brand;}
    public void setPrice(int price) { this.price = price; }
    public int getPrice() { return price; }
    public void setCpuFam(String cpuFam) { this.cpuFam = cpuFam; }
    public String getCpuFam() { return cpuFam; }
}