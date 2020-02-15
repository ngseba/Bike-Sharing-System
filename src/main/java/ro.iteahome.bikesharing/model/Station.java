package ro.iteahome.bikesharing.model;

import java.util.ArrayList;

public class Station {
    private int id;
    private String name;
    private ArrayList<ro.iteahome.bikesharing.model.Bike> availableBikes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ro.iteahome.bikesharing.model.Bike> getAvailableBikes() {
        return availableBikes;
    }

    public Station(int id, String name, ArrayList<ro.iteahome.bikesharing.model.Bike> availableBikes) {
        this.id = id;
        this.name = name;
        this.availableBikes = availableBikes;
    }

}
