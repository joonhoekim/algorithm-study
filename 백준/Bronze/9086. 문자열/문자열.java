import java.util.Scanner;

public class Main {


  public static void main(String... args) {
    Scanner sc = new Scanner(System.in);

    int N  = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < N; i++) {
      String input = sc.nextLine();
      String first = String.valueOf(input.charAt(0));
      String last = String.valueOf(input.charAt(input.length()-1));
      System.out.println(first+last);
    }
  }
}