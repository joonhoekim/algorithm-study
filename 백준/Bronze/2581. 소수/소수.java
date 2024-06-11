import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int M = sc.nextInt();
    int N = sc.nextInt();
    int sum = 0;
    int min = 0;
    boolean isMinFound = false;
    for (int i = M; i <= N; i++) {
      if (isPrime(i)) {
        sum += i;
        if (!isMinFound) {
          min = i;
          isMinFound = true;
        }
      }
    }

    if (isMinFound) {
      System.out.println(sum);
      System.out.println(min);
    } else {
      System.out.println(-1);
    }

  }

  private static boolean isPrime(int i) {
    if (i == 1) {
      return false;
    }
    if (i == 2) {
      return true;
    }
    for (int j = 2; j < i; j++) {
      if (i % j == 0) {
        return false;
      }
    }
    return true;
  }


}