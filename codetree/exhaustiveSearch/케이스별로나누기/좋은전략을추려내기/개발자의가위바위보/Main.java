package exhaustiveSearch.케이스별로나누기.좋은전략을추려내기.개발자의가위바위보;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //사기 가위바위보 ㅋㅋ
        //분석
        // 두 명이 1:1로 진행한 가위/바위/보 기록을 준다.
        //근데 뭐가 가위/바위/보 인지 안알려준다. 1, 2, 3 으로만 알려준다.
        //가위, 바위, 보를 1, 2, 3에 마음대로 매칭할 수 있다고 할 때
        //첫번째 플레이어의 우승횟수를 최대값을 구하면 된다.
        //
        //설계
        //가위, 바위, 보를 1, 2, 3에 매칭하는 것을 완전탐색한다.
        //3P3 = 3! = 6가지 수가 있다.

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] gameLog = new int[n][2];
        final int FIRST_USER = 0;
        final int SECOND_USER = 1;

        for (int i = 0; i < n; i++) {
            gameLog[i][FIRST_USER] = sc.nextInt() - 1;
            gameLog[i][SECOND_USER] = sc.nextInt() - 1;
        }

        int globalMax = 0;

        for (int rock = 0; rock < 3; rock++) {

            for (int scissors = 0; scissors < 3; scissors++) {
                if (scissors == rock) {
                    continue;
                }
                for (int paper = 0; paper < 3; paper++) {
                    if (paper == rock || paper == scissors) {
                        continue;
                    }

                    int localWinCount = 0;
                    for (int i = 0; i < n; i++) {

                        int firstUser = gameLog[i][FIRST_USER];
                        int secondUser = gameLog[i][SECOND_USER];

                        if (firstUser == rock && secondUser == scissors) {
                            localWinCount++;
                        } else if (firstUser == scissors && secondUser == paper) {
                            localWinCount++;
                        } else if (firstUser == paper && secondUser == rock) {
                            localWinCount++;
                        }
                    }

                    globalMax = Math.max(localWinCount,
                                         globalMax);


                }
            }
        }

        System.out.println(globalMax);
    }
}
