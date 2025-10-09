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

}


public class Main {
    public static void main(String[] args) throws IOException {
        MaxStack stack = new MaxStack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int lines = Integer.parseInt(br.readLine());
        String command;
        int num;
        for (int i = 0; i < lines; i++) {
            String[] request = br.readLine().split(" ");
            command = request[0];
            if (command.equals("push")) {
                num = Integer.parseInt(request[1]);
                stack.push(num);
            } else if (command.equals("pop")) {
                stack.pop();
            } else {
                pw.println(stack.maximum());
            }
        }
        pw.flush();
        pw.close();
        br.close();
    }

}
