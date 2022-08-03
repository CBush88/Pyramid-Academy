import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter an integer to reverse");
        Scanner scanner = new Scanner(System.in);
        int theInt = scanner.nextInt();
        System.out.println(reverseInteger(theInt));
    }
    public static int reverseInteger(int num){
        int result = 0;
        int digit;
        while(num != 0){
            digit = num % 10;
            result = result * 10 + digit;
            num /= 10;
        }

        return result;
    }
}