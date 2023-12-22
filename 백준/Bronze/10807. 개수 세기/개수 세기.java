import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer;
    StringBuilder stringBuilder = new StringBuilder();

    int T = Integer.parseInt(bufferedReader.readLine());
    String str = bufferedReader.readLine();
    int v = Integer.parseInt(bufferedReader.readLine());

    int count = 0;

    stringTokenizer = new StringTokenizer(str, " ");
    while (stringTokenizer.hasMoreTokens()) {
      if (Integer.parseInt(stringTokenizer.nextToken()) == v) {
        ++count;
      }
    }

    System.out.print(count);


  }
}