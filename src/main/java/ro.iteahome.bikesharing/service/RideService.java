package ro.iteahome.bikesharing.service;

import ro.iteahome.bikesharing.dao.RideDAO;
import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingRideDoesNotExistException;

import ro.iteahome.bikesharing.model.Ride;

import java.util.ArrayList;

public class RideService {

    private RideDAO rideDAO = new RideDAO();



    public void addRide(Ride newRide) throws BikeSharingException {
        rideDAO.writeRide(newRide);
    }

    public int generateRideId() throws BikeSharingException {
        if (!rideDAO.readAllRides().isEmpty()) {
            for (Ride ride : rideDAO.readAllRides()) {
                System.out.println(ride);
            }
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
    public void printRidesList(ArrayList<Ride> rides) throws BikeSharingException {
        if (!rides.isEmpty())
            for (Ride ride : rideDAO.readAllRides()) {
                System.out.println(ride.toString());
            }
        else System.out.println("No available rides!");
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


}