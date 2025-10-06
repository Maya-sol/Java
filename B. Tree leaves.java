import java.util.Scanner;

class Node {
    int number;
    Node left, right;

    public Node(int num) {
        number = num;
        left = null;
        right = null;
    }
}

class Tree {
    private Node node;

    Tree() {
        node = null;
    }

    void insert(int data) {
        node = insertWithRoot(node, data);
    }

    Node insertWithRoot(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.number < data) {
            root.right = insertWithRoot(root.right, data);
        }
        if (root.number > data) {
            root.left = insertWithRoot(root.left, data);
        }
        return root;
    }

    void print() {
        printWithRoot(node);
    }

    void printWithRoot(Node root) {
        if (root != null) {
            printWithRoot(root.left);
            if (root.left == null && root.right == null) {
                System.out.print(root.number + " ");
            }
            printWithRoot(root.right);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tree tree = new Tree();
        int num = scanner.nextInt();
        while (num != 0) {
            tree.insert(num);
            num = scanner.nextInt();
        }
        tree.print();
    }

}
