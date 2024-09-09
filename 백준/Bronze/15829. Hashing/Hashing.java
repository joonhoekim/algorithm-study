import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int L = sc.nextInt();
    String str = sc.next();

    int r = 31;
    int M = 1234567891;
    //answer = hash value
    int answer = 0;
    for (int i = 0; i < str.length(); i++) {
      //a=1 ... z=26
      int ch = str.charAt(i)-'a'+1;
      answer += (int) ch * Math.pow(r, i);
    }

    System.out.println(answer);

  }
}