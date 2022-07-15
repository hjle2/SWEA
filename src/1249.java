
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int[][] A;
    static int N;
    static int d = 4;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    private static int dfs(int x, int y) {
        int[][] visited = new int[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        visited[0][0] = A[0][0];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});
        while (!que.isEmpty()) {
            int[] pt = que.poll();
            x = pt[0]; y = pt[1];
            for (int i=0; i<d; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (0<=nx && nx<N && 0<=ny && ny <N && visited[x][y] + A[nx][ny] < visited[nx][ny]) {
                    visited[nx][ny] = visited[x][y] + A[nx][ny];
                    que.offer(new int[]{nx, ny});
                }
            }
        }
        return visited[N-1][N-1];
    }
    private static int solve(Scanner sc) {
        N = Integer.parseInt(sc.nextLine());
        A = new int[N][N];
        String[] str;
        for (int i=0; i<N; i++) {
            str = sc.nextLine().split("");
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(str[j]);
            }
        }
        return dfs(0, 0);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t=1; t<=T; t++) {
            System.out.printf("#%d %d\n", t, solve(sc));
        }
    }

}
