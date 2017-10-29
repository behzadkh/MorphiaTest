package com.behzad.morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bkhosrojerdi on 10/18/17.
 */
public class MongoFactory {


    private MongoFactory mongoFactory;

    private Datastore datastore;



    public Datastore instance() {

        if (mongoFactory == null) {
            init();
        }
        return datastore;
    }


    public long nextId(String key) {

        if (mongoFactory == null) {
            init();
        }
        MongoSequence seq = datastore.findAndModify(
                datastore.find(MongoSequence.class, "key = ", key), // query
                datastore.createUpdateOperations(MongoSequence.class).inc("next") // update
        );

        // create a sequence record for your collection if not found
        if (seq == null) {
            seq = new MongoSequence();
            seq.setKey(key);
            seq.setNext(1);
            datastore.save(seq);
            datastore.ensureIndexes(false);
        }

        return seq.getNext();
    }

    private void init() {
        System.out.println();
        if (mongoFactory == null) {

            String username = "vesal";
            String password ="123";// "123";
            String ip = "localhost";//"localhost";//"192.168.0.21";
            String port = "27017";
            String dbName = "vesal";

            MongoCredential mongoCredential = MongoCredential.createScramSha1Credential(username, dbName, password.toCharArray());
            List<MongoCredential> mongoCredentials = new ArrayList<>();
            mongoCredentials.add(mongoCredential);
            mongoFactory = new MongoFactory();
            MongoClient mongo = new MongoClient(new ServerAddress(ip, Integer.parseInt(port)), mongoCredentials);
            Morphia morphia = new Morphia();
            datastore = morphia.createDatastore(mongo, dbName);

        }
    }

}
