package com.springboot.system.Library.testare;

import java.io.FileWriter;

public class WriteCSV {
    public static void main(String[] args){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Name").append(", ").append("LastName").append("\n");
        stringBuilder.append("Andrei").append(", ").append("Diaconu");

        try(FileWriter writer = new FileWriter("src\\main\\resources\\static\\hello.csv")) {
            writer.write(stringBuilder.toString());
            System.out.println("File created");
        }catch (Exception e){
            System.out.println("Something went wrong " + e);
        }

    }
}
