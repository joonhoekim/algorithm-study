package exhaustiveSearch.케이스별로나누기.겹침문제.전부겹치는선분;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //여러 선분이 주어졌을 때, 겹치는 경우를 완전탐색으로 풀어내는 유형
        /*
         * 분석
         * - 선분의 겹침, '모두 겹치는지 확인 필요'
         * 설계
         * - 수평선을 배열로 두고, 선분이 지나가는 경우 원소에 해당 기록을 남기는 방식
         * */

        Scanner sc = new Scanner(System.in);

        //start, end 구분
        int n = sc.nextInt();
        int[][] points = new int[n][2];

        //선분이 존재를 1개씩 더하는 수평선을 표현한 배열
        final int MAX_NUM = 100;
        int[] arr = new int[MAX_NUM + 1];

        for (int i = 0; i < n; i++) {
            //start
            points[i][0] = sc.nextInt();
            //end
            points[i][1] = sc.nextInt();

            for (int j = points[i][0]; j <= points[i][1]; j++) {
                arr[j]++;
            }
        }

        boolean isSatisfied = false;
        for (int i = 1; i <= MAX_NUM; i++) {
            if (arr[i] == n) {
                isSatisfied = true;
                break;
            }
        }
        if (isSatisfied) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }


    }

}
