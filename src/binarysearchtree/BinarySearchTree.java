package binarysearchtree;
public class BinarySearchTree {
    class Node {
        int key;
        int count;
        Node left, right;

        public Node(int key) {
            this.key = key;
            this.left = this.right = null;
        }
    }
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Phương thức tìm phần tử nhỏ nhất
    public int findMin() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.key;
    }

    // Phương thức tìm kiếm
    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.key) {
            return true;
        } else if (key < root.key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    // Phương thức thêm phần tử
    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (root.key == key) {
            root.count++;
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    // Phương thức xóa phần tử
    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            // Node với một hoặc không có child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node với hai children: lấy phần tử nhỏ nhất từ cây con phải (cây con lớn hơn)
            root.key = minValue(root.right);

            // Xóa phần tử nhỏ nhất từ cây con phải
            root.right = delete(root.right, root.key);
        }

        return root;
    }

    // Phương thức tìm giá trị nhỏ nhất trong cây con
    private int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

}

