package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingWrongCredentialsException;
import ro.iteahome.bikesharing.model.User;
import ro.iteahome.bikesharing.service.UserService;
import ro.iteahome.bikesharing.ui.validator.UserValidator;

import java.util.Scanner;

public class SignUpUI {

    public static void displaySignUp() {

        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are registering to the bike sharing system! Welcome among us!");
        System.out.println("Enter your Email: ");
        String email = scanner.nextLine();
        System.out.println("Create a Password: ");
        String password = scanner.nextLine();
        System.out.println("Enter your Name : ");
        String name = scanner.nextLine();
        System.out.println("Admin user? (yes/no): ");
        String isAdminText = scanner.nextLine();
        int isAdmin = isAdminText.equals("yes") ? 1 : 0;
        UserService userService = new UserService();
        UserValidator userValidator = new UserValidator();

        try {
            userValidator.validateUserCredentials(email, password);

            user.setEmail(email);
            user.setPassword(password);
            user.setIsAdmin(isAdmin);
            user.setName(name);

            user.setId(userService.generateUserId());

            userService.signUp(user);
            System.out.println("User successfully registered: " + user.getId() + " " + email + " " + user.getIsAdmin());
        } catch (BikeSharingWrongCredentialsException e) {
            e.printStackTrace();
            System.out.println("Wrong Credentials");
        } catch (BikeSharingException e) {
            e.printStackTrace();
        }
    }
}
