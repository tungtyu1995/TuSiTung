package bai_thi;

import demo.character1.WorkerFactory;
import demo.io_byte.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SanPhamManager {

    private List<SanPham> listSanPham = new ArrayList<>();

    public List<SanPham> getListSanPham() {
        return listSanPham;
    }

    public void setListSanPham(List<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public SanPhamManager(List<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public SanPhamManager() {
    }

    Scanner scanner = new Scanner(System.in);

    public void themMoiSanPham() {
        System.out.println("Nhap so can chon");
        System.out.println("1.Them San Pham Nhap Khau");
        System.out.println("2.Them San Pham Xuat Khau");
        int opt = Integer.parseInt((new Scanner(System.in).nextLine()));
        switch (opt) {
            case 1:
                String maSanPham;
                String tenSanPham;
                double giaBan;
                int soLuong;
                String nhaSanXuat;
                double giaNhapKhau;
                String tinhThanhNhap;
                double thueNhapKhau;
                System.out.println("Nhap vao ma san pham");
                maSanPham = scanner.nextLine();
                System.out.println("Nhap vao ten san pham");
                tenSanPham = scanner.nextLine();
                System.out.println("Nhap vao gia ban");
                giaBan = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhap vao so luong");
                soLuong = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhap vao nha san xuar");
                nhaSanXuat = scanner.nextLine();
                System.out.println("Nhap vao gia nhap khau");
                giaNhapKhau = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhap vao tinh thanh nhap");
                tinhThanhNhap = scanner.nextLine();
                System.out.println("Nhap vao thue nhap khau");
                thueNhapKhau = Double.parseDouble(scanner.nextLine());
                SanPhamNhapKhau sanPhamNhapKhau = new SanPhamNhapKhau(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat, giaNhapKhau, tinhThanhNhap, thueNhapKhau);
                this.listSanPham.add(sanPhamNhapKhau);
                System.out.println("Them moi san pham thanh cong");
                break;
            case 2:
                double giaXuatKhau;
                String quocGiaNhapSanPham;
                System.out.println("Nhap vao ma san pham");
                maSanPham = scanner.nextLine();
                System.out.println("Nhap vao ten san pham");
                tenSanPham = scanner.nextLine();
                System.out.println("Nhap vao gia ban");
                giaBan = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhap vao so luong");
                soLuong = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhap vao nha san xuar");
                nhaSanXuat = scanner.nextLine();
                System.out.println("Nhap vao gia xuat khau");
                giaXuatKhau = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhap vao quoc gia nhap san pham");
                quocGiaNhapSanPham = scanner.nextLine();
                SanPhamXuatKhau sanPhamXuatKhau = new SanPhamXuatKhau(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat, giaXuatKhau, quocGiaNhapSanPham);
                this.listSanPham.add(sanPhamXuatKhau);
                System.out.println("Them moi san pham thanh cong");
                break;
            default: {
                System.out.println("Khong ton tai lua chon");
            }
        }
    }

    public void xoaSanPham() {
        System.out.print("Nhap ten san pham can xoa: ");
        String tenSanPham = new Scanner(System.in).nextLine();
        boolean isFound = false;
        for (SanPham sanPham : this.listSanPham) {
            if (tenSanPham.compareTo(sanPham.getTenSanPham()) == 0) {
                isFound = true;
                this.listSanPham.remove(sanPham);
                break;
            }
        }

        if (isFound) {
            System.out.println("Xoa san pham thanh cong");
        } else {
            System.out.println("Ten san pham khong ton tai");
        }
    }
    public void hienThiDanhSachSanPham(){
        Iterator<SanPham> iterator = this.getListSanPham().iterator();
        int i = 1;
        while(iterator.hasNext()) {
            System.out.println(i + ". " + iterator.next().toString());
            i++;
        }
    }
    public void timKiemSanPham(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao ten san pham can tim: ");
        String tenSanPham = scanner.nextLine();
        boolean checkSearch = false;
        for (SanPham sanPham:this.getListSanPham()){
            if (tenSanPham.equals(sanPham.getTenSanPham())){
                System.out.println(sanPham);
                checkSearch = true;
                break;
            }
        }if (!checkSearch){
            System.out.println("Ten san pham khong ton tai");
        }
    }

}
