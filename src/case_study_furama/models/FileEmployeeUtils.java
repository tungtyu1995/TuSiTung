package case_study_furama.models;

import java.io.*;
import java.util.Set;
import java.util.TreeMap;


public class FileEmployeeUtils {
    private static final String FILE_BATH = "D:\\C0520G1-Tung\\src\\case_study\\data\\Employee.csv";

    public static TreeMap<Integer, Employee> readEmployee() {
        TreeMap<Integer, Employee> map = new TreeMap<>();
        String[] strings;
        File file = new File(FILE_BATH);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException("File not exists");
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                strings = string.split(",");
                Employee employee = new Employee(strings[1], Integer.parseInt(strings[2]), strings[3]);
                map.put(Integer.parseInt(strings[0]), employee);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void showInformationEmployee() {
        System.out.println("_________show Information Employee__________");

        String string = String.format("%-20s%-20s%-20s%-20s", "Id Employee", "Name employee", "Age Employee", "Address");
        string += System.lineSeparator();
        TreeMap<Integer, Employee> treeMap = readEmployee();
        Set<Integer> set = treeMap.keySet();
        for (Integer integer : set) {
            string += (integer);
            string += (treeMap.get(integer).toString());
            string += (System.lineSeparator());
        }
        System.out.println(string);
    }
}
