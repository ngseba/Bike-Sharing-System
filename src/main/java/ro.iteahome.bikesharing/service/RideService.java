package ro.iteahome.bikesharing.service;

import ro.iteahome.bikesharing.dao.RideDAO;
import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingFileException;
import ro.iteahome.bikesharing.exception.BikeSharingRideDoesNotExistException;

import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Bike;
import ro.iteahome.bikesharing.model.Occurrence;
import ro.iteahome.bikesharing.model.Ride;
import ro.iteahome.bikesharing.model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RideService {

    private RideDAO rideDAO = new RideDAO();
    private BikeService bikeService = new BikeService();
    private StationService stationService = new StationService();
    private UserService userService = new UserService();



    public void addRide(Ride newRide) throws BikeSharingException {
        rideDAO.writeRide(newRide);
    }

    public int generateRideId() throws BikeSharingException {
        if (!rideDAO.readAllRides().isEmpty()) {
            return rideDAO.readAllRides().size() + 1;
        }
        return 1;
    }

    public Ride getRideById(int id) throws BikeSharingException {
        if (!rideDAO.readAllRides().isEmpty()) {
            for (Ride ride : rideDAO.readAllRides()) {
                if (ride.getId() == id)
                    return ride;
            }
        }
        throw new BikeSharingRideDoesNotExistException();
    }

    //get all rides for a certain user by his userId
    //returns empty list or list of rides
    public ArrayList<Ride> getAllRidesByUserId(int userId) throws BikeSharingException {

        ArrayList rides = new ArrayList<Ride>();
        if (!rideDAO.readAllRides().isEmpty()) {
            for (Ride ride : rideDAO.readAllRides()) {
                if (ride.getUserId() == userId)
                    rides.add(ride);
            }

        }
        return rides;
    }

    //print a list of rides
    public ArrayList<Ride> getAllRides() throws BikeSharingException {
        ArrayList rideList = new ArrayList();
        if (!rideDAO.readAllRides().isEmpty()) {
             rideList = rideDAO.readAllRides();
        }
        return rideList;
    }


    //get all rides for a certain station by stationId - MOST POPULAR STATION
    //returns empty list or list of rides
    public ArrayList<Ride> getAllRidesByStartStationId(int startStationId) throws BikeSharingException {
        ArrayList rides = new ArrayList<Ride>();
        if (!rideDAO.readAllRides().isEmpty()) {
            for (Ride ride : rideDAO.readAllRides()) {
                if (ride.getStartStationId() == startStationId)
                    rides.add(ride);
            }

        }
        return rides;
    }

    public ArrayList<Ride> getBorrowedBikesHistory(int userId) throws BikeSharingTechnicalException {
        ArrayList<Ride> rideList = new ArrayList<>();
        for(Ride ride : rideDAO.readAllRides())
        {
            if(ride.getUserId()==userId)
                rideList.add(ride);
        }
        return rideList;

    }

    //method to get a sorted list of stations
    //based of the number of occurences in the rides file
    //station that has been used as a startStation most times
    //will be first
    //n defines how many of that list we want
    public void getSortedListOfOccurencesByStartStation(int n) throws BikeSharingTechnicalException {
        List<Occurrence> occurencesByStation = new ArrayList();
        List<Integer> listOfExistingIds = new ArrayList();
        for (Ride ride : rideDAO.readAllRides()) {
            Occurrence newOccurrence = new Occurrence(ride.getStartStationId(), 1);
            if (occurencesByStation.isEmpty()) {
                occurencesByStation.add(newOccurrence);
                listOfExistingIds.add(newOccurrence.getId());
            }
            else
                if (listOfExistingIds.contains(newOccurrence.getId()))
                    for (Occurrence o : occurencesByStation) {
                        if (o.getId() == newOccurrence.getId())
                            o.increaseNumberOfOccurences();
                    }
                else {
                    occurencesByStation.add(newOccurrence);
                    listOfExistingIds.add(newOccurrence.getId());
                }

            }
        occurencesByStation.sort(Occurrence::compareTo);
        for (Occurrence o : occurencesByStation)
            System.out.println("Station with id " + o.getId() + " has been used " + o.getNumberOfOccurences() + " times");

        }

    //method to get a sorted list of users
    //based of the number of occurrences in the rides file
    //user that had raided most times
    //will be first
    public void getSortedListOfOccurrencesByUser() throws BikeSharingException {
        List<Occurrence> occurencesByUser = new ArrayList();
        List<Integer> listOfExistingIds = new ArrayList();
        for (Ride ride : rideDAO.readAllRides()) {
            Occurrence newOccurrence = new Occurrence(ride.getUserId(), 1);
            if (occurencesByUser.isEmpty()) {
                occurencesByUser.add(newOccurrence);
                listOfExistingIds.add(newOccurrence.getId());
            }
            else
            if (listOfExistingIds.contains(newOccurrence.getId()))
                for (Occurrence o : occurencesByUser) {
                    if (o.getId() == newOccurrence.getId())
                        o.increaseNumberOfOccurences();
                }
            else {
                occurencesByUser.add(newOccurrence);
                listOfExistingIds.add(newOccurrence.getId());
            }

        }
        occurencesByUser.sort(Occurrence::compareTo);
        for (Occurrence o : occurencesByUser)
            System.out.println("User " + o.getId() + " " + userService.getUserById(o.getId()).getName() + " has used a bike " + o.getNumberOfOccurences() + " times");
    }

    //method to get a sorted list of bikes
    //based of the number of occurrences in the rides file
    //bike that has been used most times
    //will be first
    public void getSortedListOfOccurrencesByBike() throws BikeSharingException {
        List<Occurrence> occurencesByBike = new ArrayList();
        List<Integer> listOfExistingIds = new ArrayList();
        for (Ride ride : rideDAO.readAllRides()) {
            Occurrence newOccurrence = new Occurrence(ride.getBikeId(), 1);
            if (occurencesByBike.isEmpty()) {
                occurencesByBike.add(newOccurrence);
                listOfExistingIds.add(newOccurrence.getId());
            }
            else
            if (listOfExistingIds.contains(newOccurrence.getId()))
                for (Occurrence o : occurencesByBike) {
                    if (o.getId() == newOccurrence.getId())
                        o.increaseNumberOfOccurences();
                }
            else {
                occurencesByBike.add(newOccurrence);
                listOfExistingIds.add(newOccurrence.getId());
            }

        }
        occurencesByBike.sort(Occurrence::compareTo);
        for (Occurrence o : occurencesByBike)
            System.out.println("Bike " + o.getId() + " " + bikeService.getBikeById(o.getId()).getBrand() + " has been used " + o.getNumberOfOccurences() + " times");
    }
}