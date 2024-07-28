package exhaustiveSearch.독서실의거리두기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int numberOfSeats = Integer.parseInt(br.readLine());
    String currentSeatStatus = br.readLine();

    //연속된 빈 공간의 길이와 위치를 저장한다음 정렬하는 방법도 있겠지만,
    //N명의 사람을 넣는 경우 넣고 나서도 또 자리할당이 가능하므로, 배치한 이후도 생각해야 한다.
    //그래서 모든 자리에 인원을 넣어보고, 발생하는 최대거리의 최소값을 갱신시키는 완전탐색 방법을 적용할 것
    //2명의 좌석을 배치하므로 2중 반복문이 필요하다.

    int globalMax = Integer.MIN_VALUE;
    for (int firstPersonIdx = 0; firstPersonIdx < currentSeatStatus.length(); firstPersonIdx++) {
      for (int secondPersonIdx = firstPersonIdx + 1; secondPersonIdx < currentSeatStatus.length(); secondPersonIdx++) {
        //기존 사람들하고 겹치는 자리는 배치가 불가능하므로 넘긴다.
        if (currentSeatStatus.charAt(firstPersonIdx) != '0' || currentSeatStatus.charAt(secondPersonIdx) != '0')
          continue;

        //새로운 String을 만들어서 두 사람을 넣어준다.
        StringBuilder renewedSeatStatus = new StringBuilder(currentSeatStatus);
        renewedSeatStatus.setCharAt(firstPersonIdx, '1');
        renewedSeatStatus.setCharAt(secondPersonIdx, '1');


        //로컬에서는 빈 공간의 거리 최솟값들을 구하는데, 글로벌로는 그 최솟값의 최대값을 구해본다.
        int localMinDist = Integer.MAX_VALUE;
        int currentPersonIdx = -1;
        int pastPersonIdx = -1;

        for (int idx = 0; idx < renewedSeatStatus.length(); idx++) {
          //사람을 만나면 다음 사람까지의 거리를 잰다.
          if (renewedSeatStatus.charAt(idx) == '1') {
            currentPersonIdx = idx;
            if (pastPersonIdx != -1) {
              //거리는 idx 차이로 문제에 정의되어 있음
              int currentDist = currentPersonIdx - pastPersonIdx;
              localMinDist = Math.min(localMinDist, currentDist);
            }
            pastPersonIdx = currentPersonIdx;
          }
        }

        globalMax = Math.max(globalMax, localMinDist);
      }


    }

    bw.write(String.valueOf(globalMax));
    bw.close();
    br.close();
  }
}
