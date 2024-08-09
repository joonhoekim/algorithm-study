package exhaustiveSearch.케이스별로나누기.가능한상황을나열하기;

import java.util.Arrays;
import java.util.Scanner;

public class 순위경쟁 {
    public static void main(String[] args) {
        //게임 점수가 바뀔 때마다 점수가 1등인 사람을 명예의 전당에 올린다.
        //명예의 전당에 올라간 사람의 '조합'이 몇번 바뀌었는지를 카운트해라.

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int PLAYER_COUNT = 3;
        int[] score = new int[PLAYER_COUNT];
        boolean[] prevHallOfFame = new boolean[PLAYER_COUNT];
        boolean[] hallOfFame = new boolean[PLAYER_COUNT];

        Arrays.fill(hallOfFame, true);
        Arrays.fill(prevHallOfFame, true);


        int count = 0;
        for (int i = 0; i < n; i++) {
            //배열 깊은복사해서 변경하기 전에 기억해둔다.
            System.arraycopy(hallOfFame, 0, prevHallOfFame, 0, hallOfFame.length);

            int player = sc.next().charAt(0) - 'A';
            score[player] += sc.nextInt();

            //maxScore 바뀌는 경우 처리한다.
            int maxScore = Integer.MIN_VALUE;
            for(int j = 0; j < PLAYER_COUNT; j++) {
                //새 maxScore 발생하는 경우 이전 정보 다 날린다.
                if(score[j] > maxScore) {
                    maxScore = score[j];
                    Arrays.fill(hallOfFame, false);
                    hallOfFame[j] = true;
                } else if(score[j] == maxScore) {
                    hallOfFame[j] = true;
                }
            }

            //변경 감지
            for (int j = 0; j < hallOfFame.length; j++) {
                if(hallOfFame[j] != prevHallOfFame[j]) {
                    count ++;
                    break;
                }
            }
        }

        System.out.println(count);

    }
}
