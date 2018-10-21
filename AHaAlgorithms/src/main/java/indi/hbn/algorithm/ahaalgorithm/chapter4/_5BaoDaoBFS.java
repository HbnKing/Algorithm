package indi.hbn.algorithm.ahaalgorithm.chapter4;

/**
 * @author wangheng
 * @create 2018-10-21 下午10:56
 * @desc
 **/


import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Scanner;

class node {
    int x;
    int y;
    node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class _5BaoDaoBFS {
    static int[][] a = new int[50][50];
    static int[][] book = new int[50][50];
    static int n, m;
    static int sum = 1;
    static Queue<node> queue = new LinkedList<>();
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
        queue.offer(new node(startX, startY));
        book[startX][startY] = 1;
        bfs();
        System.out.println(sum);
    }
    public static void bfs() {
        int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int tx, ty;
        while (!queue.isEmpty()) {
            for (int i = 0; i < 4; i++) {
                tx = queue.peek().x + next[i][0];
                ty = queue.peek().y + next[i][1];
                if (tx < 0 || tx > n - 1 || ty < 0 || ty > n - 1) {
                    continue;
                }
                if(a[tx][ty] > 0 && book[tx][ty] == 0) {
                    queue.offer(new node(tx, ty));
                    sum++;
                    book[tx][ty] = 1;
                }

            }
            queue.remove();
        }
        return;
    }
}