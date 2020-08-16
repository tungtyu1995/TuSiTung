package io_binaryfile_serialization.thuchanh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManage {
    public static final String FILE_PATH = "src/io_binaryfile_serialization/thuchanh/test.txt";

    public static void writeFile()  {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(FILE_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Student student1 = new Student("Toan", 25);
        Student student2 = new Student("Dat09", 29);
        Student student3 = new Student("Hai", 20);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        try {
            objectOutputStream.writeObject(studentList);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public static void readFile(){
    FileInputStream fis = null;
    try {
        fis =  new FileInputStream(FILE_PATH);
        ObjectInputStream objectInputStream =null;
        try {
            objectInputStream = new ObjectInputStream(fis);
            List<Student> studentList = (List<Student>) objectInputStream.readObject();
            for (Student student : studentList) {
                System.out.println(student.getName() + " " + student.getAge() + " " + Student.sex);
            }
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}
    public static void main(String[] args) throws IOException {
        writeFile();
        readFile();
    }
}
