package bai_thi_lai;

import demo.character1.WorkerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookUtility {
    private static List<PhoneBook> phoneBookList = new ArrayList<>();
    private static final String FILE_PATH = "D:\\C0520G1-Tung\\src\\bai_thi_lai\\Phonebook.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "Worker_Id,Name,Age,Salary";

    //Create a file
    private static File phoneBookCsvFile = new File(FILE_PATH);

    //Read the csv File
    public static List<PhoneBook> readPhoneBook() {
        try {
            //Clear the list before adding new workers
            phoneBookList.clear();

            //Create a stream and link to source
            FileReader fileReader = new FileReader(phoneBookCsvFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //Read the stream of character
            String soDienThoai;
            String nhomCuaDanhBa;
            String hoTen;
            String gioiTinh;
            String diaChi;
            String ngaySinh;
            String email;
            PhoneBook outputPhoneBook;
            String[] phoneBookStringArray;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                phoneBookStringArray = line.split(",");
                if ("Worker_Id".compareTo(phoneBookStringArray[0]) == 0) {
                    continue;
                }
                soDienThoai = phoneBookStringArray[0];
                nhomCuaDanhBa = phoneBookStringArray[1];
                hoTen = phoneBookStringArray[2];
                gioiTinh = phoneBookStringArray[3];
                diaChi = phoneBookStringArray[4];
                ngaySinh = phoneBookStringArray[5];
                email = phoneBookStringArray[6];

                outputPhoneBook = new PhoneBook(soDienThoai,nhomCuaDanhBa,hoTen,gioiTinh,diaChi,ngaySinh,email);

                //Add new worker into the list
                phoneBookList.add(outputPhoneBook);
            }

            //Close the stream (out_of_the_loop)
            fileReader.close();
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println(e);
        }
        return phoneBookList;
    }

    //Write the worker file
    public static void writeWorkerFile(List<PhoneBook> phoneBookList) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {

            //Create a stream and link to source
            fileWriter = new FileWriter(phoneBookCsvFile.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);

            //Write the file
            if (!phoneBookList.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(FILE_HEADER);
                stringBuilder.append(NEW_LINE_SEPARATOR);

                for (PhoneBook phoneBook : phoneBookList) {
                    stringBuilder.append(phoneBook.getSoDienThoai());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(phoneBook.getNhomCuaDanhBa());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(phoneBook.getHoTen());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(phoneBook.getGioiTinh());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(phoneBook.getDiaChi());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(phoneBook.getNgaySinh());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(phoneBook.getEmail());
                    stringBuilder.append(NEW_LINE_SEPARATOR);
                }

                bufferedWriter.append(stringBuilder);

            } else {
                System.out.println("The list is empty. Please add new worker...");
            }

            //Close the stream
            bufferedWriter.flush();
            fileWriter.flush();
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
