package demo.character;

import demo.io_byte.Student;

import java.util.*;

public class StudentCManager {
    private List<StudentC> studentCList;

    public StudentCManager() {
        studentCList = new ArrayList<>();
    }

    public StudentCManager(List<StudentC> studentCList) {
        this.studentCList = studentCList;
    }

    public List<StudentC> getStudentCList() {
        return studentCList;
    }

    public void setStudentCList(List<StudentC> studentCList) {
        this.studentCList = studentCList;
    }

    public void addNewStudent() {
        Scanner scanner = new Scanner(System.in);
        String id;
        String name;
        String address;
        int age;
        StudentC newStudentC;

        System.out.print("Input Id: ");
        id = scanner.nextLine();

        System.out.println("Input Name:");
        name = scanner.nextLine();

        System.out.println("Input Address: ");
        address = scanner.nextLine();

        System.out.println("Input age: ");
        age = Integer.parseInt(scanner.nextLine());

        newStudentC = new StudentC(id, name, address, age);
        this.studentCList.add(newStudentC);
        System.out.println("New student name " + name + "has been added.");

    }

    public void displayStudentList() {
        Collections.sort(this.getStudentCList(),new SortingById());
        Iterator<StudentC> iterator = this.getStudentCList().iterator();
        int i = 1;
        while (iterator.hasNext()){
            System.out.println(i+". " +iterator.next().toString());
            i++;
        }

    }

    public void deleteStudentC() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Student Id: ");
        String id = scanner.nextLine();
        boolean checkFound = false;
        StudentC foundStudentC = null;
        for (StudentC studentC : this.getStudentCList()) {
            if (id.compareTo(studentC.getId()) == 0) {
                checkFound = true;
                foundStudentC = studentC;
                System.out.println("Student found: ");
                System.out.println(foundStudentC.toString());
                break;
            }
        }
        if (checkFound) {
            System.out.println("Delete student name " + foundStudentC.getName() + "1.Yes / 2.No");
            int option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                this.getStudentCList().remove(foundStudentC);
                System.out.println("Student name " + foundStudentC.getName() + " delete");
            } else {
                System.out.println("No student deleter ");
            }
        } else {
            System.out.println("Student id" + id + " not found in the list");
        }
    }

    public void editStudentC() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Student Id: ");
        String id = scanner.nextLine();
        boolean checkEdit = false;
        for (StudentC studentC : this.getStudentCList()) {
            if (id.compareTo(studentC.getId()) == 0) {
                System.out.println(studentC);
                System.out.print("Input Id: ");
                studentC.setId(scanner.nextLine());
                System.out.println("Input Name:");
                studentC.setName(scanner.nextLine());
                System.out.println("Input Address: ");
                studentC.setName(scanner.nextLine());
                System.out.println("Input age: ");
                studentC.setAge(Integer.parseInt(scanner.nextLine()));
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
        for (StudentC studentC:this.getStudentCList()){
            if (nameSearch.equals(studentC.getName())){
                System.out.println(studentC);
                checkSearch = true;
                break;
            }
        }if (!checkSearch){
            System.out.println("Student name" + nameSearch + " not found in the list");
        }
    }
}
