import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //낮에 올라가는 높이
        int A = sc.nextInt();

        //밤에 미끄러지는 높이
        int B = sc.nextInt();

        //오를 나무의 높이
        int V = sc.nextInt();

        //하루에 오르는 높이
        int interval = A-B;

        // interval*X + A >= V 를 만족하는 최소의 X가 답이 된다.
        // 이항하면 X >= (V-A)/interval, 단 날짜 단위이고 첫날에 바로 오르기를 성공하면 1일째에 성공한 것이니 1을 더해준다.

        int minDay = (int) Math.ceil( ((double)V-A)/interval) + 1;



        System.out.println(minDay);
    }
}
