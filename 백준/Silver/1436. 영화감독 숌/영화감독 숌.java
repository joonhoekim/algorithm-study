import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int i = 666;
    int count = 0;
    while(true) {
      if(String.valueOf(i).contains("666")) {
        count++;
        if(count == n) {
          System.out.println(i);
          return;
        }
      };
      i++;
    }

  }

}