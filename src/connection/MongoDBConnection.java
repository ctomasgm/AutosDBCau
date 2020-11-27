package connection;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class MongoDBConnection {

    DB db;
    DBCollection tabla;

    public MongoDBConnection() {
        openConnection();
    }

    private void openConnection() {
        try {
            Mongo mongo = new Mongo("LocalHost", 27017);
            db = mongo.getDB("scCar");
            //tabla = db.getCollection("Continents");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
