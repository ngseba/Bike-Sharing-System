package ro.iteahome.bikesharing.dao;


import ro.iteahome.bikesharing.exception.BikeSharingFileException;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.BikeStation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class BikeStationDAO {

    private static final String BIKES_STATIONS_FILE = "src/main/resources/bikesStations.txt";

    public List<BikeStation> readAllBikeStation() throws BikeSharingTechnicalException {
        try (BufferedReader bikeStationsReader = new BufferedReader(new FileReader(BIKES_STATIONS_FILE))) {
            String bikeStationsLine = bikeStationsReader.readLine();

            List<BikeStation> bikeStationList = new ArrayList<BikeStation>();
            while(bikeStationsLine != null) {
                String[] bikeStationsValues = bikeStationsLine.split(";");
                int bikeId = Integer.parseInt(bikeStationsValues[0]);
                int stationId = Integer.parseInt(bikeStationsValues[1]);
                BikeStation bs = new BikeStation();
                bs.setBikeId(bikeId);
                bs.setStationId(stationId);
                bikeStationList.add(bs);
                bikeStationsLine = bikeStationsReader.readLine();
            }
            System.out.println("BikeStation list succesfully read from file");
            return bikeStationList;

        } catch (IOException e) {
            throw new BikeSharingFileException("Error reading bikes", e);
        }
    }

    public void writeBikeToStation(int bikeId,int stationId) throws BikeSharingTechnicalException{
        try (FileWriter writer = new FileWriter(BIKES_STATIONS_FILE, true);
            BufferedWriter bw = new BufferedWriter(writer)) {
            File file = new File(BIKES_STATIONS_FILE);

            bw.write(String.valueOf(bikeId));
            bw.write(";");
            bw.write(String.valueOf(stationId));
            System.out.println("Bike succesfully assigned to the station");

        } catch (IOException e) {
            throw new BikeSharingFileException("Error writing bike to stations file", e);
        }
    }

    public void removeOldPosition(BikeStation oldPosition) throws IOException {

        File inputFile = new File(BIKES_STATIONS_FILE);
        File tempFile = new File("src/main/resources/bikesStationsTemp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(BIKES_STATIONS_FILE));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = oldPosition.getBikeId() + ";" + oldPosition.getStationId();
        String currentLine;

        while((currentLine = reader.readLine()) != null) {

            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(!trimmedLine.equals(lineToRemove))
                writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();

        inputFile.delete();
        tempFile.renameTo(inputFile);
    }

}