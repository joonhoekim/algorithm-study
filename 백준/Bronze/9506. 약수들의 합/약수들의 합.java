import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n;

    while ((n = Integer.parseInt(br.readLine())) != -1) {
      int[] divisors = new int[100000];
      int cursor = 0;
      int sum = 0;
      for (int i = 1; i <= n; i++) {
        if (n % i == 0 && n != i) {
          divisors[cursor++] = i;
        }
      }
      cursor = 0;
      while (divisors[cursor] != 0) {
        sum += divisors[cursor++];
      }
      if (sum == n) {
        System.out.print(n + " = ");
        cursor = 0;
        while (divisors[cursor] != 0) {
          System.out.print(divisors[cursor++]);
          if (divisors[cursor] != 0) {
            System.out.print(" + ");
          }
        }
        System.out.print("\n");
      } else {
        System.out.printf("%d is NOT perfect.\n", n);
      }
    }

  }
}