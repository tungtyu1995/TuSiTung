package java_collection_framework.baitap.Tree;

public class BinaryTree<E extends Comparable<E>> extends AbstractTree<E> {
    protected class Node {
        private E element;
        private Node left;
        private Node right;

        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    protected Node root;
    private int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public boolean add(E e) {
        if (root == null) {
            root = new Node(e);
        } else {
            Node parent = null;
            Node current = root;
            while(current!=null) {
                if (e.compareTo(current.element)<0) {
                    parent = current;
                    current = current.left;
                } else if(e.compareTo(current.element)>0) {
                    parent = current;
                    current = current.right;
                } else return false;
            }
//            --------------------------------
            if (e.compareTo(parent.element)<0) {
                parent.left = new Node(e);
            } else if (e.compareTo(parent.element)>0) {
                parent.right = new Node(e);
            }
        }
        this.size++;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void showPostOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if (root==null) {
            return;
        }
        if (root.left!=null) {
            postOrder(root.left);
        }
        if (root.element!=null) {
            System.out.println(root.element);
        }
        if (root.right!=null) {
            postOrder(root.right);
        }
    }

    protected void checkRemove(Node root, Node nodeE, Node nodeE1) {
    }
}
