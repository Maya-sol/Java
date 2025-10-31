import java.util.*;
import java.io.*;

class GreatestCommonDivisor {

    int answer(int num1, int num2) {
        int result = 1;
        if (num1 > num2) {
            while (result != 0) {
                result = num1 % num2;
                num1 = num2;
                num2 = result;
            }
            return num1;
        } else {
            while (result != 0) {
                result = num2 % num1;
                num2 = num1;
                num1 = result;
            }
            return num2;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt(), num2 = scanner.nextInt();
        GreatestCommonDivisor result = new GreatestCommonDivisor();
        System.out.print(result.answer(num1, num2));

    }
}
