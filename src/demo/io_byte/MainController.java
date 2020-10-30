package demo.io_byte;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        StudentManager studentManager = new StudentManager();
        studentManager.setStudentList(StudentUtility.readStudentFile());
        System.out.println("____MENU____");
        System.out.println("1.Add new student");
        System.out.println("2.Display student list");
        System.out.println("3.Delete a student");
        System.out.println("4.edit a student");
        System.out.println("5.search a student");
        System.out.println("6.Exit");
        System.out.println("_________________");
        Scanner scanner = new Scanner(System.in);
        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1:
                studentManager.addNewStudent();
                StudentUtility.writeStudentFile(studentManager.getStudentList());
                showMainMenu();
                break;
            case 2:
                studentManager.displayStudentList();
                showMainMenu();
                break;
            case 3:
                studentManager.deleteStudent();
                StudentUtility.writeStudentFile(studentManager.getStudentList());
                showMainMenu();
                break;
            case 4:
                studentManager.editStudent();
                StudentUtility.writeStudentFile(studentManager.getStudentList());
                showMainMenu();
                break;
            case 5:
                studentManager.searchStudent();
                break;
            case 6:
                System.exit(0);
        }
    }
}
