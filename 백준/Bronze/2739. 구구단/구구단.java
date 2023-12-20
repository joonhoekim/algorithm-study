import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int level = scanner.nextInt();
    gugudan(level);
  }

  private static void gugudan(int level) {
    for (int i = 1; i < 10; ++i) {
      System.out.printf("%d * %d = %d\n", level, i, level * i);
    }

  }


}
