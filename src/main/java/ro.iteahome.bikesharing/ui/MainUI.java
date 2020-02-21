package ro.iteahome.bikesharing;
import ro.iteahome.bikesharing.ui.LoginUI;
import ro.iteahome.bikesharing.ui.SignUpUI;

import java.util.Scanner;


public class MainUI {

    void enteringUI() {
        printMainMessageAndHandleAction("Welcome to the BikeSharing System. Would you like to: \n" + "1. Log in.\n" + "2. Sign up.\n");
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
                    SignUpUI.displaySignUp();
                    break;
                default:
                    printMainMessageAndHandleAction("Error. Not a valid option. Press: \n" + "1. to Log in... or\n" + "2. To Sign up.\n");
                    return;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}