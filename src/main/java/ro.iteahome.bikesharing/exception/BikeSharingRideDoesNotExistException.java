package ro.iteahome.bikesharing.exception;

public class BikeSharingRideDoesNotExistException extends BikeSharingBusinessException{

    public BikeSharingRideDoesNotExistException(){
    }

    public BikeSharingRideDoesNotExistException(String message, Throwable cause) {super(message, cause);}
}