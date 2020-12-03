package controller;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import connection.Connection;
import javax.swing.table.DefaultTableModel;
import model.CarMakers;
import model.CarNames;
import org.json.JSONObject;

public class Controller_CarNames {

    Connection conne;

    public Controller_CarNames() {
    }

    public boolean insertCarNames(CarNames data) {
        try {
            JSONObject jsonData = new JSONObject();
            jsonData.put("id", data.getId());
            jsonData.put("model", data.getModel());
            jsonData.put("descr", data.getDescr());

            DBObject dbObject = (DBObject) JSON.parse(jsonData.toString());
            conne.getTable().insert(dbObject);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public DefaultTableModel listCarNames() {
        try {
            DefaultTableModel table = new DefaultTableModel();
            table.addColumn("ID");
            table.addColumn("Model");
            table.addColumn("Description");
            String data[] = new String[3];
            conne = new Connection("Car_Names");
            DBCursor cursor = conne.getTable().find();
            JSONObject json = null;
            String data2 = "";

            while (cursor.hasNext()) {

                data2 = cursor.next().toString();
                json = new JSONObject(data2);

                if (json.has("id")) {
                    data[0] = json.get("id").toString();
                } else {
                    data[0] = "";
                }
                if (json.has("model")) {
                    data[1] = json.get("model").toString();
                } else {
                    data[1] = "";
                }
                if (json.has("descr")) {
                    data[2] = json.get("descr").toString();
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
    
    public JSONObject getCarName(int carNameId) {
        try {
            conne = new Connection("Car_Names");
            JSONObject jsonData = new JSONObject();
            jsonData.put("id", carNameId);

            DBObject dbObject = (DBObject) JSON.parse(jsonData.toString());
            DBObject res = conne.getTable().findOne(dbObject);
            JSONObject json = new JSONObject(res.toString());
     
            return json;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
    
    public boolean updateCarName(CarNames carName) {
        try {
            conne = new Connection("Car_Names");
            JSONObject jsonData = new JSONObject();
            jsonData.put("id", carName.getId());
            jsonData.put("model", carName.getModel());
            jsonData.put("descr", carName.getDescr());
            
            JSONObject jsonQuery = new JSONObject();
            jsonQuery.put("id", carName.getId());

            DBObject dbObjectQuery = (DBObject) JSON.parse(jsonQuery.toString());

            DBObject dbObject = (DBObject) JSON.parse(jsonData.toString());
            conne.getTable().update(dbObjectQuery, dbObject);
            
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
