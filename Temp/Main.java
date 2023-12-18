import java.io.InputStream;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("실행됨.");

    InputStream in = System.in;
    Scanner keyIn = new Scanner(in);

    double a = keyIn.nextDouble();
    double b = keyIn.nextDouble();

    System.out.println(a + b);
    System.out.println(a - b);
    System.out.println(a * b);
    System.out.println(a / b);
    System.out.println(a % b);

    keyIn.close();

  }

}
