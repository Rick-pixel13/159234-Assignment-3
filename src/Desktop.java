public class Desktop extends Computer {
    private int memSize;
    private int ssd;

    // constructor
    public Desktop(String category, String type, String id, String brand, String cpu, int mem, int ssd, int price) {
        super(category, type, id, brand, cpu, price);
        setMemSize(mem);
        setSsd(ssd);
    }

    // setters and getters
    public void setMemSize(int memSize) { this.memSize = memSize; }
    public int getMemSize() { return memSize; }
    public void setSsd(int ssd) { this.ssd = ssd; }
    public int getSsd() { return ssd; }
}
