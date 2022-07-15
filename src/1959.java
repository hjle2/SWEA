import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {
    public static int solve(Scanner sc) {
        // init
        String[] str = sc.nextLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        str = sc.nextLine().split(" ");
        int[] A = new int[N];
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(str[i]);
        }

        str = sc.nextLine().split(" ");
        int[] B = new int[M];
        for (int i=0; i<M; i++) {
            B[i] = Integer.parseInt(str[i]);
        }

        if (N < M) {
            int tmp = N;
            N = M;
            M = tmp;
            int[] tmpar = A;
            A = B;
            B = tmpar;
        }
        // solve
        int ans = 0, sum;
        int turn = N-M;
        for (int i=0; i<=turn; i++) {
            sum = 0;
            for (int j=0; j<M; j++) {
                sum += A[j+i] * B[j];
            }
            ans = Math.max(ans,  sum);
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

