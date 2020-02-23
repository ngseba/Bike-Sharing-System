package ro.iteahome.bikesharing.ui;

import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.service.BikeStationService;

public class UserListBikesFromStationUI {

    public static void listBikesfromStation() {

        try {
            BikeStationService.printOutBikesOfStationByStationId(Integer.valueOf(UserListBikesUI.valuefromscanner));
        } catch (BikeSharingTechnicalException e) {
            e.printStackTrace();
        }

    }

}
