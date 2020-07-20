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


    @Override
    public String toString() {
        return Integer.toString(this.id) + ". " + this.brand;
    }


}
