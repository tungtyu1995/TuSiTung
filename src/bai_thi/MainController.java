package bai_thi;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {

        System.out.println("Nhap vao so can thuc hien: ");
        System.out.println("1.Them moi san pham");
        System.out.println("2.Xoa san pham");
        System.out.println("3.Hien thi danh sach san pham");
        System.out.println("4.Tim kiem san pham");
        System.out.println("5.Thoat");
        Scanner scanner = new Scanner(System.in);
        SanPhamManager sanPhamManager = new SanPhamManager();
        int opt = Integer.parseInt((new Scanner(System.in).nextLine()));
        switch (opt) {
            case 1:
                sanPhamManager.themMoiSanPham();
                showMenu();
                break;
            case 2:
                sanPhamManager.xoaSanPham();
                break;
            case 3:
                sanPhamManager.hienThiDanhSachSanPham();
                break;
            case 4:
                sanPhamManager.timKiemSanPham();
                break;
                case 5:
                System.exit(0);
        }
    }
}
