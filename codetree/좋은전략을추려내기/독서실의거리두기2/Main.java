package 좋은전략을추려내기.독서실의거리두기2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    /*
     * 2가 3보다 어렵고 늦게 나오는 문제군..
     *
     * 상황
     * - 독서실에 한명 더 받고 자리 배치할 것
     * - 원래 있던 사람들은 그대로 두어야 함
     * 이해
     * - 이전 문제랑 다른 점은 시작/끝에 사람이 있지 않을수도 있다는 것 하나뿐인가?
     * 분석
     * - 가장 가까운 간격만을 찾아서 중앙에 넣는 방식으로 풀 수 없다.
     * - 왜냐면 양 끝쪽에 공간이 크면 거기 넣는것도 답이 되기 때문에
     * 설계
     * - 한 명의 인원을 넣는 상황을 완전탐색으로 풀어내면 될 듯
     * - 근데 굳이 문자열을 활용할 필요 없이 사람이 있는 자리번호만 활용하면 될 듯
     * - 이전에 풀었던 게 계속 활용되네.. 굳굳
     * */

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String input = sc.next();
    List<Integer> list = new ArrayList<>();

    //앉은 사람들 번호를 리스트에 넣는다.
    for (int i = 0; i < n; i++) {
      if (input.charAt(i) == '1') {
        list.add(i);
      }
    }

    //만약 한명밖에 없다면...
    if (list.size() == 1) {
      int ans = (n - 1) - list.get(0) > list.get(0) ? n - 1 - list.get(0) : list.get(0);
      System.out.println(ans);
      return;
    }

    //앉은 사람들 사이에서 최대 거리랑 그 가운데 번호를 구한다.
    int maxDiff = 0;
    int insertIdx = -1;
    int startIdx = -1;
    int endIdx = -1;
    for (int i = 0; i < list.size() - 1; i++) {
      int localDiff = list.get(i + 1) - list.get(i);
      if (maxDiff < localDiff) {
        maxDiff = localDiff;
        startIdx = list.get(i);
        endIdx = list.get(i + 1);
      }
    }

    int leftGap = list.get(0);
    int rightGap = (n - 1) - list.get(list.size() - 1);

    // 양 끝쪽에 넣어야 하는 상황인지 확인해본다.
    if (leftGap * 2 > maxDiff) {
      insertIdx = 0;
      list.add(insertIdx);
    } else if (rightGap * 2 > maxDiff) {
      insertIdx = n - 1;
      list.add(insertIdx);
    }
    // 아니면 중앙에 넣어준다.
    else {
      list.add((startIdx + endIdx) / 2);
    }

    list.sort(null);

    //최소 간격을 찾는다.

    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < list.size() - 1; i++) {
      int localDiff = list.get(i + 1) - list.get(i);
      if (minDiff > localDiff) {
        minDiff = localDiff;
      }
    }

    System.out.println(minDiff);


  }
}
