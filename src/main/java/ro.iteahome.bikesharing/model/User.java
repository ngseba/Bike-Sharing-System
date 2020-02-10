package ro.iteahome.bikesharing.model;

public class User {

    private String email;
    private String password;
    private int id;
    private int isAdmin;


    public User() {
        this.id = -1;
        this.isAdmin = 0;
        this.email = "";
        this.password = "";
    }

    public User(int id, int isAdmin, String email, String password) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
}
