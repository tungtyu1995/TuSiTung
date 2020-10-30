package java_collection_framework.baitap.Tree;

public interface Tree<E> {
    //    Them phan tu vao tree
    boolean add(E e);
    //    In phan tu trong tree
    void showPostOrder();
    //    kich thuoc tree
    int size();
}
