package controller;

import com.mongodb.DBCursor;
import connection.Connection;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

public class Controller_CarDetails {

    public Controller_CarDetails() {

    }

    public DefaultTableModel listCarDetails() {
        try {
            DefaultTableModel table = new DefaultTableModel();
            table.addColumn("ID");
            table.addColumn("MPG");
            table.addColumn("Cylinders");
            table.addColumn("Edispl");
            table.addColumn("Horse Power");
            table.addColumn("Weight");
            table.addColumn("Accel");
            table.addColumn("Year");
            String data[] = new String[8];
            Connection conne = new Connection("Car_Details");
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
                if (json.has("mpg")) {
                    data[1] = json.get("mpg").toString();
                } else {
                    data[1] = "";
                }
                if (json.has("cylinders")) {
                    data[2] = json.get("cylinders").toString();
                } else {
                    data[2] = "";
                }
                if (json.has("horsepower")) {
                    data[3] = json.get("horsepower").toString();
                } else {
                    data[3] = "";
                }
                if (json.has("weight")) {
                    data[4] = json.get("weight").toString();
                } else {
                    data[4] = "";
                }
                if (json.has("accel")) {
                    data[5] = json.get("accel").toString();
                } else {
                    data[5] = "";
                }
                if (json.has("year")) {
                    data[6] = json.get("year").toString();
                } else {
                    data[6] = "";
                }
                if (json.has("country")) {
                    data[7] = json.get("country").toString();
                } else {
                    data[7] = "";
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
