package controller;

import com.mongodb.DBCursor;
import connection.Connection;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

public class Controller_ModelDetails {
    
    public Controller_ModelDetails() {
    }
    
    public DefaultTableModel listCarMakers() {
        try {
            DefaultTableModel table = new DefaultTableModel();
            table.addColumn("Model ID");
            table.addColumn("Maker");
            table.addColumn("Model");
            String data[] = new String[3];
            Connection conne = new Connection("Model_Details");
            DBCursor cursor = conne.getTable().find();
            JSONObject json = null;
            String data2 = "";

            while (cursor.hasNext()) {

                data2 = cursor.next().toString();
                json = new JSONObject(data2);
                System.out.println(json);

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
}
