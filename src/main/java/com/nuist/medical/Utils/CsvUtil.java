package com.nuist.medical.Utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CsvUtil {

    public static boolean CsvHasEmptyCell(File file){
        boolean flag = false;
        CSVReader csvReader =null;
        try {
           csvReader=new CSVReader(new FileReader(file));

            String[] line;
            while ((line = csvReader.readNext()) != null) {
                for (String s : line) {
                    if(s==""){
                        flag=true;
                    }
                }
            }
            csvReader.close();
        }
        catch (CsvException|IOException e){
            e.printStackTrace();
        }
        return flag;
    }


}
