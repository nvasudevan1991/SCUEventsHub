package edu.scu.androidproject;


public class User {

    private int id;
    private String name;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fName) {this.firstName = fName; }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lName) { this.lastName = lName; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {this.confirmPassword = confirmPassword; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}