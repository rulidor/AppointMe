package com.example.appointme.ServiceProvider;

public class ServiceProvider {

    private String occupation;
    private String firstName;
    private String lastName;
    private String phone;
    private String addrs;
    private String description;

    public ServiceProvider(String occupation, String firstName, String lastName, String phone, String addrs, String description) {
        this.occupation = occupation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.addrs = addrs;
        this.description = description;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddrs() {
        return addrs;
    }

    public void setAddrs(String addrs) {
        this.addrs = addrs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
