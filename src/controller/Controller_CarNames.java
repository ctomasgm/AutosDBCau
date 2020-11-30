package controller;

import com.mongodb.DBCursor;
import connection.Connection;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

public class Controller_CarNames {
    
    public Controller_CarNames() {
    }
    
    public DefaultTableModel listCarNames() {
        try {
            DefaultTableModel table = new DefaultTableModel();
            table.addColumn("ID");
            table.addColumn("Model");
            table.addColumn("Description");
            String data[] = new String[3];
            Connection conne = new Connection("Car_Names");
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
}
