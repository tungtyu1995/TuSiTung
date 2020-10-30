package dsa_stack_queue.baitap;


import java.util.Scanner;

public class StackReverse<E> {
    private E[] elements;
    public static final int INITIAL_SIZE = 10;
    private int size = 0;

    public StackReverse() {
        elements = (E[]) new Object[INITIAL_SIZE];
    }
    public void push(E e){
        ensureCapacity();
        elements[size++]=e;
    }
    public E pop(){
        if(size==0){
            throw  new IndexOutOfBoundsException("is empty");
        }
        E e =elements[size-1];
        elements[size-1]=null;
        size--;
        return e;
    }
    public void ensureCapacity(){
        if(size>=elements.length){
            E[] newElements=(E[]) new Object[elements.length*2+1];
            System.arraycopy(elements,0,newElements,0,size);
            elements=newElements;
        }
    }
    public boolean isEmpty(){
        boolean check=false;
        if(size==0){
            return true;
        }else
            return false;
    }

    public static void main(String[] args) {
        StackReverse<Integer> stack=new StackReverse<>();

        int[] arr={1,2,3,4};

        // đưa phần tử vào mảng vào stack thông qua push
        for (int i = 0; i <arr.length ; i++) {
            stack.push(arr[i]);
        }
        // lấy ra phần tử trong stack trong mảng đầu
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=stack.pop();
        }
        System.out.println("dao so:");
        for (int x:arr
        ) {
            System.out.println(x);
        }
        System.out.print("nhap vao chuoi can dao nguoc:");
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        String[] words = inputText.split(" ");
        System.out.println("dao nguoc chuoi:");
        StackReverse<String> wStack= new StackReverse<>();

        for (int i = 0; i < inputText.length() ; i++) {
            wStack.push(words[i]);
        }
        for (int i = 0; i < words.length ; i++) {
            words[i] = wStack.pop();
        }
        for (String x:words
        ) {
            System.out.print(x+" ");
        }
    }

}
