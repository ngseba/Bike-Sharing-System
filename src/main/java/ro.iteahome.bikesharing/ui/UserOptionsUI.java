package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingException;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class UserOptionsUI {
    public static void enteringUserOptionsUI() {
        printMainMessageAndHandleAction("What do you want to do today? \n" + "1. Ride.\n" + "2. View Previous Rides.\n" +
                "3. View All Stations.\n" + "4. View Most Used Stations.\n" + "5. Most Used Bikes.\n" + "9. Go back. \n" + "0. Exit session.");
    }

    public static void printMainMessageAndHandleAction(String message) {
        System.out.println(message);
        Scanner userOptions = new Scanner(System.in);
        String option = userOptions.nextLine();

        try {
            switch (option) {
                case "1":
                    AddRideUI.displayAddRideUI();
                    break;
                case "2":
                    //
                    break;
                case "3":

                    break;
                case "4":
                    //
                    break;
                case "5":
                    //
                case "9":
                    SignUpUI.MainUI.enteringUI();
                case "0":
                    System.out.println("You have terminated your session. Thank you and see you soon!");
                    exit(0);

                    break;


                default:
                    printMainMessageAndHandleAction("Error. Not a valid option. Press: \n" + "1. To Ride.\n" + "2. View Previous Rides.\n" + "3. View All Stations.\n" + "4. View Most Used Stations.\n" + "5. View Most Used Bikes.\n");
                    return;

            }
        } catch (Exception e) {
            e.printStackTrace();

            //Use same methods as in
        }

    }
}
