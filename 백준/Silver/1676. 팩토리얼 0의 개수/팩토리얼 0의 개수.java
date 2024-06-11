import java.util.LinkedList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    //int 는 12!, long은 20! 까지.
    //500!을 직접 계산하는 것은 불가능. 곱해지는 수를 소인수분해해서 2, 5 조합이 몇 개인지 카운트하면 될 듯.
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int twoCount = 0;
    int fiveCount = 0;
    for (int i = 1; i <= N; i++) {
      for(int j : primeFactorization(i)) {
        if(j == 2) {twoCount++;}
        if(j == 5) {fiveCount++;}
      }
    }

    System.out.println(Math.min(twoCount, fiveCount));
  }

  static LinkedList<Integer> primeFactorization(int n) {
    LinkedList<Integer> ans = new LinkedList<>();
    int quotient = n;
    while(quotient>1) {
      for(int i=2; i<=quotient; i++) {
        if(quotient%i==0) {
          quotient /= i;
          ans.add(i);
          break;
        }
      }
    }
    return ans;
  }
}