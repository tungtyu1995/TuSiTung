package mang_trong_java.baitap;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử mảng:");
        int size = sc.nextInt();
        int[] array = new int[size+1];
        System.out.println("Nhập phần tử của mảng");
        for (int i = 0; i < size; i++) {
            System.out.print("Nhập phần tử thứ: " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }
        System.out.print("Mảng trước khi thêm vào:");
        for (int val :array) {
            System.out.print(val + " ");
        }
        System.out.print("Nhập phần tử muốn thêm vào mảng: ");
        int goal = sc.nextInt();
        System.out.print("Nhập vị trí muốn thêm vào mảng: ");
        int index = sc.nextInt();

        System.out.println("");
        System.out.print("Mảng sau khi thêm vào:");
        for (int i = array.length - 1 ; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = goal;
        for (int val : array){
            System.out.print(val + " ");
        }
    }
}
