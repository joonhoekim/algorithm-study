import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    String[] strArr = str.split(" ");

    int a = Integer.parseInt(strArr[0]);
    //int b = Integer.parseInt(strArr[1]);

    if (a >= 90) {
      System.out.println("A");
    } else if (a >= 80) {
      System.out.println("B");
    } else if (a >= 70) {
      System.out.println("C");
    } else if (a >= 60) {
      System.out.println("D");
    } else {
      System.out.println("F");
    }

    br.close();

  }
}