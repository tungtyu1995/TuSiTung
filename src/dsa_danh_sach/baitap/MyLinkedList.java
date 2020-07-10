package dsa_danh_sach.baitap;

public class MyLinkedList<E> {
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    // khai báo phần tử đầu tiên của danh sách
    private Node head;
    // số lượng phần tử trong danh sách mặc định là 0;
    private int numNodes = 0;

    public MyLinkedList() {
    }

    // thêm phần tử vào đầu danh sách danh sách.
    public void addFirst(E element) {
        // khai báo 1 biến làm temp trỏ đến giá trị của head;
        Node temp = head;
        // biến head sẽ nhận giá trị một node mới;
        head = new Node(element);
        //head.next trỏ đến temp
        head.next = temp;
        numNodes++;
    }

    // thêm phần tử cáo cuối danh sách .
    public void addLast(E element) {
        Node temp = head;
        //cho con trỏ dến cuối danh sách
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }

    // thêm 1 phần tử vào 1 vị trí nhất định.
    public void add(int index, E element) {
        Node temp = head;
        Node holder;
        // cho con trỏ chạy đến vị trí index -1.
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        // cho holder chạy đến vị trí index.
        holder = temp.next;
        // Node tại vị trí index - 1 sẽ trỏ tới 1 node mới.
        temp.next = new Node(element);
        //Node trỏ đến holder.
        temp.next.next = holder;
        // tăng số lượng phần tử trong danh sách lên 1;
        numNodes++;
    }

    // phương thức get tại một vị trí chỉ định
    public Object get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public Object getFirst() {
        if (numNodes == 0) {
            return null;
        } else {
            return head.data;
        }
    }

    public Object getLast() {
        Node temp = head;
        if (numNodes == 0) {
            return null;
        } else {
            for (int i = 0; i < numNodes - 1; i++) {
                temp = temp.next;
            }
            return temp.data;
        }
    }

    public void clear() {
        Node temp = head;
        head = null;
        for (int i = 0; i < numNodes; i++) {
            temp.next = null;
        }
        numNodes = 0;
    }

    // trả về số phần tử của linkedList.
    public int size() {
        return numNodes;
    }

    // xóa phần tử khỏi linked List tại 1 vị trí chỉ định
    public E remove(int index) {
        if (index < 0 || index > numNodes) {
            throw new IllegalArgumentException("index : " + index);
        }
        Node temp = head;
        Object data;

        // nếu index = 0 trả về data hiện tại;
        if (index == 0) {
            data = temp.data;
            head = head.next;
            numNodes--;
        } else {
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
            numNodes--;
        }
        return (E) data;
    }

    // xóa đối tượng truyền vào là 1 đối tượng không phải index.
    public boolean remove(E element) {
        //Remove đối tượng nếu element head.
        if (head.data.equals(element)) {
            remove(0);
            return true;
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.data.equals(element)) {
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
            }
        }
        return false;
    }

    // sao chép 1 linkedlist.
    public MyLinkedList<E> clone() {

        // kiếm tra linked list đã có phần tử nào chưa
        if (numNodes == 0) {
            throw new IllegalArgumentException("numNode : " + numNodes);
        } else {
            MyLinkedList<E> returnMylinkedList = new MyLinkedList<>();
            Node temp = head;
            returnMylinkedList.addFirst((E) temp.data);
            temp = temp.next;
            while (temp != null) {
                returnMylinkedList.addLast((E) temp.data);
                temp = temp.next;
            }
            return returnMylinkedList;
        }
    }

    // kiểm tra phần tử có tồn tại trong danh sách không .
    public boolean constrains(E element) {
        Node temp = head;
        for (int i = 0; i < numNodes && temp.next != null; i++) {
            if (temp.data.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
//trả về vị trí của element
    public int indexOf(E element) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(element)) {
                return i;
            }
        }
        return -1;
    }
}
