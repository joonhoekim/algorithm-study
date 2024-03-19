import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int side = (int) Math.pow(2, n);
    int total = (side + 1) * (side + 1);

    System.out.print(total);
  }
}