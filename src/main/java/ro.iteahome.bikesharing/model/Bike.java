package ro.iteahome.bikesharing.model;


public class
Bike {
    private int id;
    private String brand;

    public Bike(int id,String brand) {
        this.id =id;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Bike getBikeById(int id) { return this; }

    @Override
    public String toString() {
        return "Bike{" +
                "brand='" + brand + '\'' +
                '}';
    }


}
