package exhaustiveSearch.케이스별로나누기.겹침문제.직사각형겹침;

import java.util.Scanner;

class Rect {

    //x2 > x1, y2 > y1
    int minX;
    int maxX;
    int minY;
    int maxY;

    Rect(int minX, int maxX, int minY, int maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Rect[] rects = new Rect[2];

        for (int i = 0; i < 2; i++) {
            int minX = sc.nextInt();
            int minY = sc.nextInt();
            int maxX = sc.nextInt();
            int maxY = sc.nextInt();
            rects[i] = new Rect(minX,
                                maxX,
                                minY,
                                maxY);
        }

        if (checkRectOverwrap(rects)) {
            System.out.println("overlapping");
        } else {
            System.out.println("nonoverlapping");
        }


    }

    static boolean checkRectOverwrap(Rect[] rects) {
        return !(rects[0].maxX < rects[1].minX || rects[0].minX > rects[1].maxX || rects[0].maxY < rects[1].minY
            || rects[0].minY > rects[1].maxY);
    }
}
