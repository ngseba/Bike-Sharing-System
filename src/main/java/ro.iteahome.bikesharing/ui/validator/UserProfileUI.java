package ro.iteahome.bikesharing.ui.validator;

import ro.iteahome.bikesharing.model.User;

public class UserProfileUI {
    User user;
    public UserProfileUI(User user){
        this.user = user;
    }
    public void printUserProfile(){
        System.out.println("User profile : ");
        System.out.println("Name :"+user.getName());
        System.out.println("Email:"+user.getEmail());
        System.out.println("Password"+user.getPassword());
    }
}
