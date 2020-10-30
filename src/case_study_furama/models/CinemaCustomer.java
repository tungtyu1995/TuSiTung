package case_study_furama.models;

import java.util.*;

public class CinemaCustomer {
    static Scanner scanner = new Scanner(System.in);
    static Queue myQueue = new LinkedList();

    public static void sellTicket() {
        FileCustomerUtils.showInformationCustomers();

        List<Customer> listCustomerTicket = FileCustomerUtils.readCustomer();
        Collections.sort(listCustomerTicket, new SortCustomer());

        String idTicket;
        boolean checkStatus = false;
        do {
            System.out.println("Enter 'id customer' or 'name customer': to buy ticket  or 'Exit': to back menu. ");
            idTicket = scanner.nextLine();

            if (idTicket.equals("Exit")) {
                checkStatus = true;
            } else {
                for (int i = 0; i < listCustomerTicket.size(); i++) {
                    if (listCustomerTicket.get(i).getIdCustomer().equals(idTicket) || listCustomerTicket.get(i).getNameCustomer().equals(idTicket)) {
                        myQueue.offer(listCustomerTicket.get(i).getNameCustomer() + " Id: " + listCustomerTicket.get(i).getIdCustomer());
                        System.out.println("Succession");
                        checkStatus = false;
                    }
                }
            }
        }
        while (!checkStatus);
    }

    public static void getCustomer() {
        int i = 1;
        while (!myQueue.isEmpty()) {
            System.out.println(i + " Name: " + myQueue.poll());
            i++;
        }
    }
}
