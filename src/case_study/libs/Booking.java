package case_study.libs;

import case_study.commons.ReadWriteFile;
import case_study.models.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Booking {
    static Scanner scanner = new Scanner(System.in);
    public static final String FILE_BOOKING = "D:\\C0520G1-Tung\\src\\case_study\\data\\Booking.csv";
    public static final String NEW_LINE_SEPARATOR = "\n";
    public static final String COMMA_DELIMITER = ",";
    static TreeMap<Integer, Customer> customerTreeMap = new TreeMap<>();

    public static void addNewBooking() {

        System.out.println("_____Show all customer_____");
        String string = String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s","", "Name Customer", "Birthday",
                "Gender", "Id Customer", "Phone Number", "Email", "Type Customer", "Address Customer");
        string += System.lineSeparator();

        List<Customer> listTemp = FileCustomerUtils.readCustomer();
        Collections.sort(listTemp, new SortCustomer());
        int index = 1;
        for (Customer customer : listTemp) {
            customerTreeMap.put(index, customer);
            index++;
        }
        Set<Integer> freqKey = customerTreeMap.keySet();
        for (Integer key : freqKey) {
            string += key;
            string += customerTreeMap.get(key).showInforWithIndex();
            string += System.lineSeparator();
        }
        System.out.println(string);

        System.out.println(" Enter index customer: ");
        String indexCustomer = scanner.nextLine();
        System.out.println("1.\tVilla\n" +
                "2.\tHouse\n" +
                "3.\tRoom\n" +
                "Enter your choice : ");
        String inputMenu;
        inputMenu = scanner.nextLine();
        switch (inputMenu) {
            case "1":
                bookingVilla(indexCustomer);
                break;
            case "2":
                bookingHouse(indexCustomer);
                break;
            case "3":
                bookingRoom(indexCustomer);
                break;
            default:
                System.out.println("Wrong Choice");
        }
    }

    //Booking Villa
    public static void bookingVilla(String indexCustomer) {
        int indexTempCustomer = Integer.parseInt(indexCustomer);
        System.out.println("_______Show all villa________");
        TreeMap<Integer, Villa> myVilla = new TreeMap<>();
        List<Services> myServicesVilla = ReadWriteFile.readFile(FileVillaUtils.FILE_VILLA);
        int index = 1;
        for (Services services : myServicesVilla) {
            myVilla.put(index, (Villa) services);
            index++;
        }
        String string = String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s","", "Type Service", "Area Room",
                "Prince Rents", "Maximum Customer", "Type Rents", "Standard Room", "Convenience", "Area Swimming", "Number Floor");
        string += System.lineSeparator();
        Set<Integer> freqKeyVilla = myVilla.keySet();
        for (Integer key : freqKeyVilla) {
            string += key;
            string += myVilla.get(key).showInforWithIndex();
            string += System.lineSeparator();
        }
        System.out.println(string);

        System.out.println("Enter index service villa : ");
        String indexVilla = scanner.nextLine();
        Set<Integer> freqKey = myVilla.keySet();
        for (Integer integer : freqKey) {
            if (Integer.parseInt(indexVilla) == integer) {
                Customer.services = myVilla.get(integer);
            }
        }
        writeBooking(indexTempCustomer);
    }

    //    Booking House
    public static void bookingHouse(String indexCustomer) {
        int indexTempCustomer = Integer.parseInt(indexCustomer);
        System.out.println("_______Show all house________");
        TreeMap<Integer, House> myHouse = new TreeMap<>();
        List<Services> myServicesHouse = ReadWriteFile.readFile(FileHouseUtils.FILE_HOUSE);
        int index = 1;
        for (Services services : myServicesHouse) {
            myHouse.put(index, (House) services);
            index++;
        }
        String string = String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s","", "Type Service", "Area Room",
                "Prince Rents", "Maximum Customer", "Type Rents", "Standard Room", "Convenience", "Number Floor");
        string += System.lineSeparator();
        Set<Integer> freqKeyHouse = myHouse.keySet();
        for (Integer key : freqKeyHouse) {
            string += key;
            string += myHouse.get(key).showInforWithIndex();
            string += System.lineSeparator();
        }
        System.out.println(string);

        System.out.println("Enter index service house : ");
        String indexHouse = scanner.nextLine();
        Set<Integer> freqKey = myHouse.keySet();
        for (Integer integer : freqKey) {
            if (Integer.parseInt(indexHouse) == integer) {
                Customer.services = myHouse.get(integer);
            }
        }
        writeBooking(indexTempCustomer);
    }

//    Booking Room

    public static void bookingRoom(String indexCustomer) {
        int indexTempCustomer = Integer.parseInt(indexCustomer);
        System.out.println("_______Show all room________");
        TreeMap<Integer, Room> myRoom = new TreeMap<>();
        List<Services> myServicesRoom = ReadWriteFile.readFile(FileRoomUtils.FILE_ROOM);
        int index = 1;
        for (Services services : myServicesRoom) {
            myRoom.put(index, (Room) services);
            index++;
        }
        String string = String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s","", "Type Service", "Area Room",
                "Prince Rents", "Maximum Customer", "Type Rents", "FreeService");
        string += System.lineSeparator();
        Set<Integer> freqKeyRoom = myRoom.keySet();
        for (Integer key : freqKeyRoom) {
            string += key;
            string += myRoom.get(key).showInforWithIndex();
            string += System.lineSeparator();
        }
        System.out.println(string);

        System.out.println("Enter index service house : ");
        String indexRoom = scanner.nextLine();
        Set<Integer> freqKey = myRoom.keySet();
        for (Integer integer : freqKey) {
            if (Integer.parseInt(indexRoom) == integer) {
                Customer.services = myRoom.get(integer);
            }
        }
        writeBooking(indexTempCustomer);
    }

    public static void writeBooking(int indexTempCustomer) {
        File file = new File(FILE_BOOKING);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            stringBuilder.append(customerTreeMap.get(indexTempCustomer).getNameCustomer());
            stringBuilder.append(COMMA_DELIMITER);
            stringBuilder.append(customerTreeMap.get(indexTempCustomer).getIdCustomer());
            stringBuilder.append(COMMA_DELIMITER);
            stringBuilder.append(customerTreeMap.get(indexTempCustomer).getDayOfBirth());
            stringBuilder.append(COMMA_DELIMITER);
            stringBuilder.append(customerTreeMap.get(indexTempCustomer).getGender());
            stringBuilder.append(COMMA_DELIMITER);
            stringBuilder.append(customerTreeMap.get(indexTempCustomer).getPhoneNumberCustomer());
            stringBuilder.append(COMMA_DELIMITER);
            stringBuilder.append(customerTreeMap.get(indexTempCustomer).getEmail());
            stringBuilder.append(COMMA_DELIMITER);
            stringBuilder.append(customerTreeMap.get(indexTempCustomer).getTypeOfCustomer());
            stringBuilder.append(COMMA_DELIMITER);
            stringBuilder.append(customerTreeMap.get(indexTempCustomer).getAddressCustomer());
            stringBuilder.append(COMMA_DELIMITER);
            stringBuilder.append(Customer.services.toString());
            stringBuilder.append(NEW_LINE_SEPARATOR);

            bufferedWriter.append(stringBuilder);
            System.out.println("Successfully");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.flush();
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flush/close filewrite !!!");
                e.printStackTrace();
            }
        }
    }
}
