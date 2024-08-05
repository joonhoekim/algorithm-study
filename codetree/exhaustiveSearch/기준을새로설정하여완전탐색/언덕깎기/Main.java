package exhaustiveSearch.기준을새로설정하여완전탐색.언덕깎기;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // - 언덕 높이가 0부터 100까지 존재할 수 있음
        // - 언덕 최대차이가 MAX_DIFF 이하여야 함
        // - 언덕 H만큼 깎거나 높일 때 비용은 H^2 가 든다

        Scanner sc = new Scanner(System.in);
        final int MAX_DIFF = 17;

        int n = sc.nextInt();
        int[] heightArr = new int[n];

        int minH = Integer.MAX_VALUE;
        int maxH = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            heightArr[i] = sc.nextInt();
            minH = Math.min(minH,
                            heightArr[i]);
            maxH = Math.max(maxH,
                            heightArr[i]);
        }

        //완전탐색으로 풀자
        int globalMinSum = Integer.MAX_VALUE;

        //아래를 올리는 경우
        for (int bottom = minH; bottom <= maxH - MAX_DIFF; bottom++) {
            //위를 내리는 경우
            for (int top = maxH; top >= minH + MAX_DIFF; top--) {

                //일단 MAX_DIFF 안으로 들어왔는지 확인하고, 아니면 이번 반복은 그냥 넘김
                if (top - bottom > MAX_DIFF) {
                    continue;
                }

                //bottom, top에 넘어가는 언덕들로 비용을 검사하고, 글로벌 최소값을 갱신함
                globalMinSum = Math.min(globalMinSum,
                                        getTotalExpense(heightArr,
                                                        top,
                                                        bottom));

            }
        }

        System.out.println(globalMinSum);
    }

    private static int getTotalExpense(int[] heightArr, int top, int bottom) {
        int expenseSum = 0;
        for (int height : heightArr) {
            if (height > top) {
                expenseSum += (int) Math.pow(height - top,
                                             2);
            } else if (bottom > height) {
                expenseSum += (int) Math.pow(bottom - height,
                                             2);
            }
        }

        return expenseSum;
    }
}
