package com.behzad.morphia;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import java.util.List;

/**
 * Created by bkhosrojerdi on 10/21/17.
 */
//@Entity(value = "output", noClassnameStored = true)
public class Output {
//    @Id
//    @Property("id")
    private String _id ;

//    @Property("count")
    private String count;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }


    @Override
    public String toString() {
        return "Output{" +
                "_id=" + _id +
                ", count='" + count + '\'' +
                '}';
    }

    public class SubClass{
        private long customerid;
        private String status;

        public long getCustomerid() {
            return customerid;
        }

        public void setCustomerid(long customerid) {
            this.customerid = customerid;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "SubClass{" +
                    "customerid=" + customerid +
                    ", status='" + status + '\'' +
                    '}';
        }
    }
}
