package ro.iteahome.bikesharing.model;

public class Ride {

    private int id;
    private int userId;
    private int bikeId;
    private int startStationId;
    private int endStationId;

    public Ride() {
        this.id = -1;
        this.userId = -1;
        this.bikeId = -1;
        this.startStationId = -1;
        this.endStationId = -1;
    }

    public Ride(int id, int userId, int bikeId, int startStationId, int endStationId) {
        this.id = id;
        this.userId = userId;
        this.bikeId = bikeId;
        this.startStationId = startStationId;
        this.endStationId = endStationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public int getStartStationId() {
        return startStationId;
    }

    public void setStartStationId(int startStationId) {
        this.startStationId = startStationId;
    }

    public int getEndStationId() {
        return endStationId;
    }

    public void setEndStationId(int endStationId) {
        this.endStationId = endStationId;
    }

    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", userId=" + userId +
                ", bikeId='" + bikeId + '\'' +
                ", startStationId='" + startStationId + '\'' +
                ", endStationId='" + endStationId + '\'' +
                '}';
    }
}
