package demo.character;

import demo.io_byte.StudentUtility;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        StudentCManager studentCManager = new StudentCManager();


        System.out.println("____MENU____");
        System.out.println("1.Add new student");
        System.out.println("2.Display student list");
        System.out.println("3.Delete a student");
        System.out.println("4.edit a student");
        System.out.println("5.search a student");
        System.out.println("6.Exit");
        System.out.println("_________________");
        studentCManager.setStudentCList(StudentCUtility.readStudentCFile());
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select an option:");

        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1:
                studentCManager.addNewStudent();
                StudentCUtility.writeStudentCFile(studentCManager.getStudentCList());
                showMainMenu();
                break;
            case 2:
                studentCManager.displayStudentList();
                showMainMenu();
                break;
            case 3:
                studentCManager.deleteStudentC();
                StudentCUtility.writeStudentCFile(studentCManager.getStudentCList());
                showMainMenu();
                break;
            case 4:
                studentCManager.editStudentC();
                StudentCUtility.writeStudentCFile(studentCManager.getStudentCList());
                showMainMenu();
                break;
            case 5:
                studentCManager.searchStudent();
                break;
            case 6:
                System.exit(0);
        }
    }
}
