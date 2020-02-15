package ro.iteahome.bikesharing.exception;

public class BikeSharingBikeDoesNotExistException extends BikeSharingBusinessException {

    public BikeSharingBikeDoesNotExistException(){
    }

    public BikeSharingBikeDoesNotExistException(String message, Throwable cause) {super(message, cause);}
}