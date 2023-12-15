import java.io.InputStream;
import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    InputStream in = System.in;
    Scanner sc = new Scanner(in);

    //10E-9 정확도라 float는 실패..
    int a = sc.nextInt();
    int b= sc.nextInt();

    System.out.print((double) a / (double) b);
  }
}