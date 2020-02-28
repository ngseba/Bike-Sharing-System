package ro.iteahome.bikesharing.service;

import ro.iteahome.bikesharing.dao.RideDAO;
import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingRideDoesNotExistException;
import ro.iteahome.bikesharing.exception.BikeSharingTechnicalException;
import ro.iteahome.bikesharing.model.Occurrence;
import ro.iteahome.bikesharing.model.Ride;
import ro.iteahome.bikesharing.model.Station;
import ro.iteahome.bikesharing.model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideService {

    private RideDAO rideDAO = new RideDAO();
    private StationService stationService;
    private BikeService bikeService;

    public RideService(StationService stationService,BikeService bikeService){
        this.stationService = stationService;
        this.bikeService = bikeService;
    }

    public StationService getStationService() {
        return stationService;
    }

    public BikeService getBikeService() {
        return bikeService;
    }

    public void addRide(Ride newRide) throws BikeSharingException {
        rideDAO.writeRide(newRide);
    }

    public int generateRideId() throws BikeSharingException {
        if (!rideDAO.readAllRides().isEmpty()) {
            return rideDAO.readAllRides().size() + 1;
        }
        return 1;
    }

    public String getMostCommonDay() throws BikeSharingTechnicalException {
        ArrayList<Ride> rideList = new ArrayList<>();
        if (!rideDAO.readAllRides().isEmpty()) {
            rideList = rideDAO.readAllRides();
        }
        HashMap<String,Integer> freqDays = new HashMap<>();
        for(Ride ride : rideList){
            String day = ride.getDate().format(DateTimeFormatter.ofPattern("EEEE"));
            int counter=freqDays.get(day)!=null ? freqDays.get(day):0;
            freqDays.put(day,counter+1);
        }
        String commonDay = new String();
        int max = 0;
        for(Map.Entry<String,Integer> entry : freqDays.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if(value > max)
            {
                max = value;
                commonDay = key;
            }
        }
        return commonDay;
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
    public List<Occurrence> getSortedListOfOccurencesByStartStation(ArrayList<Ride> rideList) throws BikeSharingException {
        List<Occurrence> occurencesByStation = new ArrayList();
        List<Integer> listOfExistingIds = new ArrayList();
        for (Ride ride : rideList) {
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
      return occurencesByStation;

        }

    //method to get a sorted list of users
    //based of the number of occurrences in the rides file
    //user that had raided most times
    //will be first
    public Occurrence getSortedListOfOccurrencesByUser() throws BikeSharingException {
        List<Occurrence> occurencesByUser = new ArrayList();
        List<Integer> listOfExistingIds = new ArrayList();
        UserService userService = new UserService();
        for (Ride ride : rideDAO.readAllRides()) {
            if(ride.getDate().compareTo(LocalDate.now().minus(6, ChronoUnit.MONTHS))>=0)
            { Occurrence newOccurrence = new Occurrence(ride.getUserId(), 1);
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

        }
        occurencesByUser.sort(Occurrence::compareTo);
        return occurencesByUser.get(0);
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