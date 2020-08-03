package case_study.models;

import case_study.controllers.CheckValueDateCustomer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileCustomerUtils {
    private static final String FILE_BATH = "D:\\C0520G1-Tung\\src\\case_study\\data\\Customer.csv";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String COMMA_DELIMITER = ",";

    static Scanner scanner = new Scanner(System.in);
    static List<Customer> listCustomers = new ArrayList<>();

    public static void addNewCustomer() {
        System.out.print("Enter name customer : ");
        String nameCustomer = CheckValueDateCustomer.checkNameCustomer();
        System.out.print("Enter birthday customer : ");
        String birthdayCustomer = CheckValueDateCustomer.checkDayOfBirthCustomer();
        System.out.print("Enter gender customer : ");
        String genderCustomer = CheckValueDateCustomer.checkGender();
        System.out.print("Enter id customer : ");
        int idCustomer = CheckValueDateCustomer.checkIdCustomer();
        System.out.print("Enter phone number customer : ");
        int phoneCustomer = scanner.nextInt();
        System.out.print("Enter email customer : ");
        String emailCustomer = CheckValueDateCustomer.checkEmailCustomer();
        scanner.nextLine();
        System.out.print("Enter type customer (Diamond,Gold,Sliver) :");
        String typeCustomer = scanner.nextLine();
        System.out.print("Enter address customer :");
        String addressCustomer = scanner.nextLine();

        listCustomers.add(new Customer(nameCustomer, birthdayCustomer, genderCustomer, idCustomer, phoneCustomer, emailCustomer, typeCustomer, addressCustomer));

        File file = new File(FILE_BATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer : listCustomers) {
                bufferedWriter.append(customer.getNameCustomer());
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(customer.getDayOfBirth());
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(customer.getGender());
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(String.valueOf(customer.getIdCustomer()));
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(String.valueOf(customer.getIdCustomer()));
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(customer.getEmail());
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(customer.getTypeOfCustomer());
                bufferedWriter.append(COMMA_DELIMITER);
                bufferedWriter.append(customer.getAddressCustomer());
                bufferedWriter.append(NEW_LINE_SEPARATOR);

                System.out.println("CSV file was created successfully !!!");

            }

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

    public static void showInformationCustomers() {
        File file = new File(FILE_BATH);
        String[] arr;
        String str = null;
        try {
            if (!file.exists()) {
                throw new FileNotFoundException("File not exist");
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                str += String.format("%s%20s%20s%20s%20s%20s%20s%20s", arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }
}
