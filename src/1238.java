import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int N, S;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] A;
    static int[] start, end;

    public static int solve(Scanner sc) {
        String[] str = sc.nextLine().split(" ");
        N = Integer.parseInt(str[0]);
        S = Integer.parseInt(str[1]);
        str = sc.nextLine().split(" ");
        A = new int[N][2];
        for (int i=0; i<N; i+=2) {
            A[i/2][0] = Integer.parseInt(str[i]);
            A[i/2][1] = Integer.parseInt(str[i+1]);
        }

        LinkedList[] lst = new LinkedList[N+1];
        for (int i=0; i<N+1; i++) {
            lst[i] = new LinkedList();
        }

        for (int i=0; i<N/2; i++) {
            if (!lst[A[i][0]].contains(A[i][1]))
                lst[A[i][0]].add(A[i][1]);
        }

        boolean[] visited = new boolean[N+1];
        for (int i=0; i<N+1; i++) {
            visited[i] = false;
        }
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{S, 0});
        int ans = 0, time = 0;
        while (!que.isEmpty()) {
            int[] q = que.poll();
            int n = q[0], t = q[1];
            int ret = 0;
            for (int i=0; i<lst[q[0]].size(); i++) {
                int v = (int) lst[n].get(i);
                if (!visited[v]) {
                    que.add(new int[]{v, t+1});
                    visited[v] = true;
                    ret = Math.max(ret, v);
                }
            }
            if (time < t+1) {
                if (ret > 0) {
                    ans = ret;
                    time = t+1;
                }
            }
            else if (time == t+1) {
                ans = Math.max(ans, ret);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t=1; t<=10; t++) {
            System.out.printf("#%d %d\n", t, solve(sc));
        }
    }
}