package access_modifier.baitap;

import java.util.Scanner;

public class StudentCodeGymClass {

    private static StudentCodeGym[] listStudent;
    private static int count = 0;

    static {
        listStudent = new StudentCodeGym[20];
    }

    public int getSize() {
        return count;
    }

    public int getIdStudent(int n) {
        return listStudent[n].getId();
    }

    public String getNameStudent(int n) {
        return listStudent[n].getName();
    }

    public String getDateOfBirthStudent(int n) {
        return listStudent[n].getDateOfBirth();
    }
// them hoc vien
    public void register(StudentCodeGym student) {
        if (count >= 20) {
            System.out.println("Lop da du hoc vien!!! Thang sau quay lai ban nhe");
        } else {
            System.out.println("Chao don " + student.getName() + " gia nhap CdeGym !!!");
            listStudent[count] = student;
            count++;
        }
    }
//Xoa hoc vien tot nghiep
    public void graduate(int id) {
        for (int i = 0; i < listStudent.length - 1; i++) {
            if (listStudent[i].getId() == id) {
                System.out.println("Chuc mung " + listStudent[i].getName() + " Ban da tot nghiep!!!");
                for (int j = i; j < listStudent.length - 1; j++) {
                    listStudent[j] = listStudent[j + 1];
                }
                break;
            }
        }
        listStudent[listStudent.length - 1] = null;
        count--;
    }
//Hien thi danh sach hoc vien
    public void displayListStudent() {
        System.out.printf("%-5s%-5s%-15s%s", "", "Id", "Name", "Date of Birth");
        System.out.println();
        for (int i = 0; i < count; i++) {
            System.out.printf("%-5d%-5d%-15s%s", i+1, listStudent[i].getId(), listStudent[i].getName(), listStudent[i].getDateOfBirth());
            System.out.println();
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentCodeGym student1 = new StudentCodeGym(69, "Kha Banh", "dd/MM/19xx");
        StudentCodeGym student2 = new StudentCodeGym(96, "Huan Hoa Hong", "dd/MM/19xx");
        StudentCodeGym student3 = new StudentCodeGym(6969, "Chi Pheo", "dd/MM/19xx");
        StudentCodeGym student4 = new StudentCodeGym(6996, "Thi No", "dd/MM/19xx");
        StudentCodeGymClass listStudent = new StudentCodeGymClass();
        listStudent.register(student1);
        listStudent.register(student2);
        listStudent.register(student3);
        listStudent.register(student4);
        int choice = -1;
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Them hoc vien");
            System.out.println("2. Xoa hoc vien da tot nghiep");
            System.out.println("3. Hien thi danh sach hoc vien");
            System.out.println("0. Thoát");
            System.out.println("Nhap su lua chon cua ban: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    int addId;
                    System.out.print("Nhap vao id cua hoc vien: ");
                    addId = scanner.nextInt();
                    System.out.print("Nhap vao ten hoc vien: ");
                    String addName = scanner.nextLine();
                    addName = scanner.nextLine();
                    System.out.print("Nhap vao ngay sinh cua  hoc vien: ");
                    String addDate = scanner.nextLine();
                    StudentCodeGym student = new StudentCodeGym(addId, addName, addDate);
                    listStudent.register(student);
                    break;
                case 2:
                    System.out.println("Nhap id hoc vien bạn muon xoa: ");
                    int deleteId = scanner.nextInt();
                    int confirm;
                    int index = 0;
                    System.out.println("Ban thuc su muon xoa hoc vien nay!!!");
                    System.out.println(listStudent.getIdStudent(index) + " " + listStudent.getNameStudent(index) + " " + listStudent.getDateOfBirthStudent(index));
                    System.out.print("1.Yes or 2.No: ");
                    confirm = scanner.nextInt();
                    if (confirm == 1) {
                        listStudent.graduate(deleteId);
                        break;
                    } else {
                        System.out.println("Ban khong muon xoa hoc vien");
                    }
                    break;
                case 3:
                    listStudent.displayListStudent();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Lua chon cua ban khong ton tai!");
            }
        }
    }
}