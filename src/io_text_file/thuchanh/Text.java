package io_text_file.thuchanh;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Text {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\C0520G1-Tung\\TextFile.txt");
        file.createNewFile();
        FileWriter f = new FileWriter(file,false);
        f.append("dfgdfgdfgdfgdfgd");
//        xuong dong
        f.append(System.lineSeparator());
//
        f.append("123456");
        f.close();

    }
}
