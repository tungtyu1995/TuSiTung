package mang_trong_java.baitap;

import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số phần tử của mảng:");
        int n = scanner.nextInt();
        int[] array;
        array = new int[69];
        for (int i = 0 ; i  < n ; i++) {
            System.out.print("Nhập phần tử thứ "+(i+1)+":");
            array[i] = scanner.nextInt();
        }
        System.out.print("Mảng trước khi xóa:");
        for (int i = 0 ; i  < n ; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.print("Nhập vào phần tử cần xóa:");
        int x = scanner.nextInt();
        for (int i = 0 ; i < n ; i++) {
            if (array[i] == x) {
                array[i] = 0;
                for(int j = i ; j < n ; j++) {
                    array[j] = array[j + 1];
                }
                n--;i--;
            }
        }
        System.out.print("Mảng sau khi xóa:");
        for (int i = 0 ; i < n ; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
