import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringBuilder sb = new StringBuilder();

    String[] s = br.readLine().split(" ");
    int squareSum = 0;
    for (int i = 0; i < 5; i++) {
      squareSum += Math.pow(Integer.parseInt(s[i]), 2);
    }
    System.out.println(squareSum % 10);

//    System.out.print(sb);
  }
}