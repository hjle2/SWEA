import java.util.Scanner;

public class Solution {
    public static int solve(Scanner sc) {
        int N, M;
        String[] str = sc.nextLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        int[][] A = new int[N][N];
        for (int i=0; i<N; i++) {
            str = sc.nextLine().split(" ");
            for (int j=0; j<N; j++) {
                A[i][j] = Integer.parseInt(str[j]);
            }
        }

        int sum, ans = 0;
        for (int i=0; i<=N-M; i++) {
            for (int j=0; j<=N-M; j++) {
                sum = 0;
                for (int r=0; r<M; r++) {
                    for (int c=0; c<M; c++) {
                        sum += A[i+r][j+c];
                    }
                }
                ans = Math.max(ans, sum);
            }
        }
        return ans;
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

