import java.util.Scanner;

public class Solution {
    static int[][] ar;
    static int N;
    static boolean[] visited;
    private static int getDistance(int[] a, int[] b) {
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
    private static int dfs(int distance, int idxNow, int cnt) {
        int ans = Integer.MAX_VALUE;
        if (cnt == N) {
            return distance + getDistance(ar[idxNow], ar[1]);
        }
        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ans = Math.min(ans, dfs(distance + getDistance(ar[idxNow], ar[i+2]), i+2, cnt + 1));
                visited[i] = false;
            }
        }
        return ans;
    }
    private static int solve(Scanner sc) {
        N = Integer.parseInt(sc.nextLine());
        String[] str = sc.nextLine().split(" ");
        ar = new int[N+2][2];
        for (int i=0; i<N+2; i++) {
            ar[i][0] = Integer.parseInt(str[i*2]);
            ar[i][1] = Integer.parseInt(str[i*2+1]);
        }
        int ans = Integer.MAX_VALUE;
        visited = new boolean[N];
        for (int i=0; i<N; i++) {
            visited[i] = false;
        }
        for (int i=0; i<N; i++) {
            visited[i] = true;
            ans = Math.min(ans, dfs(getDistance(ar[0], ar[i+2]), i+2, 1));
            visited[i] = false;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t=1; t<=T; t++) {
            System.out.printf("#%d %d\n", t, solve(sc));
        }
    }

}