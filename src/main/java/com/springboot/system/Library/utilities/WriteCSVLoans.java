package com.springboot.system.Library.utilities;

import com.springboot.system.Library.entities.Loans;

import java.io.FileWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WriteCSVLoans {

    private WriteCSVLoans(List<Loans> loans){
        writeCSV(loans);
    }

    public static WriteCSVLoans getInstance(List<Loans> loans){
        return new WriteCSVLoans(loans);
    }

    private static void writeCSV(List<Loans> loans){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("id").append(",")
                .append("expectation date").append(",")
                .append("return date").append(",").append("start date")
                .append("\n");

        for(var loan : loans){
            stringBuilder.append(loan.getId()).append(", ")
                    .append(loan.getExpectationDate()).append(", ")
                    .append(loan.getReturnDate()).append(", ")
                    .append(loan.getStartDate()).append("\n");
        }

        var timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        try(FileWriter writer = new FileWriter("src\\main\\resources\\static\\loans_"+timestamp+".csv")) {
            writer.write(stringBuilder.toString());
            System.out.println("File created");
        }catch (Exception e){
            System.out.println("Something went wrong " + e);
        }

    }
}
