package exception;

import exception.BikeSharingBusinessException;

public class BikeSharingWrongCredentialsException extends BikeSharingBusinessException {

    public BikeSharingWrongCredentialsException(){
    }

    public BikeSharingWrongCredentialsException(String message, Throwable cause) {super(message, cause);}
}
