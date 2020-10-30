package java_collection_framework.baitap.Tree;

public class PostOrderBinaryTree {
    public static void main(String[] args) {
        BinaryTree<String> stringBinaryTree = new BinaryTree<>();
        stringBinaryTree.add("Adam");
        stringBinaryTree.add("Eve");
        stringBinaryTree.add("Susan");
        stringBinaryTree.add("Karik");
        stringBinaryTree.add("Smith");
        stringBinaryTree.add("Micheal");
        stringBinaryTree.showPostOrder();
    }
}
