package com.behzad.morphia;

/**
 * Created by bkhosrojerdi on 10/22/17.
 */
public class App2 {
    public static void main(String[] args) {
        String text = "تست پیام تعاملی ";
        int size = text.getBytes().length;
        double partCount = (size / (1 * 1024)) == 0 ? 1 : Math.ceil((size/ (1 * 1024)));
        double cost = partCount * 10;
        System.out.println("cost:"+cost);


        String text2 = "this is a test";
        int size2 = text2.getBytes().length;
        double partCount2 = (size2 / (1 * 1024)) == 0 ? 1 : Math.ceil((size2/ (1 * 1024)));
        double cost2 = partCount2 * 10;
        System.out.println("cost:"+cost2);
    }
}
