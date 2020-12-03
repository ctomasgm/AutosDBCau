package controller;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import connection.Connection;
import javax.swing.table.DefaultTableModel;
import model.CarNames;
import model.Countries;
import org.json.JSONObject;

public class Controller_Countries {

    Connection conne;

    public Controller_Countries() {

    }

    public boolean insertCountries(Countries data) {
        try {
            JSONObject jsonData = new JSONObject();
            jsonData.put("countryid", data.getCountryId());
            jsonData.put("countryname", data.getCountryName());
            jsonData.put("continent", data.getContinent());

            DBObject dbObject = (DBObject) JSON.parse(jsonData.toString());
            conne.getTable().insert(dbObject);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public DefaultTableModel listCountries() {
        try {
            DefaultTableModel table = new DefaultTableModel();
            table.addColumn("Country ID");
            table.addColumn("Country Name");
            table.addColumn("Continent ");
            String data[] = new String[3];
            conne = new Connection("Countries");
            DBCursor cursor = conne.getTable().find();
            JSONObject json = null;
            String data2 = "";

            while (cursor.hasNext()) {

                data2 = cursor.next().toString();
                json = new JSONObject(data2);

                if (json.has("countryid")) {
                    data[0] = json.get("countryid").toString();
                } else {
                    data[0] = "";
                }
                if (json.has("countryname")) {
                    data[1] = json.get("countryname").toString();
                } else {
                    data[1] = "";
                }
                if (json.has("continent")) {
                    data[2] = json.get("continent").toString();
                } else {
                    data[2] = "";
                }

                table.addRow(data);
            }

            return table;
        } catch (Exception e) {
            DefaultTableModel table = new DefaultTableModel();
            String data[] = new String[1];
            data[0] = e.toString();
            table.addColumn("Error");
            table.addRow(data);
            return table;
        }
    }
    
    public JSONObject getCountry(int countryId) {
        try {
            conne = new Connection("Countries");
            JSONObject jsonData = new JSONObject();
            jsonData.put("countryid", countryId);

            DBObject dbObject = (DBObject) JSON.parse(jsonData.toString());
            DBObject res = conne.getTable().findOne(dbObject);
            JSONObject json = new JSONObject(res.toString());
     
            return json;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
    
    public boolean updateCountry(Countries country) {
        try {
            conne = new Connection("Countries");
            JSONObject jsonData = new JSONObject();
            jsonData.put("countryid", country.getCountryId());
            jsonData.put("countryname", country.getCountryName());
            jsonData.put("continent", country.getContinent());
            
            JSONObject jsonQuery = new JSONObject();
            jsonQuery.put("countryid", country.getCountryId());

            DBObject dbObjectQuery = (DBObject) JSON.parse(jsonQuery.toString());

            DBObject dbObject = (DBObject) JSON.parse(jsonData.toString());
            conne.getTable().update(dbObjectQuery, dbObject);
            
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean deleteCountries(Countries data){
        try{
            conne = new Connection("Coutries");
            JSONObject jsonData = new JSONObject();
            
            DBObject dbObject = (DBObject) JSON.parse(jsonData.toString());
            conne.getTable().remove(dbObject);
            
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}
