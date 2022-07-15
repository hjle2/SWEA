import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int N = 16;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static String[][] A;
    static int[] start, end;
    public static int bfs() {
        Queue<int[]> que = new LinkedList<>();
        que.offer(start);
        A[start[0]][start[1]] = "1";
        while (!que.isEmpty()) {
            int[] pt = que.poll();
            int x = pt[0], y = pt[1];
            for (int i=0; i<4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && A[nx][ny].equals("0")) {
                    A[nx][ny] = "1";
                    que.offer(new int[]{nx, ny});
                    if (nx == end[0] && ny == end[1]) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
    public static int solve(Scanner sc) {
        sc.nextLine();
        String[] str;
        A = new String[N][N];

        for (int i=0; i<N; i++) {
            str = sc.nextLine().split("");
            for (int j=0; j<N; j++) {
                A[i][j] = str[j];
                if (A[i][j].equals("2")) {
                    start = new int[]{i, j};
                    A[i][j] = "0";
                }
                else if (A[i][j].equals("3")) {
                    end = new int[]{i, j};
                    A[i][j] = "0";
                }
            }
        }
        return bfs();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t=1; t<=10; t++) {
            System.out.printf("#%d %d\n", t, solve(sc));
        }
    }
}