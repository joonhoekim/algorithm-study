import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int numberOfCase = Integer.parseInt(bufferedReader.readLine()) + 1;

    StringBuilder stringBuilder = new StringBuilder();
    StringTokenizer stringTokenizer;

    for (int i = 1; i < numberOfCase; ++i) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

      int a = Integer.parseInt(stringTokenizer.nextToken());
      int b = Integer.parseInt(stringTokenizer.nextToken());
      String c = "Case #" + i + ": " + a + " + " + b + " = " + (a + b) + "\n";
      stringBuilder.append(c);


    }

    System.out.print(stringBuilder);

  }
}



