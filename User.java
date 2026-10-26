package OOPproject;

public class User {
    private String Password;
    private String Username;

    public User(String password , String Username) {
        this.Password = password;
        this.Username=Username;

    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "Password='" + Password + '\'' +
                ", Username='" + Username + '\'' +
                '}';
    }
}
