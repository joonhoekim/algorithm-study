import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] strings = br.readLine().split(" ");
    int count = strings.length;
    for (int i = 0; i < strings.length; i++) {
      if (strings[i] == "") {
        count--;
      }
    }
    System.out.println(count);
  }
}