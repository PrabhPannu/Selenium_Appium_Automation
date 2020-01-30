package com.web;

import com.opencsv.CSVWriter;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WriteCSV {

    public static List<String[]> data = new ArrayList<String[]>();
    public static int count=1;
    public static int  num = 125;
    public static  String CSV_FILE_PATH = "./";

    @Test
    public  void createDataFile(){
        fileName("CSVDataFile");
        data.add(new String[] { "Item","Card", "Name", "LName", "Code" });
        createSingleRecord("John","Matheson");
        createSingleRecord("Steve","Fleming");
    }

    public static void fileName(String fileName){
        CSV_FILE_PATH=CSV_FILE_PATH+fileName+".csv";
    }

    public static void createSingleRecord(String Name,String LName){
        Random random = new Random();
        long n =  random.nextLong() % (9999999999L - 1000000000L) + 9999999999L;
        data.add(new String[] { count+"" ,n+"",Name ,LName, num+""});
        count =  count+1;
        num = num+1;
        // first create file object for file placed at location
        // specified by filepath
        File file = new File(CSV_FILE_PATH);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);
            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);
            // create a List which contains String array
            writer.writeAll(data);
            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
