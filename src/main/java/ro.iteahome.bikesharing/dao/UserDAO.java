package dao;

import ro.iteahome.exceptions.exception.BikeSharingFileException;
import ro.iteahome.exceptions.exception.BikeSharingTechnicalException;
import ro.iteahome.exceptions.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDAO {

    private static final String USERS_FILE = "src/main/resources/users.txt";

    public List<User> readAllUsers() throws BikeSharingTechnicalException {
        List<User> userList = new ArrayList<>();
        try (BufferedReader userReader = new BufferedReader(new FileReader(USERS_FILE))) {
            String userLine = userReader.readLine();
            String[] userValues = userLine.split(";");
            userList.add(new User(userValues[0], userValues[1]));
        } catch (IOException e) {
            throw new BikeSharingFileException("Error reading users", e);
        }
        return userList;
    }

    public void writeUser(User user) throws BikeSharingTechnicalException {

        try (FileWriter writer = new FileWriter(USERS_FILE, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.newLine();
            bw.write(user.getEmail());
            bw.write(";");
            bw.write(user.getPassword());

        } catch (IOException e) {
            throw new BikeSharingFileException("Error writing user to file", e);
        }
    }
}
