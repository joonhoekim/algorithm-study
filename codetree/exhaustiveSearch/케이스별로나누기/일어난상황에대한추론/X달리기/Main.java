package exhaustiveSearch.케이스별로나누기.일어난상황에대한추론.X달리기;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dist = sc.nextInt();

        //대수적으로 풀 수 있을 듯?
        int maxSpeed = (int) Math.floor(Math.sqrt((double) dist));
        int sumTime = 2 * maxSpeed - 1;

        System.out.println(maxSpeed);
        System.out.println(sumTime);
        int remainingDist = dist - maxSpeed * maxSpeed;
        int continuedSpeed = maxSpeed;
        while (remainingDist > 0) {
            if (remainingDist >= continuedSpeed) {
                remainingDist -= continuedSpeed;
                sumTime++;
            } else {
                continuedSpeed--;
            }
        }

        System.out.println(sumTime);

    }
}
