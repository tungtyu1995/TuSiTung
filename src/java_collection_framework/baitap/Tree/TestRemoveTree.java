package java_collection_framework.baitap.Tree;

public class TestRemoveTree {
    public static void main(String[] args) {
        BinaryTree<String> stringBinaryTree = new BinaryRemoveTree<>();
        stringBinaryTree.add("Adam");
        stringBinaryTree.add("Eve");
        stringBinaryTree.add("Susan");
        stringBinaryTree.add("Karik");
        stringBinaryTree.add("Smith");
        stringBinaryTree.add("Micheal");
        ((BinaryRemoveTree)stringBinaryTree).remove("Karik");
        stringBinaryTree.showPostOrder();
    }
}
