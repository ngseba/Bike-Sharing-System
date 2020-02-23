package ro.iteahome.bikesharing.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListStationsDAO {

    public static void printStations() {

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/stations.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println((line).replace(";", ". "));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
