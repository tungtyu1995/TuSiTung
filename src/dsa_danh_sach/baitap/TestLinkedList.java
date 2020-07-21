package dsa_danh_sach.baitap;

public class TestLinkedList {
    static class Student {
        private int id;
        private String name;

        public Student() {
        }

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
        MyLinkedList<Student> studentMyLinkedList = new MyLinkedList<>();
        Student student1 = new Student(1,"Tung");
        Student student2 = new Student(2,"Khanh");
        Student student3 = new Student(3,"Dat");
        Student student4 = new Student(4,"Chuong");
        Student student5 = new Student(5,"Toan");

        studentMyLinkedList.addFirst(student5);
        studentMyLinkedList.addFirst(student4);
        studentMyLinkedList.addFirst(student3);
        studentMyLinkedList.addFirst(student2);
        studentMyLinkedList.addFirst(student1);
        studentMyLinkedList.remove(1);
        for (int i = 0; i < studentMyLinkedList.size(); i++) {
            Student student = (Student)studentMyLinkedList.get(i);
            System.out.print(student.getId()+" ");
            System.out.println(student.getName());
        }
    }
}
