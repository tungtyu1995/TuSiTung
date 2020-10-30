package case_study_furama.models;

import case_study_furama.controllers.CheckValueDateCustomer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileCustomerUtils {
    private static final String FILE_BATH = "D:\\C0520G1-Tung\\src\\case_study\\data\\Customer.csv";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String COMMA_DELIMITER = ",";

    static Scanner scanner = new Scanner(System.in);


    public static void addNewCustomer() {
        List<Customer> listCustomers = new ArrayList<>();
//        System.out.print("Enter name customer : ");
        String nameCustomer = CheckValueDateCustomer.checkNameCustomer();
//        System.out.print("Enter birthday customer : ");
        String birthdayCustomer = CheckValueDateCustomer.checkDayOfBirthCustomer();
//        System.out.print("Enter gender customer : ");
        String genderCustomer = CheckValueDateCustomer.checkGender();
//        System.out.print("Enter id customer : ");
        String idCustomer = CheckValueDateCustomer.checkIdCustomer();
        System.out.print("Enter phone number customer : ");
        String phoneCustomer = scanner.nextLine();
//        System.out.print("Enter email customer : ");
        String emailCustomer = CheckValueDateCustomer.checkEmailCustomer();
        System.out.print("Enter type customer (Diamond,Gold,Sliver) :");
        String typeCustomer = scanner.nextLine();
        System.out.print("Enter address customer :");
        String addressCustomer = scanner.nextLine();

        listCustomers.add(new Customer(nameCustomer, birthdayCustomer, genderCustomer, idCustomer, phoneCustomer, emailCustomer, typeCustomer, addressCustomer));

        File file = new File(FILE_BATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer : listCustomers) {
                stringBuilder.append(customer.getNameCustomer());
                stringBuilder.append(COMMA_DELIMITER);
                stringBuilder.append(customer.getDayOfBirth());
                stringBuilder.append(COMMA_DELIMITER);
                stringBuilder.append(customer.getGender());
                stringBuilder.append(COMMA_DELIMITER);
                stringBuilder.append((customer.getIdCustomer()));
                stringBuilder.append(COMMA_DELIMITER);
                stringBuilder.append((customer.getIdCustomer()));
                stringBuilder.append(COMMA_DELIMITER);
                stringBuilder.append(customer.getEmail());
                stringBuilder.append(COMMA_DELIMITER);
                stringBuilder.append(customer.getTypeOfCustomer());
                stringBuilder.append(COMMA_DELIMITER);
                stringBuilder.append(customer.getAddressCustomer());
                stringBuilder.append(NEW_LINE_SEPARATOR);
            }
            bufferedWriter.append(stringBuilder);
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

    public static List<Customer> readCustomer() {
        List<Customer> listCustomers = new ArrayList<>();
        File file = new File(FILE_BATH);
        String[] arr;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                Customer customer = new Customer(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
                listCustomers.add(customer);
            }
            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listCustomers;
    }

    public static void showInformationCustomers() {
        System.out.println("_________Show all customer__________");
        String string = String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", "Name Customer", "Birthday",
                "Gender", "Id Customer", "Phone Number", "Email", "Type Customer", "Address Customer");
        string += System.lineSeparator();
        List<Customer> listTemp = readCustomer();
        Collections.sort(listTemp, new SortCustomer());
        for (Customer customer : listTemp) {
            string += customer.showInfor();
            string += System.lineSeparator();
        }
        System.out.println(string);
    }
}
