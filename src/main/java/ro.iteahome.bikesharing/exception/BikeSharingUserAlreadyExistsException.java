package exception;

import exception.BikeSharingBusinessException;

public class BikeSharingUserAlreadyExistsException extends BikeSharingBusinessException {

    public BikeSharingUserAlreadyExistsException(){
    }

    public BikeSharingUserAlreadyExistsException(String message, Throwable cause) {super(message, cause);}
}
