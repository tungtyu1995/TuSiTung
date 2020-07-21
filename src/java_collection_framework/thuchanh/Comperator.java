package java_collection_framework.thuchanh;

import java.util.Comparator;

public class Comperator implements Comparator<Student> {

    @Override
    public int compare(Student st1, Student st2) {
        int returnName = st1.getName().compareTo(st2.getName());
        if (returnName == 0){
            int returnAge = st1.getAge()-st2.getAge();
            if (returnAge==0){
                return st1.getAddress().compareTo(st2.getAddress());
            }
            return returnAge;
        }
        return returnName;
    }
}
