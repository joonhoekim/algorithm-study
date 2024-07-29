package exhaustiveSearch.이상한폭탄3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Optimized {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 입력 받기
    int countBombs = sc.nextInt(); // 폭탄의 개수
    int explosiveDistance = sc.nextInt(); // 폭발 거리

    int[] bombsNumArr = new int[countBombs];
    for (int i = 0; i < countBombs; i++) {
      bombsNumArr[i] = sc.nextInt();
    }

    // 폭탄 번호별 폭발 횟수를 저장할 Map
    Map<Integer, Integer> explosionCounts = new HashMap<>();

    // 폭탄 배열 순회
    for (int i = 0; i < countBombs; i++) {
      int currentBombNum = bombsNumArr[i];

      // 현재 폭탄의 다음 위치부터 탐색
      for (int j = i + 1; j < countBombs; j++) {
        // 동일한 번호의 폭탄을 찾았을 때
        if (bombsNumArr[j] == currentBombNum) {
          // 폭발 거리 이내인지 확인
          if (j - i <= explosiveDistance) {
            // 폭발 횟수 증가
            explosionCounts.put(currentBombNum, explosionCounts.getOrDefault(currentBombNum, 0) + 2);
          }
          break; // 가장 가까운 동일 번호 폭탄만 고려
        }
      }
    }

    // 가장 많이 폭발한 폭탄 번호 찾기
    int maxExplosions = 0;
    int maxBombNumber = 0;

    for (Map.Entry<Integer, Integer> entry : explosionCounts.entrySet()) {
      int bombNumber = entry.getKey();
      int explosions = entry.getValue();

      if (explosions > maxExplosions || (explosions == maxExplosions && bombNumber > maxBombNumber)) {
        maxExplosions = explosions;
        maxBombNumber = bombNumber;
      }
    }

    // 결과 출력
    System.out.println(maxBombNumber);
  }
}