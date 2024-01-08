import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int B = Integer.parseInt(input[1]);

    StringBuilder sb = new StringBuilder();
    String zeroToZ = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    while (N / B < N) {
      sb.append(zeroToZ.charAt(N % B));
      N = N / B;
    }
    if (N != 0) {
      sb.append(zeroToZ.charAt(N));
    }
    System.out.println(sb.reverse());
  }
}