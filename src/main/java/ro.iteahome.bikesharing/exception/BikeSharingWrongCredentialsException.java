package ro.iteahome.bikesharing.exception;

public class BikeSharingWrongCredentialsException extends BikeSharingBusinessException {

    public BikeSharingWrongCredentialsException(){
    }

    public BikeSharingWrongCredentialsException(String message, Throwable cause) {super(message, cause);}
}
