package model;

public class Continents {

    private int contId;
    private String continent;

    public Continents() {
    }

    public Continents(int contId, String continent) {
        this.contId = contId;
        this.continent = continent;
    }

    
    public int getContId() {
        return contId;
    }

    public void setContId(int contId) {
        this.contId = contId;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    
}
