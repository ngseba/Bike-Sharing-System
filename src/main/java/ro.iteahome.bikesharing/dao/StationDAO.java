package ro.iteahome.bikesharing.dao;

import ro.iteahome.bikesharing.exception.BikeSharingFileException;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Station;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class StationDAO {

    private static final String STATIONS_FILE = "src/main/resources/stations.txt";

    public HashMap<Integer,Station> readAllStations() throws BikeSharingTechnicalException {
        HashMap<Integer,Station> stationMap = new HashMap<>();
        try (BufferedReader stationReader = new BufferedReader(new FileReader(STATIONS_FILE))) {
            String stationLine = stationReader.readLine();
            while(stationLine != null) {
                String[] stationValues = stationLine.split(";");
                int id = Integer.parseInt(stationValues[0]);
                String name = stationValues[1];
                stationMap.put(id,new Station(id,name));
                stationLine = stationReader.readLine();
            }
        } catch (IOException e) {
            throw new BikeSharingFileException("Error reading stations", e);
        }
        return stationMap;
    }

    public void writeStation(Station station) throws BikeSharingTechnicalException {

        try (FileWriter writer = new FileWriter(STATIONS_FILE, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            File file = new File(STATIONS_FILE);
            if(file.length() != 0)
                bw.newLine();
            bw.write(String.valueOf(station.getId()));
            bw.write(";");
            bw.write(station.getName());

        } catch (IOException e) {
            throw new BikeSharingFileException("Error writing station to file", e);
        }
    }
}