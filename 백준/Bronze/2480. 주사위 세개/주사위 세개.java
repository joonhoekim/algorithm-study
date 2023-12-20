import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    //배열이 더 간단함... 원래는 int 변수 3개 만들었는데 왜 이러나 싶어서 배열로 바꿨음!
    int[] diceNumber = new int[3];
    for (int i = 0; i < 3; ++i) {
      diceNumber[i] = scanner.nextInt();
    }
    testLuck(diceNumber);

  }

  private static void testLuck(int[] diceNumber) {
    int isTriple = 0;
    int isOnePair = 0;
    int isHigh = 0;

    //isTriple?
    if (diceNumber[0] == diceNumber[1] && diceNumber[0] == diceNumber[2]) {
      isTriple = diceNumber[0];
      System.out.print(10000 + isTriple * 1000);
      return;
    }

    //isOnePair?
    //왼쪽 끝에서 하나씩 오른쪽 끝과 비교해보자..
    for (int i = 0; i < diceNumber.length; ++i) {
      for (int j = diceNumber.length - 1; j > i; --j) {
        if (diceNumber[i] == diceNumber[j]) {
          isOnePair = diceNumber[i];
          System.out.print(1000 + isOnePair * 100);
          return;
        }
      }
    }

    //isHigh?
    isHigh = diceNumber[0];
    for (int i = 1; i < 3; ++i) {
      if (isHigh < diceNumber[i]) {
        isHigh = diceNumber[i];
      }
    }
    System.out.print(isHigh * 100);
  }


}
