package dsa_danh_sach.baitap;

import java.util.Arrays;

public class MyList<E> {

    private int size = 0;
    public static final int DEFAULT_CAPACITY = 10;

    Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {

        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacitys: " + capacity);
        }
    }

    //    phuong thuc tra ve so luong pha tu MyList
    public int size() {
        return this.size;
    }

    //    clear arraylist
    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }

    }

    //    add 1 phan tu vao cuoi mylist
    public boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapacity(5);
        }
        elements[size] = element;
        size++;
        return true;
    }

    //    tang kich thuoc mang
    private void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException(" minCapacity " + minCapacity);
        }

    }

    //    add 1 phan tu  vao vi tri index
    public void add(E element, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index" + index);
        } else if (elements.length == size) {
            this.ensureCapacity(5);
        }
        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    // truy xuat phan tu (elemen) tai vi tri (index)
    public E get(int index) {
        return (E) elements[index];
    }

    // dung indexof tra ve vi tri (index) cua phan tu
    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return index;
    }

//kiem tra phan tu E co ton tai trong mang

    public boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }
// tao ra mot ban sao cua MyList

    public MyList<E> clone() {
        MyList<E> myList = new MyList<>();
        myList.elements = Arrays.copyOf(this.elements, this.size);
        myList.size = this.size;
        return myList;
    }
//Xoa 1 phan tu theo index

    public E remove(int index) {
        if (index < 0 || index > elements.length) {
            throw new  IllegalArgumentException("index" + index);
        }
        E element = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return element;
    }
}