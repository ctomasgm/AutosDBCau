package model;

public class CarMakers {

    private int id;
    private String maker;
    private String fullName;
    private int country;

    public CarMakers() {
    }

    public CarMakers(int id, String maker, String fullName, int country) {
        this.id = id;
        this.maker = maker;
        this.fullName = fullName;
        this.country = country;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }
    
    
}
