package model;

import org.json.JSONObject;

public class Countries {

    private int countryId;
    private String countryName;
    private String continent;

    public Countries() {
    }
    
    public Countries(JSONObject json) {
        if (json.has("countryid")) {
            this.countryId = Integer.parseInt(json.get("countryid").toString());
        }
        if (json.has("countryname")) {
            this.countryName = json.get("countryname").toString();
        }
        if (json.has("continent")) {
            this.continent = json.get("continent").toString();
        }
    }

    public Countries(int countryId, String countryName, String continent) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.continent = continent;
    }

    
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
