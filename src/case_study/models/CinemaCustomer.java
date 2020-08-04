package case_study.models;

import java.util.Deque;
import java.util.LinkedList;

public class CinemaCustomer {
public final int CAPACITY = 20;
private Deque<String> deque = new LinkedList<>();
private int available = CAPACITY;

    public int getCAPACITY() {
        return CAPACITY;
    }

    public Deque<String> getDeque() {
        return deque;
    }

    public void setDeque(Deque<String> deque) {
        this.deque = deque;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
    public void buyTicket(String name, int numberOfTicket){
        if (available > numberOfTicket){
            deque.add(name);
            System.out.println(" Tickets have been bought ");

        }
    }
}
