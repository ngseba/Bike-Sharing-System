package ro.iteahome.bikesharing.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ride {

    private int id;
    private int userId;
    private int bikeId;
    private int startStationId;
    private int endStationId;
    private LocalDate date;

    public Ride() {}

    public Ride(int id, int userId, int bikeId, int startStationId, int endStationId,LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.bikeId = bikeId;
        this.startStationId = startStationId;
        this.endStationId = endStationId;
        this.date = date;

    }

    public LocalDate getDate() {
        return this.date;
    }

    public String getStringDate(){
        return this.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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
