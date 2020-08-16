package demo.io_byte;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentUtility {
    private static List<Student>studentList = new ArrayList<>();
    private static final String STUDEN_FILE_PATH = "D:\\C0520G1-Tung\\src\\demo\\io_byte\\Student.txt";
    static File file = new File(STUDEN_FILE_PATH);

    public static List<Student> readStudentFile(){
        studentList.clear();

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Student student;

            while ((student = (Student) objectInputStream.readObject()) != null) {
                studentList.add(student);
            }
            fileInputStream.close();
            objectInputStream.close();
        }catch (EOFException e){
//            System.out.println("");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return studentList;
    }
    public static void writeStudentFile(List<Student> studentList){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (Student student: studentList){
                objectOutputStream.writeObject(student);
            }
            objectOutputStream.flush();
            fileOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
