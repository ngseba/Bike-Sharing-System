package ro.iteahome.bikesharing;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.service.RideService;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws BikeSharingException, IOException {
        new ro.iteahome.bikesharing.MainUI().enteringUI();
    }

}