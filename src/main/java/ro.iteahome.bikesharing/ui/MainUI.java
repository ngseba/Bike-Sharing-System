package ro.iteahome.bikesharing.ui;

import sun.rmi.runtime.Log;

import java.util.Scanner;

import static java.lang.System.exit;

public class MainUI {

    LoginUI loginUI = new LoginUI();
    SignUpUI signUpUI = new SignUpUI();
    public  void enteringUI() {
        printMainMessageAndHandleAction("Welcome to the BikeSharing System. Would you like to: \n" + "1. Log in.\n" + "2. Sign up.\n" + "X. Exit session.");
    }

    public  void printMainMessageAndHandleAction(String message) {
        System.out.println(message);
        Scanner firstSteps = new Scanner(System.in);
        String option = firstSteps.nextLine();

        try {
            switch (option) {
                case "1":
                    this.loginUI.displayLogin();
                    break;
                case "2":
                    this.signUpUI.displaySignUp();
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

    private static void displaySignUp() {
    }

}
