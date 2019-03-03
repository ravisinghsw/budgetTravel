package com.ravi.travel.budget_travel.domain;


public class Destination {

    private long id;

    private String destinationName;

    private String city ;

    private String district;

    private Country country;

    private State state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "id=" + id +
                ", destinationName='" + destinationName + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", country=" + country +
                ", state=" + state +
                '}';
    }
}
