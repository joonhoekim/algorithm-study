import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner keyIn = new Scanner(System.in);
    int a = keyIn.nextInt();
    int b = keyIn.nextInt();
    int one = b % 10;
    int ten = (b % 100 - one) / 10;
    int hundred = (b - (ten + one)) / 100;

    System.out.println(a * one);
    System.out.println(a * ten);
    System.out.println(a * hundred);
    System.out.println(a * b);


  }
}