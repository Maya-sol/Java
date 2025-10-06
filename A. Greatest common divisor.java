import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt(), num2 = scanner.nextInt(), result = 1;
        if (num1 > num2) {
            while (result != 0) {
                result = num1 % num2;
                num1 = num2;
                num2 = result;
            }
            System.out.println(num1);
        } else {
            while (result != 0) {
                result = num2 % num1;
                num2 = num1;
                num1 = result;
            }
            System.out.println(num2);
        }

    }
}
