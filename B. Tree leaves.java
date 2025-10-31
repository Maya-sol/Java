import java.util.*;
import java.io.*;

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

    void read(Scanner scan) {
        int num = scan.nextInt();
        while (num != 0) {
            node = insertWithRoot(node, num);
            num = scan.nextInt();
        }
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
        try {
            Scanner scanner = new Scanner(System.in);
            Tree tree = new Tree();
            tree.read(scanner);
            tree.print();
        } catch (Exception e) {
            System.err.println("Application failed: " + e.getMessage());
            System.exit(1);
        }

    }
}
