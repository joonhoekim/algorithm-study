import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    //Scanner keyIn = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] strArr = br.readLine().split(" ");

    long a = 0;
    for (int i = 0; i < 3; ++i) {
      a += Long.parseLong(strArr[i]);
    }

    //a += Long.parseLong(br.readLine());
    System.out.print(a);

    br.close();
  }
}