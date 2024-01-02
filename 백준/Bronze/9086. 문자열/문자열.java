import java.util.Scanner;

public class Main {


  public static void main(String... args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int N  = sc.nextInt();
    for (int i = 0; i < N; i++) {
      String input = sc.next();
      sb.append(input.charAt(0)).append(input.charAt(input.length()-1));
      System.out.println(String.valueOf(sb));
      sb.delete(0,2);
    }
  }
}