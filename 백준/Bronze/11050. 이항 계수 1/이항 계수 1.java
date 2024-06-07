import java.util.Scanner;

//이항계수 = combination
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(combination(n, r));
    }

    public static int combination(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n-r));
    }

    private static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}