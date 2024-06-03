public abstract class Computer {
    private String category;
    private String type;
    private String id;
    private String brand;
    private int price;
    private String cpuFam;

    // constructor
    public Computer(String type, String id, String brand, String cpu, int price) {
        setCategory();
        setType(type);
        setId(id);
        setBrand(brand);
        setCpuFam(cpu);
        setPrice(price);
    }

    // setters and getters
    public void setCategory() {
        this.category = this.getClass().getSimpleName();
        if (category.equals("Desktop")) {
            this.category = "Desktop PC";
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
    public double getPrice() { return price; }
    public void setCpuFam(String cpuFam) { this.cpuFam = cpuFam; }
    public String getCpuFam() { return cpuFam; }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s",
                getClass().getSimpleName(),
                getType(),
                getId(),
                getBrand(),
                getCpuFam()
        );
    }
}