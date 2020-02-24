package ro.iteahome.bikesharing.ui;

import java.util.Scanner;

import static java.lang.System.exit;

public class UserOptionsUI {
    public static void enteringUserOptionsUI() {
        printMainMessageAndHandleAction("What do you want to do today? \n" + "1. Ride.\n" + "2. View Previous Rides.\n" +
                "3. View All Stations.\n" + "4. View Most Used Stations.\n" + "5. Most Used Bikes.\n" + "B. Go back. \n" + "X. Exit session.");
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
                    //RideService.printrideslist();
                    break;
                case "3":
                    UserListBikesUI.listStations();
                    break;
                case "4":
                    //ride service
                    break;
                case "5":
                    //ride service
                case "b":
                case "B":
                    MainUI.enteringUI();
                case "x":
                case "X":
                    System.out.println("You have terminated your session. Thank you and see you soon!");
                    exit(0);

                    break;


                default:
                    printMainMessageAndHandleAction("Error. Not a valid option. Press: \n" + "1. To Ride.\n" + "2. View Previous Rides.\n" + "3. View All Stations.\n" +
                            "4. View Most Used Stations.\n" + "5. View Most Used Bikes.\n" + "B. Go back. \n" + "X. Exit session.");
                    return;

            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
