package intermediateLow.K개중하나를N번선택하기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class k개중에1개를n번뽑기 {
  static Scanner sc = new Scanner(System.in);
  static List<Integer> answer = new LinkedList<Integer>();
  static int maxValue;
  static int maxDigit;

  static void choose(int currDigit) {
    if(currDigit==0) {
      print();
      return;
    }

    for (int i = 1; i <= maxValue; i++) {
      answer.add(i);
      choose(currDigit-1);
      answer.remove(answer.size() - 1);
    }

  }

  static void print() {
    StringBuilder sb = new StringBuilder();
    for (Integer integer : answer) {
      sb.append(integer).append(" ");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) {
    int k = sc.nextInt();
    int n = sc.nextInt();
    maxValue = k;
    maxDigit = n;

    choose(maxDigit);



  }
}
