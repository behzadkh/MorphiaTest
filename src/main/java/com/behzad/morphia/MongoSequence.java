package com.behzad.morphia;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.utils.IndexDirection;

/**
 * Created by bkhosrojerdi on 10/18/17.
 */
@Entity(value = "sequence", noClassnameStored = true)
public class MongoSequence {


    @Property("key")
    @Indexed(value = IndexDirection.ASC, unique = true)
    private String key;


    @Property ("next")
    private long next;

    public String getKey() {

        return key;
    }

    public void setKey(String key) {

        this.key = key;
    }

    public long getNext() {

        return next;
    }

    public void setNext(long next) {

        this.next = next;
    }
}
