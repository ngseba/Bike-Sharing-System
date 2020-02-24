package ro.iteahome.bikesharing.ui;

import java.util.Scanner;

import static java.lang.System.exit;
import static ro.iteahome.bikesharing.ui.SignUpUI.displaySignUp;

public class MainUI {

    public static void enteringUI() {
        printMainMessageAndHandleAction("Welcome to the BikeSharing System. Would you like to: \n" + "1. Log in.\n" + "2. Sign up.\n" + "X. Exit session.");
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
                case "x":
                case "X":
                    System.out.println("You have terminated your session. Thank you and see you soon!");
                    exit(0);
                default:
                    printMainMessageAndHandleAction("Error. Not a valid option. Press: \n" + "1. to Log in... \n" + "2. To Sign up, or...\n" + "X. To Exit session.");
                    return;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
