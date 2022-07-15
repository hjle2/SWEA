
import java.util.Scanner;

public class Solution {
    public static String[][] rotate(String[][] str, String[][] A, int N) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                str[i][0] += A[N-1-j][i];
                str[i][1] += A[N-1-i][N-1-j];
                str[i][2] += A[j][N-1-i];
            }
        }
        return str;
    }
    public static void solve(Scanner sc) {
        // init
        int N = Integer.parseInt(sc.nextLine());
        String[][] str = new String[N][N];
        String[][] A = new String[N][3];
        for (int i=0; i<N; i++) {
            A[i] = sc.nextLine().split(" ");
            for (int j=0; j<N; j++) {
                str[i][j] = "";
            }
        }
        str = rotate(str, A, N);
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(str[i][j]);
                if (j < N-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t=1; t<=T; t++) {
            System.out.printf("#%d\n", t);
            solve(sc);
        }
    }

}

