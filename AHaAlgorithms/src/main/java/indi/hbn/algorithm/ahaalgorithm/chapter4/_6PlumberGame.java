package indi.hbn.algorithm.ahaalgorithm.chapter4;
import java.util.Scanner;
/**
 * @author wangheng
 * @create 2018-10-21 下午11:08
 * @desc
 **/


public class _6PlumberGame {
        private static int[][] map;         //存储管道图
        private static int n, m, top;       //管道的矩阵x，y， top栈顶元素
        private static boolean[][] status;  //是否已使用
        private static String[] stack;      //栈

        /**
         *
         * @param x 坐标x
         * @param y 坐标y
         * @param direction 进水口方向：1上、2右、3下、4左
         */
        private static void  dfs(int x, int y, int direction){
            if(x == n-1 && y == m){     //如果到出口的下一个则表示完成一条路径
                System.out.println("搜索到连通路线");
                for (int i = 0; i < top;i++){
                    System.out.print(stack[i]+"->");
                }
                System.out.println();
                return ;
            }

            if(y < 0 || x < 0|| x > n-1 || y > m-1 || status[x][y])
                return;

            status[x][y] = true;
            stack[top] = "("+(x+1)+","+(y+1)+","+direction+")";     //入栈
            top++;


            if (5 <= map[x][y] && map[x][y] <= 6){      //如果是直管道
                switch (direction){
                    case 1:
                        dfs(x+1, y, direction);
                        break;
                    case 2:
                        dfs(x, y-1, direction);
                        break;
                    case 3:
                        dfs(x-1, y, direction);
                        break;
                    case 4:
                        dfs(x, y+1, direction);
                        break;
                }

            }else{
                switch (direction){     //弯管道
                    case 1:
                        dfs(x, y-1, 2);
                        dfs(x, y+1, 4);
                        break;
                    case 2:
                        dfs(x-1, y, 3);
                        dfs(x+1, y, 1);
                        break;
                    case 3:
                        dfs(x, y-1, 2);
                        dfs(x, y+1, 4);
                        break;
                    case 4:
                        dfs(x-1, y, 3);
                        dfs(x+1, y, 1);
                        break;
                }
            }

            status[x][y] = false;
            top--;
        }

        public static void main(String[] ages){
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            m = scanner.nextInt();

            map = new int[n][m];
            status = new boolean[n][m];
            stack = new String[n*m];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    map[i][j] = scanner.nextInt();
                }
            }

            dfs(0,0, 4);
        }
}


/**
 测试数据：
 5 4
 5 3 5 3
 1 5 3 0
 2 3 5 1
 6 1 1 5
 1 5 5 4
 结果：
 搜索到连通路线
 (1,1,4)->(1,2,4)->(2,2,1)->(3,2,1)->(3,3,4)->(3,4,4)->(4,4,1)->(5,4,1)->
 */

