import java.util.*;
import java.io.*;

class MaxStack {
    private Stack<Integer> main;
    private Stack<Integer> max;

    MaxStack() {
        main = new Stack<Integer>();
        max = new Stack<Integer>();
    }

    void push(int number) {
        main.push(number);
        if (max.isEmpty() || number >= max.peek()) {
            max.push(number);
        } else {
            max.push(max.peek());
        }
    }

    void pop() {
        max.pop();
        main.pop();
    }

    int maximum() {
        return max.peek();
    }

    void ChooseStackOeration() {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter printer = new PrintWriter(System.out);
            int lines = Integer.parseInt(buffer.readLine());
            String command;
            int num;

            for (int i = 0; i < lines; ++i) {
                String[] request = buffer.readLine().split(" ");
                command = request[0];
                if (command.equals("push")) {
                    num = Integer.parseInt(request[1]);
                    this.push(num);
                } else if (command.equals("pop")) {
                    this.pop();
                } else {
                    printer.println(this.maximum());
                }
            }

            printer.flush();
            printer.close();
            buffer.close();

        } catch (Exception e) {
            System.err.println("Application failed: " + e.getMessage());
            System.exit(1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            MaxStack stack = new MaxStack();
            stack.ChooseStackOeration();
        } catch (Exception e) {
            System.err.println("Application failed: " + e.getMessage());
            System.exit(1);
        }
    }
}
