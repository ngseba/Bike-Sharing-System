package ui;

import ro.iteahome.exceptions.exception.BikeSharingException;
import ro.iteahome.exceptions.exception.BikeSharingWrongCredentialsException;
import ro.iteahome.exceptions.service.UserService;

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
            userService.login(email, password);
            System.out.println("User successfully logged in: " + email);
        } catch (BikeSharingWrongCredentialsException e) {
            e.printStackTrace();
            System.out.println("Wrong Credentials");
        } catch (BikeSharingException e) {
            e.printStackTrace();
        }
    }
}
