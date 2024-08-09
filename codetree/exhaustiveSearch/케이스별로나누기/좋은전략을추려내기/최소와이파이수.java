package exhaustiveSearch.케이스별로나누기.좋은전략을추려내기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 최소와이파이수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int wifiCount = 0;
        int i = 0;
        while (i < n) {
            // 사람이 사는 곳(1)을 찾음
            while (i < n && arr[i] == 0) {
                i++;
            }

            if (i >= n) break; // 더 이상 사람이 없으면 종료

            // 와이파이 설치 위치 결정 (현재 위치에서 m만큼 오른쪽)
            int wifiPosition = Math.min(i + m, n - 1);

            wifiCount++; // 와이파이 설치
            i = wifiPosition + m + 1; // 다음 검사 위치로 이동 (와이파이 범위를 넘어선 다음 위치)
        }

        bw.write(String.valueOf(wifiCount));
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }
}