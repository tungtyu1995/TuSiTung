package io_text_file.baitap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class CSVReader {
    public static void main(String[] args) {
        try {
            File file = new File("src/io_text_file/baitap/CSVReader.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] data;
            while ((line = bufferedReader.readLine()) != null){
                data = line.split(",");
                System.out.println(data[5]);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}