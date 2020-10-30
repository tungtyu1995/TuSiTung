package bai_thi_lai;

import demo.character1.WorkerManager;
import demo.character1.WorkerUtility;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        System.out.println("____________CHUONG TRINH QUAN LY DANH BA_______________");
        PhoneBookManager phoneBookManager = new PhoneBookManager();
        phoneBookManager.setPhoneBookList(PhoneBookUtility.readPhoneBook());
        System.out.println("[1].xem danh sach");
        System.out.println("[2].them moi");
        System.out.println("[3].cap nhat");
        System.out.println("[4].xoa");
        System.out.println("[5].tim kiem");
        System.out.println("[6].doc tu file");
        System.out.println("[7].ghi vao file");
        System.out.println("_______________________");
        System.out.print("Select an option: ");
        int opt = Integer.parseInt((new Scanner(System.in).nextLine()));
        switch (opt) {
            case 1:
                phoneBookManager.hienThiDanhSach();
                showMainMenu();
                break;
            case 2:
                phoneBookManager.themMoiSDT();
                PhoneBookUtility.writeWorkerFile(phoneBookManager.getPhoneBookList());
                showMainMenu();
                break;
            case 3:
                phoneBookManager.capNhat();
                PhoneBookUtility.writeWorkerFile(phoneBookManager.getPhoneBookList());
                showMainMenu();
                break;
            case 4:
                phoneBookManager.xoaSoDienThoai();
                PhoneBookUtility.writeWorkerFile(phoneBookManager.getPhoneBookList());
                showMainMenu();
                break;
            case 5:
                phoneBookManager.timkiemSoDienThoai();
                showMainMenu();
                break;
            case 6:
                Scanner scanner = new Scanner(System.in);
                System.out.println("Xoa toan bo danh ba trong bo nho ");
                System.out.println("1.Yes");
                System.out.println("2.No");
                int n;
                n = scanner.nextInt();
                if (n == 1) {
                    PhoneBookUtility.readPhoneBook();
                    for (PhoneBook phoneBook : phoneBookManager.getPhoneBookList()) {
                        System.out.println(phoneBook.toString());
                    }
                } else {
                    System.out.println("!!!");
                }
                showMainMenu();
                break;
            case 7:
                PhoneBookUtility.writeWorkerFile(phoneBookManager.getPhoneBookList());
                showMainMenu();
                break;
                case 8:
                System.exit(0);
        }
        System.out.println("_______________________");
        showMainMenu();
    }
}
