package exhaustiveSearch.케이스별로나누기.겹침문제.두선분;

import java.util.Scanner;

public class 수평선배열두고지나가는경우기록하는방법 {

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

        //선분이 존재를 1개씩 더하는 수평선을 표현한 배열
        final int MAX_NUM = 100;
        int[] arr = new int[MAX_NUM + 1];

        for (int i = 0; i < POINTS_COUNT; i++) {
            //start
            points[i][0] = sc.nextInt();
            //end
            points[i][1] = sc.nextInt();

            for (int j = points[i][0]; j <= points[i][1]; j++) {
                arr[j]++;
            }
        }

        boolean isSatisfied = false;
        for (int i = 1; i < MAX_NUM; i++) {
            if (arr[i] > 1) {
                isSatisfied = true;
                break;
            }
        }
        if (isSatisfied) {
            System.out.println("intersecting");
        } else {
            System.out.println("nonintersecting");
        }


    }

}
