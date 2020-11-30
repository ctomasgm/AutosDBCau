package controller;

import com.mongodb.DBCursor;
import connection.Connection;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

public class Controller_Countries {

    public Controller_Countries() {

    }

    public DefaultTableModel listCountries() {
        try {
            DefaultTableModel table = new DefaultTableModel();
            table.addColumn("Country ID");
            table.addColumn("Country Name");
            table.addColumn("Continent ");
            String data[] = new String[3];
            Connection conne = new Connection("Countries");
            DBCursor cursor = conne.getTable().find();
            JSONObject json = null;
            String data2 = "";

            while (cursor.hasNext()) {

                data2 = cursor.next().toString();
                json = new JSONObject(data2);
               
                if (json.has("countryid")) {
                    data[0] = json.get("countryid").toString();
                } else {
                    data[0] = "";
                }
                if (json.has("countryname")) {
                    data[1] = json.get("countryname").toString();
                } else {
                    data[1] = "";
                }
                if (json.has("continent")) {
                    data[2] = json.get("continent").toString();
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
