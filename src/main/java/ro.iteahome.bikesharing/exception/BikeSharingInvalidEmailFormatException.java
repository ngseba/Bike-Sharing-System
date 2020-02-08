package exception;

public class BikeSharingInvalidEmailFormatException extends BikeSharingBusinessException{

    public BikeSharingInvalidEmailFormatException(){
    }

    public BikeSharingInvalidEmailFormatException(String message, Throwable cause) {super(message, cause);}
}
