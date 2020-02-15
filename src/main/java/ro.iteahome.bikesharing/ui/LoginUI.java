package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingWrongCredentialsException;
import ro.iteahome.bikesharing.service.UserService;
import ro.iteahome.bikesharing.model.User;

import java.util.Scanner;

public class LoginUI {

    private UserService userService = new UserService();

    public void displayLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        try {
           User loggedUser = userService.login(email, password);
            System.out.println("User successfully logged in: " + email);
        } catch (BikeSharingWrongCredentialsException e) {
            e.printStackTrace();
            System.out.println("Wrong Credentials");
        } catch (BikeSharingException e) {
            e.printStackTrace();
        }
    }
}
