package com.example.roadsideassistant;


public class FourWheeler {
    private String Name;
    private String City;
    private String Contact;
    private String Services;
    private String Road;
    private String Address;

    public FourWheeler() {
    }

    public FourWheeler(String name, String city, String contact, String services, String road, String address) {
        Name = name;
        City = city;
        Contact = contact;
        Services = services;
        Road = road;
        Address = address;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) { City = city; }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getServices() {
        return Services;
    }

    public void setServices(String services) {
        Services = services;
    }

    public String getRoad() {
        return Road;
    }

    public void setRoad(String road) { Road = road; }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
