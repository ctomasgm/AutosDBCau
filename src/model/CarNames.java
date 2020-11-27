package model;

public class CarNames {

    private int id;
    private String model;
    private String descr;

    public CarNames() {
    }

    public CarNames(int id, String model, String descr) {
        this.id = id;
        this.model = model;
        this.descr = descr;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
    
}
