package ro.iteahome.bikesharing.service;


import ro.iteahome.bikesharing.dao.StationDAO;
import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingStationAlreadyExistsException;
import ro.iteahome.bikesharing.exception.BikeSharingStationDoesNotExistException;
import ro.iteahome.bikesharing.model.Station;

public class StationService {

    private StationDAO stationDAO = new StationDAO();



    public void addStation(Station newStation) throws BikeSharingException {

        for (Station station : stationDAO.readAllStations()) {
            if (newStation.getName().equals(station.getName())) {
                throw new BikeSharingStationAlreadyExistsException();
            }
        }

        stationDAO.writeStation(newStation);
    }

    public int generateStationId() throws BikeSharingException {
        if (!stationDAO.readAllStations().isEmpty()) {
            for (Station station : stationDAO.readAllStations()) {
                System.out.println(station);
            }
            return stationDAO.readAllStations().size() + 1;
        }
        return 1;
    }

    public Station getStationById(int id) throws BikeSharingException{
        for (Station station : stationDAO.readAllStations()){
            if(station.getId() == id)
                return station;
        }
        throw new BikeSharingStationDoesNotExistException();
    }



}
