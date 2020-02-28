package ro.iteahome.bikesharing.dao;

import ro.iteahome.bikesharing.exception.BikeSharingFileException;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Bike;
import ro.iteahome.bikesharing.model.Query;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class QueryDAO {
    private static final String QUERY_FILE = "src/main/resources/query.txt";

    public void writeQuery(Query query) throws BikeSharingTechnicalException {

        try (FileWriter writer = new FileWriter(QUERY_FILE, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            File file = new File(QUERY_FILE);
            if(file.length() != 0)
                bw.newLine();
            bw.write(query.getMessage());
            bw.newLine();
            for (String queryResult:query.getQueryList()){
                bw.write(queryResult);
                bw.newLine();
            }


        } catch (IOException e) {
            throw new BikeSharingFileException("Error writing query to file", e);
        }
    }
}
