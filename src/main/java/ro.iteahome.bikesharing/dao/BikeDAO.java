package ro.iteahome.bikesharing.dao;

import ro.iteahome.bikesharing.exception.BikeSharingFileException;
import ro.iteahome.bikesharing.exception.BikeSharingStationDoesNotExistException;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Bike;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class BikeDAO {

    private static final String BIKES_FILE = "src/main/resources/bikes.txt";

    public HashMap<Integer,Bike> readAllBikes() throws BikeSharingTechnicalException {
        HashMap<Integer,Bike> bikeHashMap = new HashMap<>();
        try (BufferedReader bikeReader = new BufferedReader(new FileReader(BIKES_FILE))) {
            String bikeLine = bikeReader.readLine();
            while(bikeLine != null) {
                String[] bikeValues = bikeLine.split(";");
                int id = Integer.parseInt(bikeValues[0]);
                String brand = bikeValues[1];
                bikeHashMap.put(id,new Bike(id, brand));
                bikeLine = bikeReader.readLine();
            }
        } catch (IOException e) {
            throw new BikeSharingFileException("Error reading bikes", e);
        }
        return bikeHashMap;
    }

    public void writeBike(Bike bike,int stationId) throws BikeSharingTechnicalException {

        try (FileWriter writer = new FileWriter(BIKES_FILE, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            File file = new File(BIKES_FILE);
            if(file.length() != 0)
                bw.newLine();
            bw.write(String.valueOf(bike.getId()));
            bw.write(";");
            bw.write(bike.getBrand());
            bw.write(";");
            bw.write(String.valueOf(stationId));

        } catch (IOException e) {
            throw new BikeSharingFileException("Error writing bike to file", e);
        }
    }

    public ArrayList<Bike> readBikeFromStation(int stationId) throws BikeSharingTechnicalException {
        try (BufferedReader bikeStationsReader = new BufferedReader(new FileReader(BIKES_FILE))) {
            String bikeLine = bikeStationsReader.readLine();
            ArrayList<Bike> bikeListFromStation = new ArrayList<>();
            while(bikeLine != null) {
                String[] bikeValues = bikeLine.split(";");
                if(stationId == Integer.parseInt(bikeValues[2]))
                     {
                         int bikeId = Integer.parseInt(bikeValues[0]);
                         String brand = bikeValues[1];
                         bikeListFromStation.add(new Bike(bikeId,brand));
                     }
                bikeLine = bikeStationsReader.readLine();

            }
            return bikeListFromStation;

        } catch (IOException e) {
            throw new BikeSharingFileException("Error reading bikes", e);
        }

    }

    public void removeOldPosition(Bike bike,int oldStationId) throws IOException {

        File inputFile = new File(BIKES_FILE);
        File tempFile = new File("src/main/resources/bikesStationsTemp.txt");

        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        String lineToRemove = bike.getId() + ";" + bike.getBrand() + ";"+oldStationId;
        String currentLine;
        boolean firstLine = true;

        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(!trimmedLine.equals(lineToRemove)) {
                if(!firstLine)
                    writer.newLine();
                writer.write(currentLine);
                firstLine = false;
            }
        }
        writer.close();
        reader.close();

        inputFile.delete();
        tempFile.renameTo(inputFile);
    }
}