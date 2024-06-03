public class Tablet extends Computer {
    private double screenSize;

    // constructor
    public Tablet(String type, String id, String brand, String cpu, double screen, int price) {
        super(type, id, brand, cpu, price);
        setScreenSize(screen);
    }

    // setters and getters
    public void setScreenSize(double screenSize) { this.screenSize = screenSize; }
    public double getScreenSize() { return screenSize; }

    @Override
    public String toString() {
        return super.toString() + String.format(" %.1f %.1f",
                getScreenSize(),
                getPrice()
        );
    }
}
