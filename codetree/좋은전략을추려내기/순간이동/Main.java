package 좋은전략을추려내기.순간이동;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    //a -> B 로 이동할 것
    //x->y 혹은 y->x 로 순간이동 가능함
    //최소 거리는?

    //그냥 가거나
    //텔레포트를 써서 가거나

    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int x = sc.nextInt();
    int y = sc.nextInt();

    int justGo = Math.abs(a - b);
    int teleported = 0;
    if (Math.abs(a - x) > Math.abs(a - y)) {
      //y 로 들어가서 x 로 나온다.
      teleported += Math.abs(a - y);
      teleported += Math.abs(b - x);
    } else {
      //x 로 들어가서 y 로 나온다.
      teleported += Math.abs(a - x);
      teleported += Math.abs(b - y);
    }

    int ans = Math.min(justGo, teleported);
    System.out.println(ans);


  }
}
