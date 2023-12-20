import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int numberOfCases = scanner.nextInt();
    int[] sumOfCases = new int[numberOfCases];
    for (int i = 0; i < numberOfCases; ++i) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      sumOfCases[i] = a + b;
    }

    for (int i = 0; i < numberOfCases; ++i) {
      System.out.println(sumOfCases[i]);
    }
  }


}
