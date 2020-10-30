package java_collection_framework.baitap.Tree;


public class BinaryRemoveTree<E extends Comparable<E>> extends BinaryTree {
    private Node removeNode;
    private Node nodeE;

    public void remove(E e) {
        if (super.root==null) {
            System.out.println("Empty tree");
            return;
        }
        nodeE = super.root;
        checkE(e,super.root);
        if (nodeE.getElement().equals(e)) {
            if (nodeE.getLeft()!=null)
            {
                removeNode = nodeE.getLeft();
                checkTreeLeft(e,nodeE.getLeft());
            }
            else if (nodeE.getLeft()==null&&nodeE.getRight()!=null)
            {
                removeNode = nodeE.getRight();
                checkTreeRight(e,nodeE.getRight());
            } else if (nodeE.getLeft()==null&&nodeE.getRight()==null) {
                nodeE = null;
            }
            nodeE.setElement(removeNode.getElement());
            removeNode = null;
        }
//        ---------------------------------
    }

    private void checkE(E e,Node root) {
        if (root.getElement().equals(e)) {
            nodeE = root;
        }
        if (root==null) {
            return;
        }
        if (root.getLeft()!=null) {
            checkE(e,root.getLeft());
        }
        if (root.getRight()!=null) {
            checkE(e,root.getRight());
        }
    }

    private void checkTreeRight(E e, Node root) {
        if (root==null) {
            return;
        }
        if (root.getLeft()!=null) {
            if (removeNode.getElement().compareTo(root.getElement())<0) {
                removeNode = root;
            }
            checkTreeLeft(e,root.getLeft());
        }
        if (root.getRight()!=null) {
            if (removeNode.getElement().compareTo(root.getElement())<0) {
                removeNode = root;
            }
            checkTreeLeft(e,root.getRight());
        }
    }

    private void checkTreeLeft(E e,Node root) {
        if (root==null) {
            return;
        }
        if (root.getLeft()!=null) {
            if (removeNode.getElement().compareTo(root.getElement())>0) {
                removeNode = root;
            }
            checkTreeLeft(e,root.getLeft());
        }
        if(root==nodeE) {
            return;
        }
        if (root.getRight()!=null) {
            if (removeNode.getElement().compareTo(root.getElement())>0) {
                removeNode = root;
            }
            checkTreeLeft(e,root.getRight());
        }
    }
}
