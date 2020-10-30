package java_collection_framework.thuchanh;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student("Tung",25,"QB");
        Student student2 = new Student("Dat", 28,"QN");
        Student student3 = new Student("Khanh", 26,"NA");
        Map<Integer,Student> studentMap = new HashMap<Integer,Student>();
        studentMap.put(1,student1);
        studentMap.put(2,student2);
        studentMap.put(3,student3);
        studentMap.put(4,student2);
        for (Map.Entry<Integer,Student> student : studentMap.entrySet()){
            System.out.println(student.toString());
        }
        System.out.println("____Set_____");
        Set<Student> students = new HashSet<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student2);
        for (Student student : students){
            System.out.println(student.toString());
        }
    }
}
