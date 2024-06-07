import java.util.Scanner;

class Query {
    int floor;
    int number;
    Query(int floor, int number) {
        this.floor = floor;
        this.number = number;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Query[] queries = new Query[t];

        int MAX_FLOOR = 0;
        //number = 0 을 버릴 것
        int MAX_NUMBER = 0;


        for (int i = 0; i < t; i++) {
            //k층 n호에 몇명이 사는지를 구한다.
            int k = sc.nextInt();
            int n = sc.nextInt();
            queries[i] = new Query(k, n);
            MAX_FLOOR = Math.max(MAX_FLOOR, k);
            MAX_NUMBER = Math.max(MAX_NUMBER, n);

        }




        int[][] aptPop = new int[MAX_FLOOR+1][MAX_NUMBER+1];
        //0층 주어진 조건에 맞게 세팅
        for (int number = 1; number <= MAX_NUMBER; number++) {
            aptPop[0][number] = number;
        }

        for (int a = 1; a <= MAX_FLOOR; a++) {
            for (int b = 1; b <= MAX_NUMBER; b++) {
                for (int number = 1; number <= b; number++) {
                    aptPop[a][b] += aptPop[a-1][number];
                }
            }
        }

        for(Query query : queries) {
            System.out.println(aptPop[query.floor][query.number]);
        }



    }
}