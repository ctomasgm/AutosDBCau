package controller;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import connection.Connection;
import javax.swing.table.DefaultTableModel;
import model.CarDetails;
import org.json.JSONObject;

public class Controller_CarDetails {

    Connection conne;

    public Controller_CarDetails() {

    }

    public boolean insertCarDetails(CarDetails data) {
        try {
            JSONObject jsonData = new JSONObject();
            jsonData.put("id", data.getId());
            jsonData.put("mpg", data.getMpg());
            jsonData.put("cylinders", data.getCylinders());
            jsonData.put("edispl", data.getEdispl());
            jsonData.put("horsepower", data.getHorsepower());
            jsonData.put("weight", data.getWeight());
            jsonData.put("accel", data.getAccel());
            jsonData.put("year", data.getYear());

            DBObject dbObject = (DBObject) JSON.parse(jsonData.toString());
            conne.getTable().insert(dbObject);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public DefaultTableModel listCarDetails() {
        try {
            DefaultTableModel table = new DefaultTableModel();
            conne = new Connection("Car_Details");
            table.addColumn("ID");
            table.addColumn("MPG");
            table.addColumn("Cylinders");
            table.addColumn("Edispl");
            table.addColumn("Horse Power");
            table.addColumn("Weight");
            table.addColumn("Accel");
            table.addColumn("Year");
            String data[] = new String[8];
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
