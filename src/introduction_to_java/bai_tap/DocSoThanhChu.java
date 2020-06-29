package introduction_to_java.bai_tap;

import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số bạn cần đọc");
        int number = scanner.nextInt();
        String nameNumber = "";

        if (number < 10 && number >= 0) {
            switch (number) {
                case 0:
                    nameNumber += "không";
                    break;
                case 1:
                    nameNumber += "một";
                    break;
                case 2:
                    nameNumber += "hai";
                    break;
                case 3:
                    nameNumber += "ba";
                    break;
                case 4:
                    nameNumber += "bốn";
                    break;
                case 5:
                    nameNumber += "năm";
                    break;
                case 6:
                    nameNumber += "sáu";
                    break;
                case 7:
                    nameNumber += "bảy";
                    break;
                case 8:
                    nameNumber += "tám";
                    break;
                case 9:
                    nameNumber += "chính";
            }
        } else if (number < 20) {
            switch (number - 10) {
                case 0:
                    nameNumber += "mười";
                    break;
                case 1:
                    nameNumber += "mười một";
                    break;
                case 2:
                    nameNumber += "mười hai";
                    break;
                case 3:
                    nameNumber += "mười ba";
                    break;
                case 4:
                    nameNumber += "mười bốn";
                    break;
                case 5:
                    nameNumber += "mười lăm";
                    break;
                case 6:
                    nameNumber += "mười sáu";
                    break;
                case 7:
                    nameNumber += "mười bảy";
                    break;
                case 8:
                    nameNumber += "mười tám";
                    break;
                case 9:
                    nameNumber += "mười chín";
            }

        }
        else if (number < 100) {

            switch (number / 10) {
                case 2:
                    nameNumber += "hai mươi";
                    break;
                case 3:
                    nameNumber += "ba mươi";
                    break;
                case 4:
                    nameNumber += "bốn mươi";
                    break;
                case 5:
                    nameNumber += "năm mươi";
                    break;
                case 6:
                    nameNumber += "sáu mươi";
                    break;
                case 7:
                    nameNumber += "bảy mươi";
                    break;
                case 8:
                    nameNumber += "tám mươi";
                    break;
                case 9:
                    nameNumber += "chính mươi";
            }
            switch (number % 10) {
                case 1:
                    nameNumber += " một";
                    break;
                case 2:
                    nameNumber += " hai";
                    break;
                case 3:
                    nameNumber += " ba";
                    break;
                case 4:
                    nameNumber += " bốn";
                    break;
                case 5:
                    nameNumber += " năm";
                    break;
                case 6:
                    nameNumber += " sáu";
                    break;
                case 7:
                    nameNumber += " bảy";
                    break;
                case 8:
                    nameNumber += " tám";
                    break;
                case 9:
                    nameNumber += " chính";

            }
        }
        else if (number <= 999) {
            int surplus = number % 100;
            switch (number/100) {
                case 1:
                    nameNumber += " một trăm";
                    break;
                case 2:
                    nameNumber += " hai trăm";
                    break;
                case 3:
                    nameNumber += " ba trăm";
                    break;
                case 4:
                    nameNumber += " bốn trăm";
                    break;
                case 5:
                    nameNumber += " năm trăm";
                    break;
                case 6:
                    nameNumber += " sáu trăm";
                    break;
                case 7:
                    nameNumber += " bảy trăm";
                    break;
                case 8:
                    nameNumber += " tám trăm";
                    break;
                case 9:
                    nameNumber += " chính trăm";
                    break;
            }
            switch (surplus / 10) {
                case 0:
                    nameNumber += " lẻ";
                    break;
                case 1:
                    nameNumber += " mười";
                    break;
                case 2:
                    nameNumber += " hai mươi";
                    break;
                case 3:
                    nameNumber += " ba mươi";
                    break;
                case 4:
                    nameNumber += " bốn mươi";
                    break;
                case 5:
                    nameNumber += " năm mươi";
                    break;
                case 7:
                    nameNumber += " bảy mươi";
                    break;
                case 8:
                    nameNumber += " tám mươi";
                    break;
                case 9:
                    nameNumber += " chính mươi";
                    break;
            }
            switch (number % 10) {
                case 1:
                    nameNumber += " một";
                    break;
                case 2:
                    nameNumber += " hai";
                    break;
                case 3:
                    nameNumber += " ba";
                    break;
                case 4:
                    nameNumber += " bốn";
                    break;
                case 5:
                    nameNumber += " năm";
                    break;
                case 6:
                    nameNumber += " sáu";
                    break;
                case 7:
                    nameNumber += " bảy";
                    break;
                case 8:
                    nameNumber += " tám";
                    break;
                case 9:
                    nameNumber += " chính";

            }

        }
        System.out.println("" + nameNumber);
    }
}
