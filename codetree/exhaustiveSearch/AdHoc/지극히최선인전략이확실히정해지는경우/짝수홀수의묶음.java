package exhaustiveSearch.AdHoc.지극히최선인전략이확실히정해지는경우;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 짝수홀수의묶음 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int oddCount = 0;
        int evenCount = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        bw.write(String.valueOf(solve(oddCount,
                                      evenCount)));

        bw.flush();
        bw.close();
        br.close();
    }

    /*
     * 문제 조건을 잘못 이해함
     * 부분합이 원소 한개여도 가능함
     *
     * 그럼 짝홀짝홀짝홀 1개 원소로 만들되
     * - 짝수는 몇개가 남아도 상관 없고
     * - 홀수는 홀+홀 = 짝 으로 바꿔서 써야 할 것임
     *
     * - 짝수가 더 많으면, 홀수개수 * 2 가 답이 될 거고
     * - 홀수가 더 많으면, 홀수를 더해서 짝수로 바꿔주면 됨
     * */

    static int solve(int oddCount, int evenCount) {

        if (evenCount == oddCount) {
            //짝수가 더 많으면, 홀수 개수에 의존적임
            return oddCount * 2;
        } else if (evenCount > oddCount) {
            return oddCount * 2 + 1;
        } else {
            // 홀수 2*x 개를 x개의 짝수로 바꾼다.
            // evencount + x = oddCount - 2x
            // 3x = oddCount - evenCount (단 x>=1 이어야 함)
            // 올림 처리해서, 짝홀짝홀 유지 가능하도록 함
            // 이렇게 처리하면, 최대 길이는 짝수 개수에 의존적임.
            // 아래 코드는 대수적으로 푼건데 왜 틀린지 모르겠어서 일단 주석처리..
            int x = (oddCount - evenCount) / 3;
            oddCount -= 2 * x;
            evenCount += x;

            return solve(oddCount,
                         evenCount);


        }
    }
}
