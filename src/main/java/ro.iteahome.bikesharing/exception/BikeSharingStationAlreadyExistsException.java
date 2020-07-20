package ro.iteahome.bikesharing.exception;

public class BikeSharingStationAlreadyExistsException extends BikeSharingBusinessException {

    public BikeSharingStationAlreadyExistsException(){
    }

    public BikeSharingStationAlreadyExistsException(String message, Throwable cause) {super(message, cause);}
}
