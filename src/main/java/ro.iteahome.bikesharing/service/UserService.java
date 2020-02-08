package service;

import dao.UserDAO;
import exception.BikeSharingException;
import exception.BikeSharingUserAlreadyExistsException;
import exception.BikeSharingWrongCredentialsException;
import model.User;

public class UserService {

    private UserDAO userDao= new UserDAO();

    public User login(String inputEmail, String inputPassword) throws BikeSharingException {
        for (User user: userDao.readAllUsers()) {
            if (inputEmail.equals(user.getEmail()) && inputPassword.equals(user.getPassword())) {
                return user;
            }
        }
        throw new BikeSharingWrongCredentialsException();
    }

    public void signUp(User newUser) throws BikeSharingException {

        for (User user: userDao.readAllUsers()) {
            if (newUser.getEmail().equals(user.getEmail())) {
                throw new BikeSharingUserAlreadyExistsException();
            }
        }

        userDao.writeUser(newUser);
    }
}
