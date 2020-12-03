package controller;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import connection.Connection;
import javax.swing.table.DefaultTableModel;
import model.ModelDetails;
import org.json.JSONObject;

public class Controller_ModelDetails {

    Connection conne;

    public Controller_ModelDetails() {
    }

    public boolean insertModelDetails(ModelDetails data) {
        try {
            JSONObject jsonData = new JSONObject();
            jsonData.put("modelid", data.getModelId());
            jsonData.put("maker", data.getMaker());
            jsonData.put("model", data.getModel());

            DBObject dbObject = (DBObject) JSON.parse(jsonData.toString());
            conne.getTable().insert(dbObject);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public DefaultTableModel listModelDetails() {
        try {
            DefaultTableModel table = new DefaultTableModel();
            table.addColumn("Model ID");
            table.addColumn("Maker");
            table.addColumn("Model");
            String data[] = new String[3];
            conne = new Connection("Model_Details");
            DBCursor cursor = conne.getTable().find();
            JSONObject json = null;
            String data2 = "";

            while (cursor.hasNext()) {

                data2 = cursor.next().toString();
                json = new JSONObject(data2);

                if (json.has("modelid")) {
                    data[0] = json.get("modelid").toString();
                } else {
                    data[0] = "";
                }
                if (json.has("maker")) {
                    data[1] = json.get("maker").toString();
                } else {
                    data[1] = "";
                }
                if (json.has("model")) {
                    data[2] = json.get("model").toString();
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
    
    public JSONObject getModelDetail(int modelId) {
        try {
            conne = new Connection("Model_Details");
            JSONObject jsonData = new JSONObject();
            jsonData.put("modelid", modelId);

            DBObject dbObject = (DBObject) JSON.parse(jsonData.toString());
            DBObject res = conne.getTable().findOne(dbObject);
            JSONObject json = new JSONObject(res.toString());
     
            return json;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
    
    public boolean updateModelDetail(ModelDetails model) {
        try {
            conne = new Connection("Model_Details");
            JSONObject jsonData = new JSONObject();
            jsonData.put("modelid", model.getModelId());
            jsonData.put("maker", model.getMaker());
            jsonData.put("model", model.getModel());
            
            JSONObject jsonQuery = new JSONObject();
            jsonQuery.put("modelid", model.getModelId());

            DBObject dbObjectQuery = (DBObject) JSON.parse(jsonQuery.toString());

            DBObject dbObject = (DBObject) JSON.parse(jsonData.toString());
            conne.getTable().update(dbObjectQuery, dbObject);
            
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean deleteModelDetail(ModelDetails data){
        try{
            conne = new Connection("Model_Details");
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
