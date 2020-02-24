package ro.iteahome.bikesharing.ui;

import java.util.Scanner;

import static java.lang.System.exit;

public class AdminOptionsUi {

    public static void enteringAdminOptionsUI() {

        printMainMessageAndHandleAction("What do you want to do today? \n" + "1. View Users.\n" +
                "2. View Stations.\n" + "3. View Bikes per Stations.\n" + "4. Top 5 Users.\n" + "5. Top 5 Most Used Stations.\n" +
                "6. Top 5 Most Used Bikes.\n" + "7. Add New Station.\n" + "8. Add New Bike.\n " + "B. Go back. \n" + "X. Exit session.");

    }

    public static void printMainMessageAndHandleAction(String message) {
        System.out.println(message);
        Scanner userOptions = new Scanner(System.in);
        String option = userOptions.nextLine();

        try {
            switch (option) {
                case "1":
                    //
                    break;
                case "2":
                    //
                    break;
                case "3":
                    //
                    break;
                case "4":
                    //
                    break;
                case "5":
                    //
                    break;
                case "6":
                //
                    break;
                case "7":
                    AdminAddStationUi.adminAddStation();
                    break;
                case "8":
                    AdminAddBikeUI.adminAddBikeUI();
                    break;
                case "b":
                case "B":
                    MainUI.enteringUI();
                case "x":
                case "X":
                    System.out.println("You have terminated your session. Thank you and see you soon!");
                    exit(0);

                    break;

                default:
                    printMainMessageAndHandleAction("Error. Not a valid option. Press: \n" + "1. View Users.\n" +
                            "2. View Stations.\n" + "3. View Bikes per Stations.\n" + "4. Top 5 Users.\n" + "5. Top 5 Most Used Stations.\n" +
                            "6. Top 5 Most Used Bikes.\n" + "7. Add New Station.\n" + "8. Add New Bike.\n " + "B. Go back. \n" + "X. Exit session.");
                    return;

            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}