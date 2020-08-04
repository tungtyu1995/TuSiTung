package case_study.commons;

import case_study.controllers.CheckValuedate;
import case_study.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadWriteFile {
    private static final String NEW_LINE_SEPARATOT = "\n";
    private static final String COMMA_DELIMITER = ",";

    public static void writeFile(Scanner scanner, String FILE_BATH) {
        ArrayList<Room> roomArrayList = new ArrayList<>();
        ArrayList<Villa> villaArrayList = new ArrayList<>();
        ArrayList<House> houseArrayList = new ArrayList<>();
        File file = new File(FILE_BATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        System.out.println("Enter name service(SVXX_YYYY): ");
        String nameService = scanner.nextLine();
        CheckValuedate.checkNameService(nameService);
        System.out.println("Enter area room: ");
        double areaRoom = CheckValuedate.checkArea();
        System.out.println("Enter cost rent: ");
        double cost = CheckValuedate.checkCost();
        System.out.println("Enter number customer:  ");
        int numberCustomer = CheckValuedate.maxCustomer();
        System.out.println("Enter type rent: (hours, day, month) ");
        String typeRent = scanner.nextLine();
//        Room
        if (FILE_BATH.equals(FileRoomUtils.FILE_ROOM)) {
            System.out.println("Free Service");
            String freeService = scanner.nextLine();
            roomArrayList.add(new Room(nameService, areaRoom, cost, numberCustomer, typeRent, freeService));
//        House
        } else if (FILE_BATH.equals(FileHouseUtils.FILE_HOUSE)) {
            System.out.println("Enter standard room: ");
            String standardRoom = scanner.nextLine();
            System.out.println("Enter describe convenience: ");
            String convenience = scanner.nextLine();
            System.out.println("Enter number floor: ");
            int numberFloor = CheckValuedate.checkFloor();
            houseArrayList.add(new House(nameService, areaRoom, cost, numberCustomer, typeRent, standardRoom, convenience, numberFloor));
        }
//        Villa
        else if (FILE_BATH.equals(FileVillaUtils.FILE_VILLA)) {
            System.out.println("Enter describe convenience: ");
            String convenience = scanner.nextLine();
            System.out.println("Enter standard room: ");
            String standardRoom = scanner.nextLine();
            System.out.println("Enter area swimming: ");
            System.out.println("Enter number floor: ");
            int numberFloor = CheckValuedate.checkFloor();
            double areaSwimming = CheckValuedate.checkArea();
            villaArrayList.add(new Villa(nameService, areaRoom, cost, numberCustomer, typeRent,
                    standardRoom, convenience, areaSwimming, numberFloor));
        }
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = new StringBuilder();
            if (FILE_BATH.equals(FileRoomUtils.FILE_ROOM)) {
                for (Room room : roomArrayList) {
                    serviceGeneral(stringBuilder, room.getArea(), room.getPriceRents(), room.getMaxNumberOfCustomer(),
                            room.getTypeRents(), room.getTypeService());
                    stringBuilder.append(NEW_LINE_SEPARATOT);
                }
            } else if (FILE_BATH.equals(FileHouseUtils.FILE_HOUSE)) {
                for (House house : houseArrayList) {
                    serviceGeneral(stringBuilder, house.getArea(), house.getPriceRents(), house.getMaxNumberOfCustomer(),
                            house.getTypeRents(), house.getTypeService());
                    stringBuilder.append(house.getStandardRoom());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(house.getConvenience());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(house.getNumberFloor());
                    stringBuilder.append(NEW_LINE_SEPARATOT);
                }
            } else if (FILE_BATH.equals(FileVillaUtils.FILE_VILLA)) {
                for (Villa villa : villaArrayList) {
                    serviceGeneral(stringBuilder, villa.getArea(), villa.getPriceRents(),
                            villa.getMaxNumberOfCustomer(), villa.getTypeRents(), villa.getTypeService());
                    stringBuilder.append(villa.getStandardRoom());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(villa.getConvenience());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(villa.getAreaSwimming());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(villa.getNumberFloor());
                    stringBuilder.append(NEW_LINE_SEPARATOT);
                }
            }
            bufferedWriter.append(stringBuilder);
            System.out.println(" Successfully!!! ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void serviceGeneral(StringBuilder stringBuilder, double area, double princeRents,
                                       int maxNumberOfCustomer, String typeRents, String typeService) {
        stringBuilder.append(typeService);
        stringBuilder.append(COMMA_DELIMITER);
        stringBuilder.append(area);
        stringBuilder.append(COMMA_DELIMITER);
        stringBuilder.append(princeRents);
        stringBuilder.append(COMMA_DELIMITER);
        stringBuilder.append(maxNumberOfCustomer);
        stringBuilder.append(COMMA_DELIMITER);
        stringBuilder.append(typeRents);
        stringBuilder.append(COMMA_DELIMITER);
    }

    public static List<Services> readFile(String FILE_BATH) {
        List<Services> list =new ArrayList<>();

        File file = new File(FILE_BATH);
        String[] arr;

        try {
            if (!file.exists()) {
                throw new FileNotFoundException("File not exists");
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            if (FILE_BATH.equals(FileRoomUtils.FILE_ROOM)) {
                while ((line = bufferedReader.readLine()) != null) {
                    arr = line.split(",");
                    Room room = new Room(arr[0], Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Integer.parseInt(arr[3]), arr[4], arr[5]);
                    list.add(room);
                }

            } else if (FILE_BATH.equals(FileHouseUtils.FILE_HOUSE)) {
                while ((line = bufferedReader.readLine()) != null) {
                    arr = line.split(",");
                    House house = new House(arr[0], Double.parseDouble(arr[1]), Double.parseDouble(arr[2]),
                            Integer.parseInt(arr[3]), arr[4], arr[5], arr[6], Integer.parseInt(arr[7]));
                    list.add(house);
                }

            } else if (FILE_BATH.equals(FileVillaUtils.FILE_VILLA)) {
                while ((line = bufferedReader.readLine()) != null) {
                    arr = line.split(",");
                    Villa villa = new Villa(arr[0], Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Integer.parseInt(arr[3]),
                            arr[4], arr[5], arr[6], Double.parseDouble(arr[7]), Integer.parseInt(arr[8]));
                    list.add(villa);
                }

            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


}
