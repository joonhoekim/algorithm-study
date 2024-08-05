package exhaustiveSearch.케이스별로나누기.겹침문제.전부겹치는선분2;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        /*
         * 분석
         * - 전부 겹치게 만들 수 있는지 판단하기
         * - 단, 선택해서 하나를 제거할 수 있음!
         * 설계
         * - 선분 시작, 끝점 크기가 커지더라도 대응가능하도록 대수적 방법을 사용
         *   - maxX1 > minX2 인 경우 전부 겹치지 않게 됨
         *   - 스위핑라인으로 풀어도 되는데, 선분의 크기가 커지면 공간/시간적으로 매우 불리해짐
         * - 최적으로 풀어내려면, maxX1 혹은 minX2를 갖는 선분을 지워야 하지만...
         * */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][2];
        final int X1 = 0;
        final int X2 = 1;

        for (int idx = 0; idx < n; idx++) {
            points[idx][X1] = sc.nextInt();
            points[idx][X2] = sc.nextInt();
        }

        boolean isIntersected = false;
        loop:
        for (int removedIdx = 0; removedIdx < n; removedIdx++) {
            int maxX1 = Integer.MIN_VALUE;
            int minX2 = Integer.MAX_VALUE;
            for (int idx = 0; idx < n; idx++) {

                if (removedIdx == idx) {
                    continue;
                }
                maxX1 = Math.max(maxX1,
                                 points[idx][X1]);
                minX2 = Math.min(minX2,
                                 points[idx][X2]);
            }
            //겹치는가?
            if (maxX1 <= minX2) {
                isIntersected = true;
                break loop;
            }
        }

        if (isIntersected) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }


    }
}