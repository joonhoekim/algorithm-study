package intermediateLow.simulation.격자안에서밀고당기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어벨트 {
    public static void main(String[] args) throws IOException {

        /*
         * 컨베이어벨트가 원형이고, 시계방향으로 회전한다.
         * 이것이 2*n 의 이차원 공간으로 정의된다.
         * 1초에 한칸씩 회전한다.
         * 초기상태와 t초가 주어지니, 회전이 종료된 시점을 출력하라.
         * 그리고 밑에줄은 뒤집어서 주어진다.
         *
         * 생각
         * 자료구조를 배열을 쓰는게 좋은가?
         * 매번 모든 걸 새로 덮어씌울 필요 없이
         * t초 만큼 위치를 증가시킨다음에 컨베이어벨트 길이로 모듈러 계산하면
         * 시뮬레이션 없이 결정적으로 풀 수 있을 것이다.
         * 배우는거니까 시뮬레이션 먼저 구현해보자
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        final int rowSize = 2;
        int[][] cv = new int[rowSize][n];


        st = new StringTokenizer(br.readLine());
        for (int c = 0; c < n; c++) {
            cv[0][c] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int c = n - 1; c >= 0; c--) {
            cv[1][c] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < t; i++) {

            int topLeft = cv[0][0];
            int topRight = cv[0][n - 1];
            int bottomleft = cv[1][0];
            int bottomright = cv[1][n - 1];

            for (int j = n - 1; j > 0; j--) {
                cv[0][j] = cv[0][j - 1];
            }
            for (int j = 0; j < n - 1; j++) {
                cv[1][j] = cv[1][j + 1];
            }
            cv[0][0] = bottomleft;
            cv[1][n - 1] = topRight;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            sb.append(cv[0][j]).append(" ");
        }
        sb.append("\n");
        for (int j = 0; j < n; j++) {
            sb.append(cv[1][n - 1 - j]).append(" ");
        }

        System.out.println(sb);
    }
}
