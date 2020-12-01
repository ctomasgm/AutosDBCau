package controller;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import connection.Connection;
import javax.swing.table.DefaultTableModel;
import model.CarMakers;
import org.json.JSONObject;

public class Controller_CarMakers {

    Connection conne;

    public Controller_CarMakers() {

    }

    public boolean insertCarMakers(CarMakers data) {
        try {
            JSONObject jsonData = new JSONObject();
            jsonData.put("id", data.getId());
            jsonData.put("maker", data.getMaker());
            jsonData.put("fulllname", data.getFullName());
            jsonData.put("country", data.getCountry());

            DBObject dbObject = (DBObject) JSON.parse(jsonData.toString());
            conne.getTable().insert(dbObject);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public DefaultTableModel listCarMakers() {
        try {
            DefaultTableModel table = new DefaultTableModel();
            table.addColumn("ID");
            table.addColumn("Maker");
            table.addColumn("Full Name");
            table.addColumn("Country");
            String data[] = new String[4];
            conne = new Connection("Car_Makers");
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
                if (json.has("maker")) {
                    data[1] = json.get("maker").toString();
                } else {
                    data[1] = "";
                }
                if (json.has("fullname")) {
                    data[2] = json.get("fullname").toString();
                } else {
                    data[2] = "";
                }
                if (json.has("country")) {
                    data[3] = json.get("country").toString();
                } else {
                    data[3] = "";
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
}
