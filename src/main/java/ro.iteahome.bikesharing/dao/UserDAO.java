package ro.iteahome.bikesharing.dao;

import ro.iteahome.bikesharing.exception.BikeSharingFileException;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {

    private static final String USERS_FILE = "src/main/resources/users.txt";

    public List<User> readAllUsers() throws BikeSharingTechnicalException {
        List<User> userList = new ArrayList<>();
        try (BufferedReader userReader = new BufferedReader(new FileReader(USERS_FILE))) {
            String userLine = userReader.readLine();
            while(userLine != null) {
                String[] userValues = userLine.split(";");
                int id = Integer.parseInt(userValues[0]);
                int isAdmin = Integer.parseInt(userValues[1]);
                String email = userValues[2];
                String password = userValues[3];
                String name = userValues[4];
                userList.add(new User(id, isAdmin, email, password, name));
                userLine = userReader.readLine();
            }
        } catch (IOException e) {
            throw new BikeSharingFileException("Error reading users", e);
        }
        return userList;
    }

    public void writeUser(User user) throws BikeSharingTechnicalException {

        try (FileWriter writer = new FileWriter(USERS_FILE, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            File file = new File(USERS_FILE);
            if(file.length() != 0)
                bw.newLine();
            bw.write(String.valueOf(user.getId()));
            bw.write(";");
            bw.write(String.valueOf(user.getIsAdmin()));
            bw.write(";");
            bw.write(user.getEmail());
            bw.write(";");
            bw.write(user.getPassword());
            bw.write(";");
            bw.write(user.getName());

        } catch (IOException e) {
            throw new BikeSharingFileException("Error writing user to file", e);
        }
    }
}
