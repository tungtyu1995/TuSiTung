package demo.io_byte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private List<Student> studentList;

    public StudentManager() {
        studentList = new ArrayList<>();
    }

    public StudentManager(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addNewStudent() {
        Scanner scanner = new Scanner(System.in);
        String id;
        String name;
        String address;
        int age;
        Student newStudent;

        System.out.print("Input Id: ");
        id = scanner.nextLine();

        System.out.println("Input Name:");
        name = scanner.nextLine();

        System.out.println("Input Address: ");
        address = scanner.nextLine();

        System.out.println("Input age: ");
        age = Integer.parseInt(scanner.nextLine());

        newStudent = new Student(id, name, address, age);
        this.studentList.add(newStudent);
        System.out.println("New student name " + name + "has been added.");

    }

    public void displayStudentList() {
        System.out.println("__________Student List _________");
        int i = 1;
        for (Student student : this.getStudentList()) {
            System.out.println(i + ". " + student.toString());
            i++;
        }
    }

    public void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Student Id: ");
        String id = scanner.nextLine();
        boolean checkFound = false;
        Student foundStudent = null;
        for (Student student : this.getStudentList()) {
            if (id.compareTo(student.getId()) == 0) {
                checkFound = true;
                foundStudent = student;
                System.out.println("Student found: ");
                System.out.println(foundStudent.toString());
                break;
            }
        }
        if (checkFound) {
            System.out.println("Delete student name " + foundStudent.getName() + "1.Yes / 2.No");
            int option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                this.getStudentList().remove(foundStudent);
                System.out.println("Student name " + foundStudent.getName() + " delete");
            } else {
                System.out.println("No student deleter ");
            }
        } else {
            System.out.println("Student id" + id + " not found in the list");
        }
    }

    public void editStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Student Id: ");
        String id = scanner.nextLine();
        boolean checkEdit = false;
        for (Student student : this.getStudentList()) {
            if (id.compareTo(student.getId()) == 0) {
                System.out.println(student);
                System.out.print("Input Id: ");
                student.setId(scanner.nextLine());
                System.out.println("Input Name:");
                student.setName(scanner.nextLine());
                System.out.println("Input Address: ");
                student.setName(scanner.nextLine());
                System.out.println("Input age: ");
                student.setAge(Integer.parseInt(scanner.nextLine()));
                checkEdit = true;
                break;
            }
        }if (!checkEdit){
            System.out.println("Student id" + id + " not found in the list");
        }
    }
    public void searchStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Name student: ");
        String nameSearch = scanner.nextLine();
        boolean checkSearch = false;
        for (Student student:this.getStudentList()){
            if (nameSearch.equals(student.getName())){
                System.out.println(student);
                checkSearch = true;
                break;
            }
        }if (!checkSearch){
            System.out.println("Student name" + nameSearch + " not found in the list");
        }
    }
}
