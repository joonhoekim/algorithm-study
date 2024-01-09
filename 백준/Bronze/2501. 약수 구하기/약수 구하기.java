import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    int N = Integer.parseInt(inputs[0]);
    int K = Integer.parseInt(inputs[1]);
    int[] divisors = new int[10000];
    int cursor = 0;

    for (int i = 1; i <= N; i++) {
      if (N % i == 0) {
        divisors[cursor++] = i;
      }
    }

    System.out.println(divisors[K - 1]);

  }
}