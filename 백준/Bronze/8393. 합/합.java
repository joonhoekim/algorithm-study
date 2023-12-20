import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int destination = scanner.nextInt();
    int sum = (int) (((double) 1 + destination) / 2 * destination);

    System.out.print(sum);

  }


}
