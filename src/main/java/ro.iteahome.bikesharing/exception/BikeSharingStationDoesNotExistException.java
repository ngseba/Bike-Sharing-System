package ro.iteahome.bikesharing.exception;

public class BikeSharingStationDoesNotExistException extends BikeSharingBusinessException {

    public BikeSharingStationDoesNotExistException(){
    }

    public BikeSharingStationDoesNotExistException(String message, Throwable cause) {super(message, cause);}
}