package case_study.libs;

import case_study.models.Employee;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class CabinetDocument {
    static Scanner scanner = new Scanner(System.in);
    private static final String FILE_BATH = "D:\\C0520G1-Tung\\src\\case_study\\data\\Employee.csv";

    public static Stack<Employee> readDocument() {
        String[] arr;
        Stack<Employee> employeeStack = new Stack<>();
        File file = new File(FILE_BATH);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException("File not exists");
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                Employee employee = new Employee(arr[1], Integer.parseInt(arr[2]), arr[3]);
                employeeStack.push(employee);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeStack;
    }
    public  static void searchEmployee(){
        System.out.println("_______Search Employee______");
        int index = -1;
        System.out.print(" Enter the name employee: ");
        String name = scanner.nextLine();
        for (int i = 0; i<readDocument().size();i++){
            if (name.equals(readDocument().get(i).getNameEmployee())){
                index = i;
                break;
            }
        }
        if (index != -1){
            System.out.println(String.format("%20s%20s%30s", "Name employee", "Age Employee", "Address"));
            System.out.println(readDocument().get(index).toString());
        }
        else {
            System.out.println("Wrong name");
        }
    }
}
