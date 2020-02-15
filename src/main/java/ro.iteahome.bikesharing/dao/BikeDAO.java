package ro.iteahome.bikesharing.dao;

import ro.iteahome.bikesharing.exception.BikeSharingFileException;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Bike;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class BikeDAO {

    private static final String BIKES_FILE = "src/main/resources/bikes.txt";

    public List<Bike> readAllBikes() throws BikeSharingTechnicalException {
        List<Bike> bikeList = new ArrayList<>();
        try (BufferedReader bikeReader = new BufferedReader(new FileReader(BIKES_FILE))) {
            String bikeLine = bikeReader.readLine();
            while(bikeLine != null) {
                String[] bikeValues = bikeLine.split(";");
                int id = Integer.parseInt(bikeValues[0]);
                String brand = bikeValues[1];
                bikeList.add(new Bike(id, brand));
                bikeLine = bikeReader.readLine();
            }
        } catch (IOException e) {
            throw new BikeSharingFileException("Error reading bikes", e);
        }
        return bikeList;
    }

    public void writeBike(Bike bike) throws BikeSharingTechnicalException {

        try (FileWriter writer = new FileWriter(BIKES_FILE, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            File file = new File(BIKES_FILE);
            if(file.length() != 0)
                bw.newLine();
            bw.write(String.valueOf(bike.getId()));
            bw.write(";");
            bw.write(bike.getBrand());

        } catch (IOException e) {
            throw new BikeSharingFileException("Error writing bike to file", e);
        }
    }
}