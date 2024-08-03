package 좋은전략을추려내기.독서실의거리두기2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 완전탐색 {

    public static void main(String[] args) {
        /*
         * 완전탐색으로도 다시한번 풀어보자
         * 왜냐면, 완전탐색은 시간 안에 못 풀 가능성이 있더라도
         * 일단 코드를 짜기는 더 쉽기 때문에...
         * */

        Scanner sc = new Scanner(System.in);
        int minSeatNum = 0;
        int maxSeatNum = sc.nextInt() - 1;
        String input = sc.next();

        int globalMaxDiffLeast = 0;

        //모든 시트에 대해 넣어보고 최솟값 구해볼거임
        for (int insertSeatNum = minSeatNum; insertSeatNum <= maxSeatNum; insertSeatNum++) {

            //이미 앉아있는 경우는 제외하고 탐색함
            if (input.charAt(insertSeatNum) == '1') {
                continue;
            }

            List<Integer> list = new ArrayList<>();
            //앉은 사람들 번호와 탐색하는 번호를 리스트에 넣는다.
            for (int i = minSeatNum; i < maxSeatNum; i++) {
                if (input.charAt(i) == '1' || i == insertSeatNum) {
                    list.add(i);
                }
            }

            int localMinDiff = Integer.MAX_VALUE;
            //로컬 최솟값 구해봄
            if (list.size() != 1) {
                for (int i = 0; i < list.size() - 1; i++) {
                    int localDiff = list.get(i + 1) - list.get(i);
                    localMinDiff = Math.min(localMinDiff,
                                            localDiff);
                }
            } else {
                if (list.get(0) * 2 > maxSeatNum) {
                    localMinDiff = list.get(0);
                } else {
                    localMinDiff = maxSeatNum - list.get(0);
                }

            }

            globalMaxDiffLeast = Math.max(globalMaxDiffLeast,
                                          localMinDiff);
        }

        System.out.println(globalMaxDiffLeast);
    }
}
