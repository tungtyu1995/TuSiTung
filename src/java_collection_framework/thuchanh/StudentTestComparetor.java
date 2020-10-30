package java_collection_framework.thuchanh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StudentTestComparetor {
    public static void main(String[] args) {
        Student student1 = new Student("Tung",26,"QB");
        Student student2 = new Student("Tung", 28,"NA");
        Student student3 = new Student("Dat",28,"QN");
        Student student4 = new Student("Dat", 26,"QB");
        Student student5 = new Student("Dat", 21, "QN");
        Student student6 = new Student("Tung",20,"QN");
        List<Student> list = new ArrayList<Student>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);
        for (Student st : list){
            System.out.println(st.toString());
        }
        Comperator comparator = new Comperator();
        Collections.sort(list,comparator);
        System.out.println("____sort Name,Age,Address_____");
//        for (Student st : list){
//            System.out.println(st.toString());
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        }
    }

