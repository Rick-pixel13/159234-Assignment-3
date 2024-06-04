public class Laptop extends Computer {
    private int memSize;
    private int ssd;
    private double screenSize;

    //constructor
    public Laptop(String category, String type, String id, String brand, String cpu, int mem, int ssd, double screen, int price) {
        super(category,type, id, brand, cpu, price);
        setMemSize(mem);
        setSsd(ssd);
        setScreenSize(screen);
    }

    //setters and getters
    public void setMemSize(int memSize) { this.memSize = memSize; }
    public int getMemSize() { return memSize; }
    public void setSsd(int ssd) { this.ssd = ssd; }
    public int getSsd() { return ssd; }
    public void setScreenSize(double screenSize) { this.screenSize = screenSize; }
    public double getScreenSize() { return screenSize; }
}
