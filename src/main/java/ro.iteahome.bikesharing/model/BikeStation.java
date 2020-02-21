package ro.iteahome.bikesharing.model;

public class BikeStation {
    int bikeId;
    int stationId;

    @Override
    public String toString() {
        return "BikeStation{" +
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

    public BikeStation(int bikeId, int stationId) {
        this.bikeId = bikeId;
        this.stationId = stationId;
    }

    public BikeStation() {
        this.bikeId = -1;
        this.stationId = -1;
    }
}
