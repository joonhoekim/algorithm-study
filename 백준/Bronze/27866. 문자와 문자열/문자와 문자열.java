import java.util.Scanner;

public class Main {


  public static void main(String... args) {
    Scanner sc = new Scanner(System.in);
    String S = sc.nextLine();
    int i = sc.nextInt();

    System.out.print(S.charAt(i-1));




    sc.close();

  }
}