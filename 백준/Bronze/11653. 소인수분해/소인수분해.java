import java.util.LinkedList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if(n==1) return;


    for(int i : primeFactorization(n)) {
      System.out.println(i);
    }

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