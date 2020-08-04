package case_study.libs;

import case_study.models.Customer;
import case_study.models.FileCustomerUtils;
import case_study.models.FileRoomUtils;
import case_study.models.SortCustomer;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Booking {
    static Scanner scanner = new Scanner(System.in);
    public static final String FILE_BOOKING = "D:\\C0520G1-Tung\\src\\case_study\\data\\Booking.csv";
    public static final String NEW_LINE_SEPARATOR = "\n";
    public static final String COMMA_DELIMITER = ",";

    public static void addNewBooking(){

        TreeMap<Integer, Customer> customerTreeMap = new TreeMap<>();
        System.out.println("_____Show all customer_____");
        String string = String.format("%-20s%-20s%-20s-%20s-%20s-%20s-%20s-%20s", "Name Customer", "Birthday",
                "Gender", "Id Customer", "Phone Number", "Email", "Type Customer", "Address Customer");
        string +=System.lineSeparator();
        List<Customer> listTemp = FileCustomerUtils.readCustomer();
        Collections.sort(listTemp, new SortCustomer());
        int index = 1;
        for (Customer customer : listTemp){
            customerTreeMap.put(index, customer);
            index++;
        }


    }
}
