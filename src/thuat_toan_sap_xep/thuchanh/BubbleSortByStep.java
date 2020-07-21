package thuat_toan_sap_xep.thuchanh;

import java.util.Scanner;

public class BubbleSortByStep {

    public static void bubbleSortByStep(int[] list) {
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    /* Swap list[i] with list[i + 1] */
                    System.out.println("doi vi tri " + list[i] + " voi " + list[i + 1]);
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true; /* Next pass still needed */
                }
            }
            /* Array may be sorted and next pass not needed */
            if (needNextPass == false) {
                System.out.println("Danh sach da  duoc sap xep ");
                break;
            }
            /* Show the list after sort */
            System.out.print("danh sach sau  " + k + " lan sap xep: ");
            for (int j = 0; j < list.length; j++) {
                System.out.print(list[j] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao do dai danh sach:");
        int size = scanner.nextInt();
        int[] list = new int[size];


        for (int i = 0; i < list.length; i++) {
            System.out.println("Nhap vao so thu " + (i+1));
            list[i] = scanner.nextInt();
        }

        System.out.print("danh sach ban nhap vao: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println("\n Bat dau sap xep...");
        bubbleSortByStep(list);
    }
}

