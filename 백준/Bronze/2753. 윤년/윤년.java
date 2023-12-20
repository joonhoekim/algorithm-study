import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int inputYear = scanner.nextInt();
    if (isMultiple(inputYear, 4) && (!isMultiple(inputYear, 100) || isMultiple(inputYear, 400))) {
      System.out.println("1");
    } else {
      System.out.println("0");
    }


  }

  private static boolean isMultiple(int inputYear, int divisor) {
    if (inputYear % divisor == 0) {
      return true;
    } else {
      return false;
    }
  }

}
