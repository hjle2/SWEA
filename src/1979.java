import java.util.Scanner;

public class Solution {

    public static int solve(Scanner sc) {
        String[] str = sc.nextLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        int[][] A = new int[N][N];
        for (int i=0; i<N; i++) {
            str = sc.nextLine().split(" ");
            for (int j=0; j<N; j++) {
                A[i][j] = Integer.parseInt(str[j]);
            }
        }
        int rcnt, ccnt, ans = 0;
        for (int i=0; i<N; i++) {
            rcnt = ccnt = 0;
            for (int j=0; j<N; j++) {
                if (A[i][j] == 1) {
                    ccnt ++;
                }
                else {
                    if (ccnt == K) {
                        ans++;
                    }
                    ccnt = 0;
                }
            }
            for (int j=0; j<N; j++) {
                if (A[j][i] == 1) {
                    rcnt ++;
                }
                else {
                    if (rcnt == K) {
                        ans++;
                    }
                    rcnt = 0;
                }
            }
            if (rcnt == K) {
                ans++;
            }
            if (ccnt == K) {
                ans++;
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

