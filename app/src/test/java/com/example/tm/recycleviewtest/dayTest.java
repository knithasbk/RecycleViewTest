package com.example.tm.recycleviewtest;

import org.junit.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.lang.System.currentTimeMillis;

/**
 * Created by TM on 19/10/2016.
 */

public class dayTest {


    @Test
    public void TestDay() {

        SimpleDateFormat sdfOfMonth = new SimpleDateFormat("dd MMMM");
        SimpleDateFormat sdfOfWeek = new SimpleDateFormat("EEEEEE");
        Calendar c = Calendar.getInstance();
        String formatedDay = sdfOfMonth.format(c.getTime());
        c.add(Calendar.DATE,1);
        String formatedNextDay = sdfOfMonth.format(c.getTime());


        //    System.out.print(String.valueOf(currentDay));
        System.out.println(formatedDay);
        System.out.println(formatedNextDay);

    }
}
