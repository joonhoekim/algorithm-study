package intermediateLow.simulation.격자안에서여러객체를이동;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 숫자가가장큰인접한곳으로동시에이동 {
    /*
     * 구슬 여러 개와 숫자가 적힌 보드가 주어진다.
     * 상하좌우로 이동하는데, 가장 큰 값이 적혀있는 곳으로 이동하고, 가장 큰 값이 여러개인 경우 상하좌우 순 우선순위로 이동한다.
     * 이동 도중에는 부딪힌다는 개념이 없고, 이동 이후 같은 곳으로 이동한 경우 해당 구슬들은 '소멸'된 것으로 간주한다.
     * 구슬은 격자를 벗어날 수 없다. 현재 위치의 값은 이동에 영향을 주지 않는다.
     *
     * 입력
     * 격자크기, 구슬개수, 시간
     * 격자 정보
     * 각 구슬의 시작 행, 열 (1부터 시작)
     *
     * 접근
     * 구슬 이동 결과를 보드에 카운트하고,
     * 2 이상인 경우 소멸 처리
     * */

    /*
     * 로직
     * 각 구슬 포인트에 대해서 이동할 지점을 정한다.
     *   1. 바운더리 안에 있는 점인 경우 후보이며,
     *   2. 가장 큰 값이 여러 개인 경우 상하좌우 순서대로 정한다.
     *       - 상하좌우 순서대로 정하는 건 우좌하상(역순)으로, max 이상일 때 방향 갱신하는 방식으로 구현
     * 이동할 지점을 초기화된 카운트 배열에 1씩 누적합한다.
     *
     * 반복문 다 돈 다음에, 카운트 배열이 2 이상인 경우 0으로 바꾸고,
     * 포인트들을 카운트 1인 지점에 대해 새로 잡아주면 된다.
     * 포인트들을 새로 잡을 때, 그 개수가 변할 수 있으므로
     * List 같이 사이즈를 초기에 정할 필요가 없는 컬렉션을 쓰는 게 좋을 것 같다.
     * */

    static int[] dr = new int[]{-1, +1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int t = Integer.parseInt(input[2]);
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        // Point[] points = new Point[m];
        List<Point> points = new ArrayList<>();
        List<Point> nextPoints = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int rIdx = Integer.parseInt(input[0]) - 1;
            int cIdx = Integer.parseInt(input[1]) - 1;
            //x=r, y=c
            points.add(new Point(rIdx, cIdx));
        }

        int[][] count = null;
        for (int i = 0; i < t; i++) {
            //초반에 count를 초기화한다. 마지막 반복문에선 결과가 쓰인다.
            count = new int[n][n];

            for (Point point : points) {
                Point p = getDestination(point, board);
                count[p.x][p.y]++;
            }

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {

                    // 아래는 그냥 필요가 없네 ...
//                    if (count[r][c] >= 2) {
//                        count[r][c] = 0;
//                    }

                    if (count[r][c] == 1) {
                        //살아남은 구슬이다.
                        nextPoints.add(new Point(r, c));
                    }
                }
            }

            //points를 newPoints로 deep copy해주고
            //newPoints를 비워서 다음 반복에 사용한다.
            points.clear();
            points.addAll(nextPoints);
            nextPoints.clear();

        }

        System.out.println(points.size());
// 굳이 답을 count[][] 참조해서 다시 구해줄 필요가 없네
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (count[i][j] == 1) {
//                    ans += 1;
//                }
//            }
//        }
//
//        System.out.println(ans);
    }

    private static Point getDestination(Point point, int[][] board) {
        int n = board.length;
        int nextR = 0;
        int nextC = 0;
        int max = 0;
        //dxdy 기법 적용
        for (int i = 3; i >= 0; i--) {
            int r = point.x + dr[i];
            int c = point.y + dc[i];
            boolean isInBoundary = 0 <= r && r < n && 0 <= c && c < n;

            if (isInBoundary) {
                if (max <= board[r][c]) {
                    max = board[r][c];
                    nextR = r;
                    nextC = c;
                }
            }
        }

        return new Point(nextR, nextC);
    }
}
