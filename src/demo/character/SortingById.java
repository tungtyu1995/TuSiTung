package demo.character;

import java.util.Comparator;

public class SortingById implements Comparator<StudentC> {
    @Override
    public int compare(StudentC st1, StudentC st2) {
        return st1.getId().compareTo(st2.getId());
    }
}
