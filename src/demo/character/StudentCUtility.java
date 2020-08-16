package demo.character;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentCUtility {
    private static List<StudentC> studentCList = new ArrayList<>();
    private static final String STUDENTC_FILE_PATH = "D:\\C0520G1-Tung\\src\\demo\\character\\StudentC.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "Id, Name, Address, Age";

    private static File file = new File(STUDENTC_FILE_PATH);

    public static List<StudentC> readStudentCFile() {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String id;
            String name;
            String address;
            int age;
            StudentC studentC;
            String[] studentCStringArray;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                studentCStringArray = line.split(",");
                if ("Id".compareTo(studentCStringArray[0]) == 0) {
                    continue;
                }
                id = studentCStringArray[0];
                name = studentCStringArray[1];
                address = studentCStringArray[2];
                age = Integer.parseInt(studentCStringArray[3]);
                studentC = new StudentC(id, name, address, age);
                studentCList.add(studentC);
            }
            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readStudentCFile();
    }

    public static void writeStudentCFile(List<StudentC> studentCList) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);

            if (!studentCList.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(FILE_HEADER);
                stringBuilder.append(NEW_LINE_SEPARATOR);

                for (StudentC studentC : studentCList) {
                    stringBuilder.append(studentC.getId());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(studentC.getName());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(studentC.getAddress());
                    stringBuilder.append(COMMA_DELIMITER);
                    stringBuilder.append(studentC.getAge());
                    stringBuilder.append(NEW_LINE_SEPARATOR);
                }
                bufferedWriter.append(stringBuilder);
            } else {
                System.out.println("The list is empty. Please add new student...");
            }
            bufferedWriter.flush();
            fileWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
