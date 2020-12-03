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
            String data[] = new String[9];
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
                if (json.has("edispl")) {
                    data[3] = json.get("edispl").toString();
                } else {
                    data[3] = "";
                }
                if (json.has("horsepower")) {
                    data[4] = json.get("horsepower").toString();
                } else {
                    data[4] = "";
                }
                if (json.has("weight")) {
                    data[5] = json.get("weight").toString();
                } else {
                    data[5] = "";
                }
                if (json.has("accel")) {
                    data[6] = json.get("accel").toString();
                } else {
                    data[6] = "";
                }
                if (json.has("year")) {
                    data[7] = json.get("year").toString();
                } else {
                    data[7] = "";
                }
                if (json.has("country")) {
                    data[8] = json.get("country").toString();
                } else {
                    data[8] = "";
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
    
    public JSONObject getCarDetail(int carId) {
        try {
            conne = new Connection("Car_Details");
            JSONObject jsonData = new JSONObject();
            jsonData.put("id", carId);

            DBObject dbObject = (DBObject) JSON.parse(jsonData.toString());
            DBObject res = conne.getTable().findOne(dbObject);
            JSONObject json = new JSONObject(res.toString());
     
            return json;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
    
    public boolean updateCarDetail(CarDetails car) {
        try {
            conne = new Connection("Car_Details");
            JSONObject jsonData = new JSONObject();
            jsonData.put("id", car.getId());
            jsonData.put("mpg", car.getMpg());
            jsonData.put("cylinders", car.getCylinders());
            jsonData.put("edispl", car.getEdispl());
            jsonData.put("horsepower", car.getHorsepower());
            jsonData.put("weight", car.getWeight());
            jsonData.put("accel", car.getAccel());
            jsonData.put("year", car.getYear());
            
            JSONObject jsonQuery = new JSONObject();
            jsonQuery.put("id", car.getId());

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
