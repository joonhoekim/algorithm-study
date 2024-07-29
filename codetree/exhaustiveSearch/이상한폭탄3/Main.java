package exhaustiveSearch.이상한폭탄3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//가장 많이 터진 폭탄 번호 출력, (동등 개수의 번호가 있는 경우 큰 번호 출력, 아무것도 안 터진 경우 0 출력)
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //폭탄개수
    int bombCount = sc.nextInt();
    //동일 숫자 폭탄이 이 거리 안에 있으면 폭발함 (폭발은 옆의 폭탄에 영향을 미치지 않음)
    int explosiveDistance = sc.nextInt();

    //폭탄 정보를 배열에 저장
    int[] bombsNumArr = new int[bombCount];
    for (int i = 0; i < bombCount; i++) {
      bombsNumArr[i] = sc.nextInt();
    }

    //폭탄의 번호는 1밀리언까지 올라가므로 번호에 대해 탐색하지 말고 폭탄 배열에 대해서 나오는 번호만 탐색하자.
    //맵을 쓰자. 키가 폭탄 넘버고, 값이 폭발 횟수인 맵으로 정의하자.
    //map은 put으로 추가하고, get으로 가져오고, containsKey로 키 존재여부 확인한다.
    Map<Integer, Integer> explosionCountByBombNumber = new HashMap<>();

    for (int i = 0; i < bombCount; i++) {
      int currentBombNum = bombsNumArr[i];

      for (int j = i + 1; j <= i + explosiveDistance && j < bombCount; j++) {
        if (bombsNumArr[j] == currentBombNum) {
          //기본값이 1인 이유는, 폭발이 처음 일어나면 2개로 카운트하는게 맞기 때문
          explosionCountByBombNumber.put(currentBombNum, explosionCountByBombNumber.getOrDefault(currentBombNum, 1) + 1);

          //explosive Distance 안에서 폭발 확인되면 currentBombNum 갱신하러 넘김
          break;
        }
      }
    }

    //가장 많이 폭발한 폭탄 번호를 map을 순회하면서 찾는다.
    int maxExplosions = 0;
    int maxBombNumber = 0;

    for (Map.Entry<Integer, Integer> entry : explosionCountByBombNumber.entrySet()) {
      int bombNumber = entry.getKey();
      int explosionCount = entry.getValue();

      if (explosionCount >= maxExplosions) {
        maxExplosions = explosionCount;

        if (bombNumber > maxBombNumber) {
          maxBombNumber = bombNumber;
        }
      }
    }

    System.out.println(maxBombNumber);

  }
}