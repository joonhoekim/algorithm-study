package intermediateLow.simulation.격자안에서완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행복한연속수열의개수 {

    /*
     * row or column 에서 연속된 숫자가 m개 이상인 경우 count 해서 출력하면 된다.
     *
     * 중복 체크에서 연속 조건이 없다면 HashMap을 사용하는 것이 좋을 것이다.
     * 연속 조건이 있다면, 슬라이딩 윈도우 혹은 투포인트를 적용하면 될 것이다.
     * 이 경우는 구간 길이가 정해져있으므로 슬라이딩 윈도우를 쓰면 되는데
     * 커서 하나 두고 풀어도 된다. (이쪽이 더 효율적이다)
     *
     * 커서를 두고, 커서의 값과 다음 원소의 값이 같을 때 카운트를 증가시킨다.
     * 다음 원소의 값이 다르다면, 커서를 옮기고 카운트를 1으로 초기화한다.
     * 단 m=0 또는 1일수 있으므로 에지에 주의해야 한다.
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //격자 크기
        int n = Integer.parseInt(st.nextToken());

        //중복 개수의 요구 기준
        int m = Integer.parseInt(st.nextToken());

        //에지 처리
        if (m == 0 || m == 1) {
            System.out.println(2 * n);
            br.close();
            return;
        }

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int satisfied = 0;


        loop:
        for (int rowIdx = 0; rowIdx < n; rowIdx++) {
            int cursor = arr[rowIdx][0];
            int count = 1;

            for (int j = 1; j < n; j++) {

                if (cursor == arr[rowIdx][j]) {
                    count++;
                } else {
                    cursor = arr[rowIdx][j];
                    count = 1;
                }

                if (count >= m) {
                    satisfied++;
                    continue loop;
                }

            }
        }


        loop:
        for (int columnIdx = 0; columnIdx < n; columnIdx++) {
            int cursor = arr[0][columnIdx];
            int count = 1;

            for (int j = 1; j < n; j++) {

                if (cursor == arr[j][columnIdx]) {
                    count++;
                } else {
                    cursor = arr[j][columnIdx];
                    count = 1;
                }

                if (count >= m) {
                    satisfied++;
                    continue loop;
                }

            }
        }

        System.out.println(satisfied);
        br.close();
    }
}
