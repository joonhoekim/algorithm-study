import java.io.InputStream;
import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    InputStream in = System.in;
    Scanner sc = new Scanner(in);
    int a = sc.nextInt();
    int b= sc.nextInt();
    System.out.print(a*b);
  }
}