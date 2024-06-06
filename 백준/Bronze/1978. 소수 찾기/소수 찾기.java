import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if (isPrime(input))
                count++;

        }
        System.out.println(count);
    }

    private static boolean isPrime(int i) {
        if (i==1) return false;

        for (int divisor = 2; divisor < i; divisor++) {
            if (i % divisor == 0) return false;
        }
        return true;
    }
}