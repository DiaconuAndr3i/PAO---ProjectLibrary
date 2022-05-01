package com.springboot.system.Library.testare;

import com.springboot.system.Library.entities.Loans;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class newMain {
    public static void main(String[] args) throws ParseException {
        /*String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        var obj = new Loans(date1, date1, date1);
        System.out.println(obj);*/
        System.out.println(new Timestamp(System.currentTimeMillis()));
    }
}
