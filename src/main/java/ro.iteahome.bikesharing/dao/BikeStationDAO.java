package ro.iteahome.bikesharing.dao;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingFileException;
import ro.iteahome.bikesharing.exception.BikeSharingStationDoesNotExistException;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Bike;
import ro.iteahome.bikesharing.model.Station;
import ro.iteahome.bikesharing.service.StationService;
import ro.iteahome.bikesharing.service.BikeService;
import ro.iteahome.bikesharing.dao.StationDAO;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class BikeStationDAO {

    BikeService bikeService = new BikeService();
    StationService stationService = new StationService();
    StationDAO stationDAO = new StationDAO();


    private static final String BIKES_STATIONS_FILE = "src/main/resources/stations_bikes.txt";
    public List<Station> readBikeToStation() throws BikeSharingTechnicalException, BikeSharingStationDoesNotExistException {
        try (BufferedReader bikeStationsReader = new BufferedReader(new FileReader(BIKES_STATIONS_FILE))) {
            String bikeStationsLine = bikeStationsReader.readLine();
            List<Station> stationList = stationDAO.readAllStations();
            while(bikeStationsLine != null) {
                String[] bikeStationsValues = bikeStationsLine.split(";");
                int stationId = Integer.parseInt(bikeStationsValues[0]);
                int bikeId = Integer.parseInt(bikeStationsValues[1]);
                Bike bike = bikeService.getBikeById(bikeId);
                stationList.get(stationId-1).addBike(bike);
                bikeStationsLine = bikeStationsReader.readLine();
            }
            System.out.println("Bike succesfully added to the arraylist of the station");
            return stationList;

        } catch (IOException e) {
            throw new BikeSharingFileException("Error reading bikes", e);
        }
        catch (BikeSharingException e){
            throw new BikeSharingStationDoesNotExistException("Station does not exist", e);
        }
    }

    public void writeBikeToStation(int stationId,int bikeId) throws BikeSharingTechnicalException{
        try (FileWriter writer = new FileWriter(BIKES_STATIONS_FILE, true);
            BufferedWriter bw = new BufferedWriter(writer)) {
            File file = new File(BIKES_STATIONS_FILE);
            if(file.length() != 0)
                bw.newLine();
            bw.write(String.valueOf(stationId));
            bw.write(";");
            bw.write(String.valueOf(bikeId));
            System.out.println("Bike succesfully assigned to the station");

        } catch (IOException e) {
            throw new BikeSharingFileException("Error writing bike to stations file", e);
        }
    }


}