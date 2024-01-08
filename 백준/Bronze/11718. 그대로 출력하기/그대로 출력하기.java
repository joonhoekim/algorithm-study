import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    // Please write your code here.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    while( (input=br.readLine()) != null && !input.isEmpty()) {
      System.out.println(input);
    }

  }
}