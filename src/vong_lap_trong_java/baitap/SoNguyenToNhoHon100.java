package vong_lap_trong_java.baitap;

import java.util.Scanner;

public class SoNguyenToNhoHon100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number =2;
        String stringNumber = "";

            while (number < 100) {
                boolean check = true;
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    stringNumber += number + ",";
                }
                number++;
            }
        System.out.println("Các số nguyên tố bé hơn 100 là : "+ stringNumber);
        }
    }

