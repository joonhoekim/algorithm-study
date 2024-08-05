package exhaustiveSearch.케이스별로나누기.겹침문제.두선분;

import java.util.Scanner;

public class 자기제외다른선분내부포함여부를완전탄색 {

    public static void main(String[] args) {
        //여러 선분이 주어졌을 때, 겹치는 경우를 완전탐색으로 풀어내는 유형
        /*
         * 분석
         * - 선분의 겹침
         * 설계
         * - 모든 점이 '자기 제외 다른 선분'의 내부에 포함되는지 완전탐색하는 방식
         *   - O(n^2) (n개 원소 * n-1개 선분)
         * - 수평선을 배열로 두고, 선분이 지나가는 경우 원소에 해당 기록을 남기는 방식
         *   - O(n^2) ?
         * */

        //일단 작성해보자

        Scanner sc = new Scanner(System.in);

        //start, end 구분
        final int POINTS_COUNT = 2;
        int[][] points = new int[POINTS_COUNT][2];

        for (int i = 0; i < POINTS_COUNT; i++) {
            //start
            points[i][0] = sc.nextInt();
            //end
            points[i][1] = sc.nextInt();

        }

        boolean isSatisfied = false;
        loop:
        for (int i = 0; i < POINTS_COUNT; i++) {
            for (int j = 0; j < POINTS_COUNT; j++) {
                //자기 자신은 제외
                if (i == j) {
                    continue;
                }

                //시작, 끝 점이 다른 선분 안에 있는지 확인
                for (int k = 0; k <= 1; k++) {
                    if (points[j][0] <= points[i][k] && points[i][k] <= points[j][1]) {
                        isSatisfied = true;
                        break loop;
                    }
                }


            }
        }

        if (isSatisfied) {
            System.out.println("intersecting");
        } else {
            System.out.println("nonintersecting");
        }


    }

}
