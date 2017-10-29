package com.behzad.morphia;

import org.mongodb.morphia.aggregation.Accumulator;
import org.mongodb.morphia.aggregation.AggregationPipeline;
import org.mongodb.morphia.aggregation.Group;
import org.mongodb.morphia.query.Query;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by bkhosrojerdi on 10/29/17.
 */
public class TestQuery {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Calendar cFrom = Calendar.getInstance();
        cFrom.setTime(new Date());
        cFrom.add(java.util.Calendar.DATE,-1);
        Date fromDate = cFrom.getTime();

        MongoFactory mongoFactory = new MongoFactory();
        Query<PushInteractive> query = mongoFactory.instance().createQuery(PushInteractive.class);
        query.and(
                query.criteria("insertdate").greaterThanOrEq(fromDate),
                query.criteria("insertdate").lessThan(new Date())
        );
        System.out.println("count : " + query.count());

    }
}
