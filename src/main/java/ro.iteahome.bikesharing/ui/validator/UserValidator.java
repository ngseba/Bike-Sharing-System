package ro.iteahome.bikesharing.ui.validator;

import ro.iteahome.bikesharing.exception.BikeSharingException;
import ro.iteahome.bikesharing.exception.BikeSharingInvalidEmailFormatException;
import ro.iteahome.bikesharing.exception.BikeSharingInvalidPasswordFormatException;
import ro.iteahome.bikesharing.exception.BikeSharingPasswordTooShortException;

import java.util.regex.Pattern;

public class UserValidator {

    public void validateUserCredentials(String email, String password) throws BikeSharingException {
        try {
            validateEmailFormat(email);
            ValidatePasswordFormat(password);
            validatePasswordLength(password);
        } catch (BikeSharingInvalidEmailFormatException e) {
            e.printStackTrace();
            System.out.println("Invalid Email Format");
        } catch (BikeSharingPasswordTooShortException e){
            e.printStackTrace();
            System.out.println("The password has less than 6 characters");
        } catch (BikeSharingInvalidPasswordFormatException e){
            e.printStackTrace();
            System.out.println("The password has to have upper case letter and lower case letters, with no special characters or numbers");
        }
    }

    private void validateEmailFormat(String email) throws BikeSharingException {
        String patternString = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(patternString);

        if ((email == null) || !pattern.matcher(email).matches())
            throw new BikeSharingInvalidEmailFormatException();
    }

    private void validatePasswordLength(String password) throws BikeSharingException {
        if (password.length() < 6)
            throw new BikeSharingPasswordTooShortException();
    }

    private void ValidatePasswordFormat(String password) throws BikeSharingException {
        String patternString = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$";
        Pattern pattern = Pattern.compile(patternString);

        if ((password == null) || !pattern.matcher(password).matches())
            throw new BikeSharingInvalidPasswordFormatException();
    }
}
