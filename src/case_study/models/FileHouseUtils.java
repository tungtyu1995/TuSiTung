package case_study.models;

import case_study.controllers.CheckValuedate;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHouseUtils {
    private static final String FILE_BATH = "D:\\C0520G1-Tung\\src\\case_study\\data\\House.csv";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String COMMA_DELIMITER = ",";
    private static final String FILE_HEADER = "Type Service, Area Room, Price Rents, Maximum customer, Type Rents, Standard Room, Convenience, Type Service";
    static ArrayList<House> listHouse = new ArrayList<>();


    public static void addNewServiceHouse(Scanner scanner) {
        System.out.println("------------- Add New Service House --------------");
        scanner.nextLine();
        System.out.print("Enter name service(SVXX-YYYY)(HO) : ");
        String nameHouse = CheckValuedate.checkNameService();
        System.out.print("Enter area type service : ");
        double areaRoom = CheckValuedate.checkArea();
        System.out.print("Enter cost rent : ");
        double cost = CheckValuedate.checkCost();
        System.out.print("Enter number customer: ");
        int numberCustomer = CheckValuedate.maxCustomer();
        System.out.print("Enter type rent : ");
        String typeRent = scanner.nextLine();
        System.out.print("Enter standard room : ");
        String standardRoom = scanner.nextLine();
        System.out.print("Enter describe convenience : ");
        String convenience = scanner.nextLine();
        System.out.print("Enter number floor : ");
        int numberFloor = CheckValuedate.checkFloor();


        listHouse.add(new House(nameHouse, areaRoom, cost, numberCustomer, typeRent, standardRoom, convenience, numberFloor));
        File file = new File(FILE_BATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(FILE_HEADER);
            bufferedWriter.append(NEW_LINE_SEPARATOR);

            for (House house : listHouse) {

                bufferedWriter.append(house.getTypeService());
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(String.valueOf(house.getArea()));
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(String.valueOf(house.getPriceRents()));
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(String.valueOf(house.getMaxNumberOfCustomer()));
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(house.getTypeRents());
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(house.getStandardRoom());
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(house.getConvenience());
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(String.valueOf(house.getNumberFloor()));
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

    public static void showAllHouse() {
        File file = new File(FILE_BATH);
        String[] arrayHouse;
        String str = "";
        try {
            if
            (!file.exists()) {
                throw new FileNotFoundException("File not exists");
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            String line;
            while ((line = bufferedReader.readLine()) != null) {
                arrayHouse = line.split(",");
                str += String.format("%s%20s%20s%20s%20s%20s%20s%20s", arrayHouse[0], arrayHouse[1], arrayHouse[2], arrayHouse[3], arrayHouse[4], arrayHouse[5], arrayHouse[6]
                        , arrayHouse[7]) + System.lineSeparator();
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
