package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingWrongCredentialsException;
import ro.iteahome.bikesharing.model.User;
import ro.iteahome.bikesharing.service.UserService;
import ro.iteahome.bikesharing.ui.validator.UserValidator;

import java.util.Scanner;

import static java.lang.System.exit;

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

    public static class MainUI {

        public static void enteringUI() {
            printMainMessageAndHandleAction("Welcome to the BikeSharing System. Would you like to: \n" + "1. Log in.\n" + "2. Sign up.\n" + "0. Exit session.");
        }

        public static void printMainMessageAndHandleAction(String message) {
            System.out.println(message);
            Scanner firstSteps = new Scanner(System.in);
            String option = firstSteps.nextLine();

            try {
                switch (option) {
                    case "1":
                        LoginUI.displayLogin();
                        break;
                    case "2":
                        displaySignUp();
                        break;
                    case "0":
                        System.out.println("You have terminated your session. Thank you and see you soon!");
                        exit(0);
                    default:
                        printMainMessageAndHandleAction("Error. Not a valid option. Press: \n" + "1. to Log in... \n" + "2. To Sign up, or...\n" + "3. To Exit session.");
                        return;

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
