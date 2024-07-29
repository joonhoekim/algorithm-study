package exhaustiveSearch.언덕깎기;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // - 언덕 높이가 0부터 100까지 존재할 수 있음
    // - 언덕 최대차이가 MAX_DIFF 이하여야 함
    // - 언덕 H만큼 깎거나 높일 때 비용은 H^2 가 든다

    Scanner sc = new Scanner(System.in);
    final int MAX_DIFF = 17;

    int n = sc.nextInt();
    int[] heightArr = new int[n];

    for (int i = 0; i < n; i++) {
      heightArr[i] = sc.nextInt();
    }

    // Greedy 하게 풀면 될 듯..
    // 일단 만족하는지 보고, 최하층들을 올릴 것인지, 최상층들을 내릴 것인지 더 저렴한 것으로 선택하기
    // 단 한 라인씩 처리할 것. 올리기+내리기 둘 다 필요할 것임

    int minHeight = Integer.MAX_VALUE;
    int maxHeight = Integer.MIN_VALUE;
    int countMin = 0;
    int countMax = 0;
    int[] workload = new int[n];

    do {
      //최고, 최저 높이 검사
      for (int i = 0; i < heightArr.length; i++) {
        minHeight = Math.min(minHeight, heightArr[i]);
        maxHeight = Math.max(maxHeight, heightArr[i]);
      }

      for (int i = 0; i < heightArr.length; i++) {
        if (heightArr[i] == minHeight) {
          countMin++;
        }
        if (heightArr[i] == maxHeight) {
          countMax++;
        }
      }

      //countMin, countMax 비교해서 올리기/내리기 선택

      //아... 이렇게는 풀수 없구나
      //가격이 비선형적으로 증가하므로, 완전탐색을 돌려야 함...
      //지금 방법으로는, 1개 언덕만 엄청 높게 튀어나와있다고 가정할 때
      //오히려 다른 언덕들을 높여주는게 비용상 더 이득이 될 수 있음
      //결국 MaxDiff 안으로 들어오게 만드는 결과를 가정해놓고, 올리기/내리기 완전탐색해보고 비용 최소값 구해야함

    } while (maxHeight - minHeight > MAX_DIFF);


  }

  static boolean isInMaxDiff(int[] heightArr, int diff) {
    int minHeight = Integer.MAX_VALUE;
    int maxHeight = Integer.MIN_VALUE;

    for (int i = 0; i < heightArr.length; i++) {
      minHeight = Math.min(minHeight, heightArr[i]);
      maxHeight = Math.max(maxHeight, heightArr[i]);
    }

    return maxHeight - minHeight <= diff;
  }
}
