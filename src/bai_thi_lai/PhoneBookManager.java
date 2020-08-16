package bai_thi_lai;

import demo.character1.SortingById;
import demo.character1.WorkerFactory;
import demo.io_byte.Student;

import java.util.*;
import java.util.concurrent.ScheduledExecutorService;

public class PhoneBookManager {
    private List<PhoneBook> phoneBookList;

    public PhoneBookManager() {
        phoneBookList = new ArrayList<>();
    }

    public PhoneBookManager(List<PhoneBook> phoneBookList) {
        this.phoneBookList = phoneBookList;
    }

    public List<PhoneBook> getPhoneBookList() {
        return phoneBookList;
    }

    public void setPhoneBookList(List<PhoneBook> phoneBookList) {
        this.phoneBookList = phoneBookList;
    }

    public void themMoiSDT(){
        Scanner scanner = new Scanner(System.in);
        String soDienThoai;
        String nhomCuaDanhBa;
        String hoTen;
        String gioiTinh;
        String diaChi;
        String ngaySinh;
        String email;
        boolean check;

        do {
            System.out.println("Nhap vao so dien thoai");
            soDienThoai = scanner.nextLine();
            if (soDienThoai == null || !soDienThoai.matches("^[\\d]{10,11}$")) {
                check = false;
                System.err.println("so dien thoai khong hop le");
            } else {
                check = true;
            }
        } while ( !check );


        do {
            System.out.println("Nhap vao nhom cua danh ba");
            nhomCuaDanhBa = scanner.nextLine();
            if ("".equals(nhomCuaDanhBa)) {
                check = false;
                System.err.println("nhom cua danh ba khong hop le");
            } else {
                check = true;
            }
        } while ( !check );

        do {
            System.out.println("nhap vao ten");
            hoTen = scanner.nextLine();
            if ("".equals(hoTen)) {
                check = false;
                System.err.println("ten khong hop  le");
            } else {
                check = true;
            }
        } while ( !check );

        do {
            System.out.println("Nhap vao gioi tinh");
            gioiTinh = scanner.nextLine();
            if ("".equals(gioiTinh)) {
                check = false;
                System.err.println("gioi tinh khong hop  le");
            } else {
                check = true;
            }
        } while ( !check );

        do {
            System.out.println("nhap vao dia chi");
            diaChi = scanner.nextLine();
            if ("".equals(diaChi)) {
                check = false;
                System.err.println("dia chi hop  le");
            } else {
                check = true;
            }
        } while ( !check );

        do {
            System.out.println("nhap vao ngay sinh");
            ngaySinh = scanner.nextLine();
            if ("".equals(ngaySinh)) {
                check = false;
                System.err.println(" ngay sinh khong hop  le");
            } else {
                check = true;
            }
        } while ( !check );

        do {
            System.out.println("nhap vao email");
            email = scanner.nextLine();
            if (email == null || !email.matches("^[\\w]{3,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$")) {
                check = false;
                System.err.println("email khong hop  le");
            } else {
                check = true;
            }
        } while ( !check );

        PhoneBook phoneBook = new PhoneBook(soDienThoai,nhomCuaDanhBa,hoTen,gioiTinh,diaChi,ngaySinh,email);

        this.phoneBookList.add(phoneBook);

        System.out.println("Them so dien thoai " + soDienThoai+ " thanh cong");

    }
    public void capNhat() {
        System.out.print("Nhap vao so dien thoai ");
        String id = new Scanner(System.in).nextLine();
        boolean isFound = false;
        PhoneBook foundPhoneBook = null;
        for (PhoneBook phoneBook : this.phoneBookList) {
            if (id.compareTo(phoneBook.getSoDienThoai()) == 0) {
                isFound = true;
                foundPhoneBook = phoneBook;
                System.out.println("PhoneBook found: ");
                System.out.println(phoneBook.toString());
                break;
            }
        }

        if (isFound) {
            System.out.print("Nhap vao nhom cua danh ba ");
            String nhomCuaDanhBa =  new Scanner(System.in).nextLine();
            System.out.println("Nhap vao ho ten");
            String hoTen =  new Scanner(System.in).nextLine();
            System.out.println("Nhap vao gioi tinh");
            String gioiTinh =  new Scanner(System.in).nextLine();
            System.out.println("Nhap vao dia chi");
            String diaChi =  new Scanner(System.in).nextLine();
            System.out.println("Nhap vao ngay sinh");
            String ngaySinh =  new Scanner(System.in).nextLine();
            System.out.println("Nhap vao email");
            String email = new Scanner(System.in).nextLine();


            foundPhoneBook.setNhomCuaDanhBa(nhomCuaDanhBa);
            foundPhoneBook.setHoTen(hoTen);
            foundPhoneBook.setGioiTinh(gioiTinh);
            foundPhoneBook.setDiaChi(diaChi);
            foundPhoneBook.setNgaySinh(ngaySinh);
            foundPhoneBook.setEmail(email);
            System.out.println("New update:");
            System.out.println(foundPhoneBook.toString());
        } else {
            System.out.println("khong tim thay so dien thoai");
        }
    }
    public void hienThiDanhSach() {

        Iterator<PhoneBook> iterator = this.getPhoneBookList().iterator();
        int i = 1;
        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
            i++;
        }
    }
    public void xoaSoDienThoai() {
        System.out.print("Nhap vao so dien thoai can xoa ");
        String soDienThoai = new Scanner(System.in).nextLine();
        boolean isFound = false;
        for (PhoneBook phoneBook : this.phoneBookList) {
            if (soDienThoai.compareTo(phoneBook.getSoDienThoai()) == 0) {
                isFound = true;
                this.phoneBookList.remove(phoneBook);
                break;
            }
        }

        if (isFound) {
            System.out.println("Xoa thanh cong so dien thoai "+soDienThoai);
        } else {
            System.out.println("So dien thoai khong  ton tai");
        }
    }
    public void timkiemSoDienThoai(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao ten can tim ");
        String nameSearch = scanner.nextLine();
        boolean checkSearch = false;
        for (PhoneBook phoneBook:this.getPhoneBookList()){
            if (nameSearch.contains(phoneBook.getHoTen())){
                System.out.println(phoneBook);
                checkSearch = true;
                break;
            }
        }if (!checkSearch){
            System.out.println("Khong tim thay ten "+ nameSearch);
        }
    }
}
