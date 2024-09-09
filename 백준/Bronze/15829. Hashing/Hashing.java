import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int L = sc.nextInt();
    String str = sc.next();

    int r = 31;
    int M = 1234567891;
    long answer = 0;
    long rPow = 1;

    // 모듈러 연산의 분배 법칙을 아는지 확인하는 문제 
    // (a * b) % M = ((a % M) * (b % M)) % M
    for (int i = 0; i < str.length(); i++) {
      int ch = str.charAt(i) - 'a' + 1;
      answer = (answer + ch * rPow) % M;
      rPow = (rPow * r) % M;
    }

    System.out.println(answer);
  }
}