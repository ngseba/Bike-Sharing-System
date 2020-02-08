package exception;

public class BikeSharingPasswordTooShortException extends BikeSharingBusinessException{

    public BikeSharingPasswordTooShortException(){
    }

    public BikeSharingPasswordTooShortException(String message, Throwable cause) {super(message, cause);}
}
