package ro.iteahome.bikesharing.model;

public class Bike_Station {
    int bikeId;
    int stationId;

    @Override
    public String toString() {
        return "Bike_Station{" +
                "bikeId=" + bikeId +
                ", stationId=" + stationId +
                '}';
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public Bike_Station(int bikeId, int stationId) {
        this.bikeId = bikeId;
        this.stationId = stationId;
    }
}
