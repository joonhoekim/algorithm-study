package intermediateLow.simulation.격자안에서완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 행복한수열의개수 {

    /*
     * row or column 에서 연속된 숫자가 m개 이상인 경우 count 해서 출력하면 된다.
     *
     * 중복 체크는 여러 접근방법이 있지만
     * 가독성이 좋은 HashMap을 사용하려고 한다.
     * 원소를 key로 하고, 검출된 횟수를 value로 처리해서
     * row 또는 column을 순회하다가 m을 넘기는 시점에 count 하는 방식이다.
     * 이 방법은 O(n) 이라는 장점이 있다.
     *
     * 다른 방법으로는 Set이 존재 여부를 boolean 리턴하는 것을 이용하는 방식이나,
     * 정렬한 다음에 처리하는 방법이 있다.
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //격자 크기
        int n = Integer.parseInt(st.nextToken());

        //중복 개수의 요구 기준
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //row, column 원소값을 key로 갖고, 나온 횟수를 value로 갖는다.
        Map<Integer, Integer> countMap = new HashMap<>();
        int satisfied = 0;

        loop: for (int rowIdx = 0; rowIdx < n; rowIdx++) {
            countMap.clear();
            for (int j = 0; j < n; j++) {
                countMap.put(arr[rowIdx][j], countMap.getOrDefault(arr[rowIdx][j], 0) + 1);
                if (countMap.get(arr[rowIdx][j]) == m) {
                    satisfied++;
                    continue loop;
                }
            }
        }



        loop: for (int columnIdx = 0; columnIdx < n; columnIdx++) {
            countMap.clear();
            for (int j = 0; j < n; j++) {
                countMap.put(arr[j][columnIdx], countMap.getOrDefault(arr[j][columnIdx], 0) + 1);
                if (countMap.get(arr[j][columnIdx]) == m) {
                    satisfied++;
                    continue loop;
                }
            }
        }

        System.out.println(satisfied);
        br.close();
    }
}
