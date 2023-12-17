import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner keyIn = new Scanner(System.in);
    int a = keyIn.nextInt();
    int b = keyIn.nextInt();
    int c = keyIn.nextInt();

    System.out.println((a + b) % c);
    System.out.println(((a % c) + (b % c)) % c);
    System.out.println((a * b) % c);
    System.out.println(((a % c) * (b % c)) % c);


  }
}