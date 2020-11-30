package controller;

import com.mongodb.DBCursor;
import connection.Connection;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

public class Controller_Continents {
    
    public Controller_Continents() {
    }
    
    public DefaultTableModel listContinents() {
        try {
            DefaultTableModel table = new DefaultTableModel();
            table.addColumn("Cont ID");
            table.addColumn("Continent");
            String data[] = new String[2];
            Connection conne = new Connection("Continents");
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
}
