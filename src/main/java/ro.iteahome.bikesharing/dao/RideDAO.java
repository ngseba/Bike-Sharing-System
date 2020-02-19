package ro.iteahome.bikesharing.dao;

import ro.iteahome.bikesharing.exception.BikeSharingFileException;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Ride;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RideDAO {

    private static final String RIDES_FILE = "src/main/resources/rides.txt";

    public List<Ride> readAllRides() throws BikeSharingTechnicalException {
        List<Ride> rideList = new ArrayList<>();
        try (BufferedReader rideReader = new BufferedReader(new FileReader(RIDES_FILE))) {
            String rideLine = rideReader.readLine();
            while(rideLine != null) {
                String[] rideValues = rideLine.split(";");
                int id = Integer.parseInt(rideValues[0]);
                int userId = Integer.parseInt(rideValues[1]);
                int bikeId = Integer.parseInt(rideValues[2]);
                int startStationId = Integer.parseInt(rideValues[3]);
                int endStationId = Integer.parseInt(rideValues[4]);
                rideList.add(new Ride(id, userId, bikeId, startStationId, endStationId));
                rideLine = rideReader.readLine();
            }
        } catch (IOException e) {
            throw new BikeSharingFileException("Error reading rides", e);
        }
        return rideList;
    }

    public void writeRide(Ride ride) throws BikeSharingTechnicalException {

        try (FileWriter writer = new FileWriter(RIDES_FILE, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            File file = new File(RIDES_FILE);
            if(file.length() != 0)
                bw.newLine();
            bw.write(String.valueOf(ride.getId()));
            bw.write(";");
            bw.write(String.valueOf(ride.getUserId()));
            bw.write(";");
            bw.write(String.valueOf(ride.getBikeId()));
            bw.write(";");
            bw.write(String.valueOf(ride.getStartStationId()));
            bw.write(";");
            bw.write(String.valueOf(ride.getEndStationId()));

        } catch (IOException e) {
            throw new BikeSharingFileException("Error writing ride to file", e);
        }
    }
}
