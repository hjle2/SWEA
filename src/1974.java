
import java.util.Scanner;

public class Solution {
    public static int[] init(int[] ck, int N) {
        for (int i=0; i<=N; i++)
            ck[i] = 0;
        return ck;
    }
    public static int solve(Scanner sc) {
        String[] str;
        int N = 9;
        int[][] A = new int[N][N];
        for (int i=0; i<N; i++) {
            str = sc.nextLine().split(" ");
            for (int j=0; j<N; j++) {
                A[i][j] = Integer.parseInt(str[j]);
            }
        }
        int[] ck = new int[N+1];
        ck = init(ck, N);

        for (int i=0; i<N; i++) {
            ck = init(ck, N);
            for (int j=0; j<N; j++) {
                ck[A[i][j]]++;
                if (ck[A[i][j]] > 1) {
                    return 0;
                }
            }
        }
        ck = init(ck, N);
        for (int i=0; i<N; i++) {
            ck = init(ck, N);
            for (int j=0; j<N; j++) {
                ck[A[j][i]]++;
                if (ck[A[j][i]] > 1) {
                    return 0;
                }
            }
        }
        ck = init(ck, N);
        int[][] D = {{0, 0}, {0, 3}, {0, 6}, {3, 0}, {3, 3}, {3, 6}, {6, 0}, {6, 3}, {6, 6}};
        for (int i=0; i<N; i++) {
            int x = D[i][0], y = D[i][1];
            ck = init(ck, N);
            for (int r=0; r<N/3; r++) {
                for (int c=0; c<N/3; c++) {
                    ck[A[x + r][y + c]]++;
                    if (ck[A[x + r][y + c]] > 1) {
                        return 0;
                    }
                }
            }
        }
        return 1;
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

