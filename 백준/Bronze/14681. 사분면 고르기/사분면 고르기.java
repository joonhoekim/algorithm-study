import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
    int y = scanner.nextInt();

    checkQuadrant(x, y);


  }

  private static void checkQuadrant(int x, int y) {

    boolean horizontal;
    boolean vertical;
    if (x > 0) {
      horizontal = true;
    } else {
      horizontal = false;
    }
    if (y > 0) {
      vertical = true;
    } else {
      vertical = false;
    }

    if (vertical && horizontal) {
      System.out.print(1);
    } else if (!(vertical || horizontal)) {
      System.out.print(3);
    } else if (!horizontal) {
      System.out.print(2);
    } else {
      System.out.print(4);
    }
  }

}
