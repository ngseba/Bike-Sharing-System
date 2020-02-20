package ro.iteahome.bikesharing.ui;

import java.util.Scanner;

public class UserOptionsUI {
    public static void enteringUserOptionsUI() {
        printMainMessageAndHandleAction("What do you want to do today? \n" + "1. Ride.\n" + "2. View Previous Rides.\n" + "3. View All Stations.\n" + "4. View Most Used Stations.\n" + "5. Most Used Bikes.\n");
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
