package ro.iteahome.bikesharing.service;


import ro.iteahome.bikesharing.dao.UserDAO;
import ro.iteahome.bikesharing.exception.*;
import ro.iteahome.bikesharing.model.User;

import java.util.ArrayList;

public class UserService {

    private UserDAO userDao = new UserDAO();

    public User login(String inputEmail, String inputPassword) throws BikeSharingException {
        for (User user : userDao.readAllUsers()) {
            if (inputEmail.equals(user.getEmail()) && inputPassword.equals(user.getPassword())) {
                return user;
            }
        }
        throw new BikeSharingWrongCredentialsException();
    }

    public void signUp(User newUser) throws BikeSharingException {

        for (User user : userDao.readAllUsers()) {
            if (newUser.getEmail().equals(user.getEmail())) {
                throw new BikeSharingUserAlreadyExistsException();
            }
        }

        userDao.writeUser(newUser);
    }


    public int generateUserId() throws BikeSharingException {
        if (!userDao.readAllUsers().isEmpty()) {
            for (User user : userDao.readAllUsers()) {
                System.out.println(user);
            }
            return userDao.readAllUsers().size() + 1;
        }
        return 1;
    }

    public User getUserById(int id) throws BikeSharingException {
        if (!userDao.readAllUsers().isEmpty()) {
            for (User user : userDao.readAllUsers()) {
                if (user.getId() == id)
                    return user;
            }
        }
        throw new BikeSharingBikeDoesNotExistException();
    }

    public ArrayList<User>getUserList() throws BikeSharingTechnicalException {
        ArrayList<User> userList = new ArrayList<>();
        if (!userDao.readAllUsers().isEmpty()) {
            userList = userDao.readAllUsers();
        }
        return userList;

    }

}


