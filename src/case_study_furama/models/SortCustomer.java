package case_study_furama.models;

import java.util.Comparator;

public class SortCustomer implements Comparator<Customer> {


    @Override
    public int compare(Customer c1, Customer c2) {
        int i = c1.getNameCustomer().compareTo(c2.getNameCustomer());
        if(i==0){
            return (c1.getDayOfBirth().compareTo(c2.getDayOfBirth()));
        }
        else {
            return i;
        }
    }
}
