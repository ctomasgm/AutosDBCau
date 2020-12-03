package controller;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import connection.Connection;
import javax.swing.table.DefaultTableModel;
import model.Continents;
import org.json.JSONObject;

public class Controller_Continents {

    Connection conne;

    public Controller_Continents() {
    }

    public boolean insertContinents(Continents data) {
        try {
            JSONObject jsonData = new JSONObject();
            jsonData.put("contid", data.getContId());
            jsonData.put("continent", data.getContinent());

            DBObject dbObject = (DBObject) JSON.parse(jsonData.toString());
            conne.getTable().insert(dbObject);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public DefaultTableModel listContinents() {
        try {
            DefaultTableModel table = new DefaultTableModel();
            table.addColumn("Cont ID");
            table.addColumn("Continent");
            String data[] = new String[2];
            conne = new Connection("Continents");
            DBCursor cursor = conne.getTable().find();
            JSONObject json = null;
            String data2 = "";

            while (cursor.hasNext()) {

                data2 = cursor.next().toString();
                json = new JSONObject(data2);

                if (json.has("contid")) {
                    data[0] = json.get("contid").toString();
                } else {
                    data[0] = "";
                }
                if (json.has("continent")) {
                    data[1] = json.get("continent").toString();
                } else {
                    data[1] = "";
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
    
    public JSONObject getContinent(int continentId) {
        try {
            conne = new Connection("Continents");
            JSONObject jsonData = new JSONObject();
            jsonData.put("contid", continentId);

            DBObject dbObject = (DBObject) JSON.parse(jsonData.toString());
            DBObject res = conne.getTable().findOne(dbObject);
            JSONObject json = new JSONObject(res.toString());
     
            return json;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
    
    public boolean updateContinent(Continents continent) {
        try {
            conne = new Connection("Continents");
            JSONObject jsonData = new JSONObject();
            jsonData.put("contid", continent.getContId());
            jsonData.put("continent", continent.getContinent());
            
            JSONObject jsonQuery = new JSONObject();
            jsonQuery.put("contid", continent.getContId());

            DBObject dbObjectQuery = (DBObject) JSON.parse(jsonQuery.toString());

            DBObject dbObject = (DBObject) JSON.parse(jsonData.toString());
            conne.getTable().update(dbObjectQuery, dbObject);
            
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean deleteContinents(Continents data){
        try{
            conne = new Connection("Continents");
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
