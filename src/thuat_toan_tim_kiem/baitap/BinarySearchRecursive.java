package thuat_toan_tim_kiem.baitap;

import java.util.Scanner;

public class BinarySearchRecursive {
    private static int binarySearch(int[] arrNumber, int low, int high, int number) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (arrNumber[mid] == number)
                return mid;
            if (arrNumber[mid] > number){
                return binarySearch(arrNumber, low, mid-1 , number);
            }else {
                return binarySearch(arrNumber, mid+1 , high, number);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arrNumber = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        Scanner scanner = new Scanner(System.in);
        System.out.print(" nhap vao so can tim: ");
        int number = scanner.nextInt();
        int low = 0;
        int high = arrNumber.length - 1;
        int result = binarySearch(arrNumber, low, high, number);
        if (result == -1) {
            System.out.println("khong tim thay");
        } else {
            System.out.println(number + " nam o vi tri: " + (result+1));
        }
    }
}
