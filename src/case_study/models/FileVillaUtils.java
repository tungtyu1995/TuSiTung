package case_study.models;

import case_study.commons.ReadWriteFile;
import case_study.controllers.CheckValuedate;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileVillaUtils {
    public static final String FILE_VILLA = "D:\\\\C0520G1-Tung\\\\src\\\\case_study\\\\data\\\\Villa.csv";

    public static void addNewServiceVilla(Scanner scanner) {
        System.out.println("_______Add New Service Room______");
        ReadWriteFile.writeFile(scanner, FILE_VILLA);
    }

    public static void showAllVilla() {
        System.out.println("_______Add New Service Villa______");
        String string;
        string = String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s","Type Service", "Area Room",
                "Prince Rents", "Maximum Customer", "Type Rents", "Standard Room", "Convenience","Area Swimming","Number Floor");
        string += System.lineSeparator();
        for (Services villa : ReadWriteFile.readFile(FILE_VILLA)) {
            string += villa.showInfor();
            string += System.lineSeparator();
        }
        System.out.println(string);
    }



//    private static final String FILE_BATH = "D:\\C0520G1-Tung\\src\\case_study\\data\\Villa.csv";
//    private static final String NEW_LINE_SEPARATOR = "\n";
//    private static final String COMMA_DELIMITER = ",";
//    private static final String FILE_HEADER = "Type Service, Area Room, Price Rents, Maximum customer, Type Rents, Standard Room, Convenience,Area Swimming, Type Service";
//    static ArrayList<Villa> listVilla = new ArrayList<>();
//
//    public static void addNewServiceVilla(Scanner scanner) {
//        System.out.println("------------- Add New Service Villa --------------");
//        scanner.nextLine();
//        System.out.print("Enter name service(SVXX-YYYY)(VL) : ");
//        String nameVilla = CheckValuedate.checkNameService();
//        System.out.print("Enter area room : ");
//        double areaRoom = CheckValuedate.checkArea();
//        System.out.print("Enter cost rent : ");
//        double cost = CheckValuedate.checkCost();
//        System.out.print("Enter number customer: ");
//        int numberCustomer = CheckValuedate.maxCustomer();
//        System.out.print("Enter type rent : ");
//        String typeRent = scanner.nextLine();
//        System.out.print("Enter standard room : ");
//        String standardRoom = scanner.nextLine();
//        System.out.print("Enter describe convenience : ");
//        String convenience = scanner.nextLine();
//        System.out.print("Enter area swimming : ");
//        double areaSwimming = CheckValuedate.checkArea();
//        System.out.print("Enter number floor : ");
//        int numberFloor = CheckValuedate.checkFloor();
//
//
//        listVilla.add(new Villa(nameVilla, areaRoom, cost, numberCustomer, typeRent, standardRoom, convenience, areaSwimming, numberFloor));
//        File file = new File(FILE_BATH);
//        FileWriter fileWriter = null;
//        BufferedWriter bufferedWriter = null;
//        try {
//            fileWriter = new FileWriter(file, false);
//            bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.append(FILE_HEADER);
//            bufferedWriter.append(NEW_LINE_SEPARATOR);
//
//            for (Villa villa : listVilla) {
//
//                bufferedWriter.append(villa.getTypeService());
//                bufferedWriter.append(COMMA_DELIMITER);
//                bufferedWriter.append(String.valueOf(villa.getArea()));
//                bufferedWriter.append(COMMA_DELIMITER);
//                bufferedWriter.append(String.valueOf(villa.getPriceRents()));
//                bufferedWriter.append(COMMA_DELIMITER);
//                bufferedWriter.append(String.valueOf(villa.getMaxNumberOfCustomer()));
//                bufferedWriter.append(COMMA_DELIMITER);
//                bufferedWriter.append(villa.getTypeRents());
//                bufferedWriter.append(COMMA_DELIMITER);
//                bufferedWriter.append(villa.getStandardRoom());
//                bufferedWriter.append(COMMA_DELIMITER);
//                bufferedWriter.append(villa.getConvenience());
//                bufferedWriter.append(COMMA_DELIMITER);
//                bufferedWriter.append(String.valueOf(villa.getAreaSwimming()));
//                bufferedWriter.append(COMMA_DELIMITER);
//                bufferedWriter.append(String.valueOf(villa.getNumberFloor()));
//                bufferedWriter.append(NEW_LINE_SEPARATOR);
//            }
//
//            System.out.println("CSV file was created successfully !!!");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                bufferedWriter.flush();
//                bufferedWriter.close();
//                fileWriter.close();
//            } catch (IOException e) {
//                System.out.println("Error while flushing/closing fileWriter !!!");
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void showAllVilla() {
//        File file = new File(FILE_BATH);
//        String[] arrayVilla;
//        String str = "";
//        try {
//            if
//            (!file.exists()) {
//                throw new FileNotFoundException("File not exists");
//            }
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                arrayVilla = line.split(",");
//                str += String.format("%s%20s%20s%20s%20s%20s%20s%20s%20s", arrayVilla[0], arrayVilla[1], arrayVilla[2], arrayVilla[3], arrayVilla[4], arrayVilla[5], arrayVilla[6]
//                        , arrayVilla[7], arrayVilla[8]) + System.lineSeparator();
//            }
//
//            bufferedReader.close();
//            fileReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println(e);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(str);
//    }
}
