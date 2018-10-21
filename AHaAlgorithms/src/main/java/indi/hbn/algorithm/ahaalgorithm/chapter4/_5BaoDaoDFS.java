package indi.hbn.algorithm.ahaalgorithm.chapter4;

/**
 * @author wangheng
 * @create 2018-10-21 下午10:55
 * @desc
 **/

import java.util.Scanner;

public class _5BaoDaoDFS {
    static int[][] a = new int[50][50];
    static int[][] book = new int[50][50];
    static int sum = 1;
    static int n, m;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        n = input.nextInt();
        m = input.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = input.nextInt();
            }
        }
        int startX = input.nextInt();
        int startY = input.nextInt();
        book[startX][startY] = 1;

        dfs(startX, startY);

        System.out.println(sum);
    }
    public static void dfs(int x, int y) {
        int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int tx, ty;
        for (int i = 0; i < 4; i++) {
            tx = x + next[i][0];
            ty = y + next[i][1];
            if(tx < 0 || tx > n - 1 || ty < 0 || ty > n - 1) {
                continue;
            }
            if (a[tx][ty] > 0 && book[tx][ty] == 0) {
                sum ++;
                book[tx][ty] = 1;
                dfs(tx, ty);
            }
        }
        return;
    }
}
