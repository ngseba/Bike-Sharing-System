package ro.iteahome.bikesharing.model;

import java.util.ArrayList;

public class Station {
    private int id;
    private String name;
    ArrayList<Bike> availableBikes = new ArrayList<>();


    public Station(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public Station getStationById(int id){ return this;}

    public void addBike(Bike bike){
        this.availableBikes.add(bike);
    }

    public ArrayList<Bike> getAvailableBikes(){
        if(this.availableBikes != null)
            return this.availableBikes;
        else System.out.println("Station"+this.getName()+" has no available bikes");
        return null;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
