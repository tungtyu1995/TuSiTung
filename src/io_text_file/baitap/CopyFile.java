package io_text_file.baitap;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("src/io_text_file/baitap/TextFile.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter("src/io_text_file/baitap/textCopy.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line ;
            while ((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(line);
                bufferedWriter.write(System.lineSeparator());
            }

            bufferedReader.close();
            bufferedWriter.close();
            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
