package dsa_danh_sach.baitap;

public class MyListTest {
    static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student student = new Student(1, "Tung");
        Student student1 = new Student(2, "Khanh");
        Student student2 = new Student(3, "Dat");
        Student student3 = new Student(4, "Chuong");
        Student student4 = new Student(5, "Toan");


        MyList<Student> studentMyList = new MyList<>();
        studentMyList.add(student);
        studentMyList.add(student1);
        studentMyList.add(student2);
        studentMyList.add(student3);
        studentMyList.add(student4);
        for (int i = 0; i < studentMyList.size(); i++) {
            Student students = (Student) studentMyList.elements[i];
            System.out.println();
            System.out.print("Id: " + students.getId() + " ");
            System.out.print("Name: " + students.getName());
        }
        System.out.println();
        System.out.println("danh sach co " + studentMyList.size() + " students");
//        System.out.println(studentList.get(2).getName());
//        System.out.println(studentMyList.indexOf(student1));
//        System.out.println(studentMyList.contains(student3));
//        studentMyList.clear();


    }
}
