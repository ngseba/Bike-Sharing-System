package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingWrongCredentialsException;
import ro.iteahome.bikesharing.service.UserService;
import ro.iteahome.bikesharing.model.User;

import java.util.Scanner;

public class LoginUI {

        public static void displayLogin () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Email: ");
            String email = scanner.nextLine();
            System.out.println("Password: ");
            String password = scanner.nextLine();
            UserService userService = new UserService();
            try {
                User loggedUser = userService.login(email, password);
                System.out.println("User successfully logged in: " + email);
                UserOptionsUI userOptionsUI = new UserOptionsUI();
                userOptionsUI.enteringUserOptionsUI();

            } catch (BikeSharingWrongCredentialsException e) {
                e.printStackTrace();
                System.out.println("Wrong Credentials");
            } catch (BikeSharingException e) {
                e.printStackTrace();
            }

        }
}
