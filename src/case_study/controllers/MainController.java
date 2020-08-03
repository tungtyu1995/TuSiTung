package case_study.controllers;

import case_study.models.*;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MainController mainController = new MainController();
        displayMainMenu(scanner);
    }

    public static void displayMainMenu(Scanner scanner) {

        int inputMenu;
        do {
            System.out.println("-------------- Display Main Menu ----------------");
            System.out.print("1.\tAdd New Services\n" +
                    "2.\tShow Services\n" +
                    "3.\tAdd New Customer\n" +
                    "4.\tShow Information of Customer\n" +
                    "5.\tAdd New Booking\n" +
                    "6.\tShow Information of Employee\n" +
                    "7.\tExit\n" +
                    "Enter the number : ");


            inputMenu = scanner.nextInt();
            switch (inputMenu) {
                case 1:
                    addNewService(scanner);
                    break;
                case 2:
                    showServices(scanner);
                    break;
                case 3:
                    FileCustomerUtils.addNewCustomer();
                    break;
                case 4:
                    FileCustomerUtils.showInformationCustomers();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Error number");
            }
        }
        while (inputMenu != -1);
    }


    public static void addNewService(Scanner scanner) {
        int inputMenu;

        do {
            System.out.println("------------ Add New Service --------------");
            System.out.print("1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "5.\tExit to main menu\n" +
                    "Enter the number : ");
            inputMenu = scanner.nextInt();
            switch (inputMenu) {
                case 1:
                    FileVillaUtils.addNewServiceVilla(scanner);
                    break;
                case 2:
                    FileHouseUtils.addNewServiceHouse(scanner);
                    break;
                case 3:
                    FileRoomUtils.addNewServiceRoom(scanner);
                    break;
                case 4:
                    displayMainMenu(scanner);
                    break;
                case 5:
                    inputMenu = -1;
                    break;
                default:
                    System.out.println("Error number");
            }
        }
        while (inputMenu != -1);
        displayMainMenu(scanner);
    }


    public static void showServices(Scanner scanner) {

        System.out.println("---------- Show all service--------");
        int inputMenu;
        do {
            System.out.print("1.\tShow all Villa\n" +
                    "2.\tShow all House\n" +
                    "3.\tShow all Room\n" +
                    "4.\tShow All Name Villa Not Duplicate\n" +
                    "5.\tShow All Name House Not Duplicate\n" +
                    "6.\tShow All Name Name Not Duplicate\n" +
                    "7.\tBack to menu\n" +
                    "8.\tExit\n" +
                    "Enter the number : ");

            inputMenu = scanner.nextInt();
            switch (inputMenu) {

                case 1:
                    FileVillaUtils.showAllVilla();
                    break;
                case 2:
                    FileHouseUtils.showAllHouse();
                    break;
                case 3:
                    FileRoomUtils.showAllRoom();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    displayMainMenu(scanner);
                    break;
                case 8:
                    inputMenu = -1;
                    break;
                default:
                    System.out.println("Wrong input");

            }
        } while (inputMenu != -1);

    }
}