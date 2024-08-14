package intermediateLow.simulation.격자안에서완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최고의33위치 {

    public static void main(String[] args) throws Exception {
        /*
        * n*n 격자 내 3*3 잡을 수 있을 때 최대값 구하는 문제
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int windowSize = 3;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //simulation with sliding window

        int globalMax = 0;
        //1. 전체 격자 안에서 탐색을 하는데, 시작지점이 i, j 이다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                //2. 격자 안에 있는 슬라이딩 윈도우만 처리한다.
                if(i+windowSize-1 >= n || j+windowSize-1 >= n) continue;

                //3. 슬라이딩 윈도우 최댓값을 갱신한다.
                int sum = 0;
                for (int k = i; k < i+windowSize; k++) {
                    for (int l = j; l < j+windowSize; l++) {
                        if(arr[k][l] == 1) sum++;
                    }

                }

                globalMax = Math.max(globalMax, sum);
            }
        }

        System.out.println(globalMax);
        br.close();
    }
}
