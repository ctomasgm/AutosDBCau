package model;

import org.json.JSONObject;

public class Continents {

    private int contId;
    private String continent;

    public Continents() {
    }
    
    public Continents(JSONObject json) {
        if (json.has("contid")) {
            this.contId = Integer.parseInt(json.get("contid").toString());
        }
        if (json.has("continent")) {
            this.continent = json.get("continent").toString();
        }
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
