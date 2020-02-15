package ro.iteahome.bikesharing.ui;

public class MainUI {

    private LoginUI loginUI = new LoginUI();
    private SignUpUI signUpUI = new SignUpUI();


    public void start() {
        signUpUI.displaySignUp();
        //signUpUI.displaySignUp();

        //loginUI.displayLogin();

    }
}
