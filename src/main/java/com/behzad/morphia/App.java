package com.behzad.morphia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mongodb.morphia.aggregation.Accumulator;
import org.mongodb.morphia.aggregation.AggregationPipeline;
import org.mongodb.morphia.aggregation.Group;
import org.mongodb.morphia.query.Query;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Gson gson = new Gson();
        System.out.println("Hello World!");

        Calendar cFrom = Calendar.getInstance();
        cFrom.setTime(new Date());
        cFrom.add(java.util.Calendar.DATE,-100);
        Date fromDate = cFrom.getTime();

        MongoFactory mongoFactory = new MongoFactory();
        Query<PushInteractive> query = mongoFactory.instance().createQuery(PushInteractive.class);
        query.and(
                query.criteria("insertdate").greaterThanOrEq(fromDate),
                query.criteria("insertdate").lessThan(new Date())
        );
        AggregationPipeline pipeline = mongoFactory.instance()
                .createAggregation(PushInteractive.class)
                .match(query)
                .group(
                        Group.id(
                                Group.grouping("customerid")
                        ),
                        Group.grouping("count", new Accumulator("$sum", "1"))
                );
        Iterator<Output> test = pipeline.aggregate(Output.class);
        while (test.hasNext()){
//            Output output = (Output) test.next();
            Output output = (Output) test.next();

             Output.SubClass s = gson.fromJson(output.get_id(), Output.SubClass.class);
            System.out.println("next : " +s.getStatus() + " \t "+s.getCustomerid()+"\t"+output.getCount());
//            System.out.println("count : " + output.getCount() + "\t c:"+output.getId().getCustomerid());
        }
    }
}
