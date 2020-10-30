package io_text_file.thuchanh;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Text {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("src/io_text_file/thuchanh/Book\\tung.txt");
            file.createNewFile();
                    } catch (IOException e) {
            System.out.println("chua co file");
        }
    }
}