package ro.iteahome.bikesharing.model;


public class
Bike {
    private int id;
    private String brand;

    public Bike(String brand, String frame, boolean hasSuspension) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "brand='" + brand + '\'' +
                '}';
    }


}
