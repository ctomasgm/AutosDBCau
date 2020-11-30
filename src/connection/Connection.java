/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class Connection {

    DB db;
    DBCollection table;
    String collection;

    public Connection() {
    }
    
    public Connection(String collection) {
        this.collection = collection;
        Mongo mongo = new Mongo("LocalHost", 27017);
        this.db = mongo.getDB("scCar");
        this.table = db.getCollection(this.collection.toString());
    }

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.db = db;
    }

    public DBCollection getTable() {
        return table;
    }

    public void setTable(DBCollection table) {
        this.table = table;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }
}
