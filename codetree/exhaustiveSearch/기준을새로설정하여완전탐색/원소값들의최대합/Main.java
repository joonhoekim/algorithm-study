package exhaustiveSearch.기준을새로설정하여완전탐색.원소값들의최대합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int numOfInputs = Integer.parseInt(st.nextToken());
        int numOfAction = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[numOfInputs];
        for (int i = 0; i < numOfInputs; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //시작 위치 전부에 대해 원소값들의 합을 최대값을 완전탐색해보자
        int globalSumMax = Integer.MIN_VALUE;

        //모든 시작위치에 대해서
        for (int startIdx = 0; startIdx < numOfInputs; startIdx++) {
            //numOfActions 값만큼 반복할 것이다.
            int actionCount = 0;
            int localSum = 0;
            int checkIdx = startIdx;
            while (actionCount < numOfAction) {
                localSum += arr[checkIdx];
                checkIdx = arr[checkIdx] - 1;
                actionCount++;
            }
            globalSumMax = Math.max(globalSumMax,
                                    localSum);
        }

        bw.write(String.valueOf(globalSumMax));
        br.close();
        bw.flush();
        bw.close();
    }
}
