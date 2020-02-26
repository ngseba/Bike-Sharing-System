package ro.iteahome.bikesharing.model;

public class User {

    private int id;
    private int isAdmin;
    private String email;
    private String password;
    private String name;

    @Override
    public String toString() {
        return this.id+". "+this.name+" "+this.email;
    }

    public User() {
        this.id = -1;
        this.isAdmin = 0;
        this.email = "";
        this.password = "";
        this.name = "";
    }

    public User(int id, int isAdmin, String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.id = id;
        this.name = name;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

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
