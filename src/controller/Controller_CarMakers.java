package controller;

import com.mongodb.DBCursor;
import connection.Connection;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

public class Controller_CarMakers {

    public Controller_CarMakers() {

    }

    public DefaultTableModel listCarMakers() {
        try {
            DefaultTableModel table = new DefaultTableModel();
            table.addColumn("ID");
            table.addColumn("Maker");
            table.addColumn("Full Name");
            table.addColumn("Country");
            String data[] = new String[4];
            Connection conne = new Connection("Car_Makers");
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
