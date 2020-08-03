package case_study.models;

import case_study.controllers.CheckValuedate;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRoomUtils {
    private static final String FILE_BATH = "D:\\C0520G1-Tung\\src\\case_study\\data\\Room.csv";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String COMMA_DELIMITER = ",";
    private static final String FILE_HEADER = "Type Service, Area Room, Price Rents, Maximum customer, Type Rents, Standard Room, Convenience, Type Service";
    static ArrayList<Room> listRoom = new ArrayList<>();

    public static void addNewServiceRoom(Scanner scanner) {
        System.out.println("------------- Add New Service Room --------------");
        scanner.nextLine();
        System.out.print("Enter name service(SVXX-YYYY)(RO) : ");
        String nameRoom = CheckValuedate.checkNameService();
        System.out.print("Enter area type service : ");
        double areRoom = CheckValuedate.checkArea();
        System.out.print("Enter cost rent : ");
        double cost = CheckValuedate.checkCost();
        System.out.print("Enter number customer: ");
        int numberCustomer = CheckValuedate.maxCustomer();
        System.out.print("Enter type rent : ");
        String typeRent = scanner.nextLine();
        System.out.print("Enter free enclosed service : ");
        String freeService = scanner.nextLine();

        listRoom.add(new Room(nameRoom, areRoom, cost, numberCustomer, typeRent, freeService));
        File file = new File(FILE_BATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(FILE_HEADER);
            bufferedWriter.append(NEW_LINE_SEPARATOR);

            for (Room room : listRoom) {

                bufferedWriter.append(room.getTypeService());
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(String.valueOf(room.getArea()));
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(String.valueOf(room.getPriceRents()));
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(String.valueOf(room.getMaxNumberOfCustomer()));
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(room.getTypeRents());
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(String.valueOf(room.getFreeService()));
                bufferedWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.flush();
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    public static void showAllRoom() {
        File fileRoom = new File(FILE_BATH);
        String[] arrayRoom;
        String str = "";
        try {
            if
            (!fileRoom.exists()) {
                throw new FileNotFoundException("File not exists");
            }
            FileReader fileReader = new FileReader(fileRoom);
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            String line;
            while ((line = bufferedReader.readLine()) != null) {
                arrayRoom = line.split(",");
                str += String.format("%s%20s%20s%20s%20s%20s", arrayRoom[0], arrayRoom[1], arrayRoom[2], arrayRoom[3], arrayRoom[4], arrayRoom[5]) + System.lineSeparator();
            }

            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }
}
