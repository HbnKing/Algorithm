package indi.hbn.algorithm.ahaalgorithm.chapter4;

/**
 * @author wangheng
 * @create 2018-10-21 下午10:58
 * @desc
 * Input：
 * 10 10
 * 1 2 1 0 0 0 0 0 2 3
 * 3 0 2 0 1 2 1 0 1 2
 * 4 0 1 0 1 2 3 2 0 1
 * 3 2 0 0 0 1 2 4 0 0
 * 0 0 0 0 0 0 1 5 3 0
 * 0 1 2 1 0 1 5 4 3 0
 * 0 1 2 3 1 3 6 2 1 0
 * 0 0 3 4 8 9 7 5 0 0
 * 0 0 0 3 7 8 6 0 1 2
 * 0 0 0 0 0 0 0 0 1 0
 * 6 8
 *
 * Output：
 * 38
 **/

import java.util.Scanner;

public class _5BaoDaoOther {
    static int[][] a = new int[50][50];
    static int[][] book = new int[50][50];
    static int sum = 1;
    static int num = 0;
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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] > 0) {
                    num--;
                    book[i][j] = 1;
                    dfs(i, j, num);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println(-num);
    }
    public static void dfs(int x, int y, int color) {
        int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int tx, ty;
        a[x][y] = color;
        for (int i = 0; i < 4; i++) {
            tx = x + next[i][0];
            ty = y + next[i][1];
            if(tx < 0 || tx > n - 1 || ty < 0 || ty > n - 1) {
                continue;
            }
            if (a[tx][ty] > 0 && book[tx][ty] == 0) {
                sum ++;
                book[tx][ty] = 1;
                dfs(tx, ty, color);
            }
        }
        return;
    }
}

