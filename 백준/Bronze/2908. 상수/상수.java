import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String[] inputs = br.readLine().split(" ");
    int[] ints = new int[inputs.length];
    for (int i = 0; i < inputs.length; i++) {
      ints[i] = Integer.valueOf(sb.append(inputs[i]).reverse().toString());
      sb.setLength(0);
    }

    System.out.print(Math.max(ints[0], ints[1]));

  }
}