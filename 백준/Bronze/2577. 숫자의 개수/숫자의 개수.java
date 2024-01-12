import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int product = 1;

    for (int i = 0; i < 3; i++) {
      product *= Integer.parseInt(br.readLine());
    }

    String stringProduct = String.valueOf(product);
    int[] counts = new int[10];
    for (int i = 0; i < stringProduct.length(); i++) {
      counts[stringProduct.charAt(i) - '0'] += 1;
    }

    for (int i = 0; i < counts.length; i++) {
      System.out.println(counts[i]);
    }

  }
}