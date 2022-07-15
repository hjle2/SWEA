import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t=1; t<=T; t++) {
            int[] ans = solve(sc);
            System.out.printf("#%d %d %d\n", t, ans[0], ans[1]);
        }
    }

    private static int[] solve(Scanner sc) {
        String[] str = sc.nextLine().split(" ");
        int V = Integer.parseInt(str[0]), E = Integer.parseInt(str[1]), a = Integer.parseInt(str[2]), b = Integer.parseInt(str[3]);
        int[] parents = new int[V+1];
        LinkedList[] children = new LinkedList[V+1];
        str = sc.nextLine().split(" ");
        for (int i=0; i<=V; i++) {
            parents[i] = 0;
            children[i] = new LinkedList<Integer>();
        }
        for (int i=0; i<E; i++) {
            int parent = Integer.parseInt(str[i*2]), child = Integer.parseInt(str[i*2+1]);
            parents[child] = parent;
            children[parent].add(child);
        }

        Stack<Integer> arrA = new Stack<>();
        Stack<Integer> arrB = new Stack<>();
        int idx = a;
        while (parents[idx] > 0) {
            arrA.push(parents[idx]);
            idx = parents[idx];
        }
        idx = b;
        while (parents[idx] > 0) {
            arrB.add(parents[idx]);
            idx = parents[idx];
        }
        int ans1 = arrA.pop();
        arrB.pop();
        for (int i=0; i<Math.min(arrA.size(), arrB.size()); i++) {
            int tmp = arrA.pop();
            if (arrB.pop() == tmp) {
                ans1 = tmp;
            }
            else {
                break;
            }
        }

        int ans2 = 0;
        LinkedList<Integer> lst = new LinkedList<>();
        lst.add(ans1);
        while (!lst.isEmpty()) {
            int node = lst.pop();
            ans2++;
            while (!children[node].isEmpty()) {
                lst.add((int) children[node].pop());
            }
        }

        return new int[]{ans1, ans2};
    }
}