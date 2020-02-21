package ro.iteahome.bikesharing.dao;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingFileException;
import ro.iteahome.bikesharing.exception.BikeSharingStationDoesNotExistException;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Bike;
import ro.iteahome.bikesharing.model.Bike_Station;
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


    private static final String BIKES_STATIONS_FILE = "src/main/resources/bikesStations.txt";
    public List<Station> readBikeToStation() throws BikeSharingTechnicalException, BikeSharingStationDoesNotExistException {
        try (BufferedReader bikeStationsReader = new BufferedReader(new FileReader(BIKES_STATIONS_FILE))) {
            String bikeStationsLine = bikeStationsReader.readLine();
            List<Station> stationList = stationDAO.readAllStations();
            while(bikeStationsLine != null) {
                String[] bikeStationsValues = bikeStationsLine.split(";");
                int bikeId = Integer.parseInt(bikeStationsValues[0]);
                int stationId = Integer.parseInt(bikeStationsValues[1]);
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

    public void writeBikeToStation(int bikeId,int stationId) throws BikeSharingTechnicalException{
        try (FileWriter writer = new FileWriter(BIKES_STATIONS_FILE, true);
            BufferedWriter bw = new BufferedWriter(writer)) {
            File file = new File(BIKES_STATIONS_FILE);
            if(file.length() != 0)
                bw.newLine();
            bw.write(String.valueOf(bikeId));
            bw.write(";");
            bw.write(String.valueOf(stationId));
            System.out.println("Bike succesfully assigned to the station");

        } catch (IOException e) {
            throw new BikeSharingFileException("Error writing bike to stations file", e);
        }
    }

    public void removeOldPosition(Bike_Station oldPosition) throws IOException {

        File inputFile = new File(BIKES_STATIONS_FILE);
        File tempFile = new File("src/main/resources/bikesStationsTemp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(BIKES_STATIONS_FILE));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = String.valueOf(oldPosition.getBikeId()) + ";" + String.valueOf(oldPosition.getStationId());
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();

        inputFile.delete();
        tempFile.renameTo(inputFile);
    }

}