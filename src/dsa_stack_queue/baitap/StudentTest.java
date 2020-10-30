package dsa_stack_queue.baitap;

import java.util.LinkedList;
import java.util.Queue;

public class StudentTest {
    public static void main(String[] args) {
        Queue<Student> male = new LinkedList<>();
        Queue<Student> female = new LinkedList<>();
        int size = 5;
        Student[] profile = new Student[size];

        profile[0] = new Student(" Tung ","Male","23/05/1995");
        profile[1] = new Student(" Khanh ","Male","21/02/1995");
        profile[2] = new Student(" Giang ","Female","13/04/1995");
        profile[3] = new Student(" Dat ","Male","25/12/1995");
        profile[4] = new Student(" Mai ","Female","19/05/1995");

        for (int i = 0; i < size; i++) {
            if (profile[i].getGender().equals("Male")) {
                male.add(profile[i]);
            } else if (profile[i].getGender().equals("Female")) {
                female.add(profile[i]);
            }
        }
        for (Student x : profile){
            System.out.println(x);
        }

        System.out.println();

        while(!female.isEmpty()){
            System.out.println(female.poll().toString());
        }
        while(!male.isEmpty()){
            System.out.println(male.poll().toString());
        }
    }
}
