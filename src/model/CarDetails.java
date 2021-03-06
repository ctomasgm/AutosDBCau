package model;

import javax.swing.JTextField;
import org.json.JSONObject;

public class CarDetails {

    public int id;
    private double mpg;
    private int cylinders;
    private int edispl;
    private int horsepower;
    private int weight;
    private double accel;
    private int year;

    public CarDetails() {
    }
    
    public CarDetails(JSONObject json) {
        if (json.has("year")) {
            this.year = Integer.parseInt(json.get("year").toString());
        }
        if (json.has("id")) {
            this.id = Integer.parseInt(json.get("id").toString());
        }
        if (json.has("mpg")) {
            this.mpg = Double.parseDouble(json.get("mpg").toString());
        }
        if (json.has("accel")) {
            this.accel = Double.parseDouble(json.get("accel").toString());
        }
        if (json.has("cylinders")) {
            this.cylinders = Integer.parseInt(json.get("cylinders").toString());
        }
        if (json.has("edispl")) {
            this.edispl = Integer.parseInt(json.get("edispl").toString());
        }
        if (json.has("horsepower")) {
            this.horsepower = Integer.parseInt(json.get("horsepower").toString());
        }
        if (json.has("weight")) {
            this.weight = Integer.parseInt(json.get("weight").toString());
        } 
    }

    public CarDetails(int id, double mpg, int cylinders, int edispl, int horsepower, int weight, double accel, int year) {
        this.id = id;
        this.mpg = mpg;
        this.cylinders = cylinders;
        this.edispl = edispl;
        this.horsepower = horsepower;
        this.weight = weight;
        this.accel = accel;
        this.year = year;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMpg() {
        return mpg;
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public int getEdispl() {
        return edispl;
    }

    public void setEdispl(int edispl) {
        this.edispl = edispl;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getAccel() {
        return accel;
    }

    public void setAccel(double accel) {
        this.accel = accel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
