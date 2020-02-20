package ro.iteahome.bikesharing;

import ro.iteahome.bikesharing.dao.BikeStationDAO;
import ro.iteahome.bikesharing.dao.StationDAO;
import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingStationAlreadyExistsException;
import ro.iteahome.bikesharing.exception.BikeSharingStationDoesNotExistException;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Bike;
import ro.iteahome.bikesharing.model.Bike_Station;
import ro.iteahome.bikesharing.model.Station;
import ro.iteahome.bikesharing.service.BikeService;
import ro.iteahome.bikesharing.service.BikeStationService;
import ro.iteahome.bikesharing.ui.MainUI;
import ro.iteahome.bikesharing.service.StationService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws IOException, BikeSharingTechnicalException {
        //new MainUI().start();

        BikeStationDAO bsdao = new BikeStationDAO();


        BikeStationService bss = new BikeStationService();


        bsdao.writeBikeToStation(1,6);
        bsdao.writeBikeToStation(2,6);
        bsdao.writeBikeToStation(3,6);
        bsdao.writeBikeToStation(4,6);
        bsdao.writeBikeToStation(5,6);
        bsdao.writeBikeToStation(6,6);
        bsdao.writeBikeToStation(7,6);


        bss.moveBikeFromStartStationToDestinationStation(1, 6, 2);



        //Bike_Station bs1 = new Bike_Station(1, 1);
        //Bike_Station bs2 = new Bike_Station(2, 1);

        //bsdao.removeOldPosition(bs1);

    }

}

