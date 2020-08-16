package demo.character1;

import java.util.Comparator;

public class SortingById implements Comparator<WorkerFactory> {
    @Override
    public int compare(WorkerFactory w1, WorkerFactory w2) {
        return w1.getId().compareTo(w2.getId());
    }
}
