package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2019-01-02 上午10:50
 * @desc
 *
 *
 **/
public class _63 {
    public static void main(String[] args) {
        int [][] test = new int[][]
    {{0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0},{1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,1},{0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0},{0,0,0,1,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0},{1,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0},{0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0},{0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,1},{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,1},{1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,1,1,0,1,0,0,0,0,1,1},{0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,1},{1,1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1},{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0}};
        _63  tt = new _63();

        System.out.println(tt.uniquePathsWithObstacles(test));


    }


    /**
     *
     * 第一反应 是 使用  广度优先 遍历
     * 因为 只能 往下 和 往右
     * 所以 每个点只有两个 方向
     * 可以到达 则 +1
     *
     * @param obstacleGrid
     * @return
     *
     */

    int counter = 0 ;
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        couldFinish(obstacleGrid,0,0);
        return counter;
    }

    /**
     *
     * 对于每一种可能  都要做一次 尝试 （穷举 的尝试 ）
     * 性能较差  超时 报错
     *
     *
     * @param obstacleGrid
     * @param i
     * @param j
     * @return
     */
    public boolean couldFinish(int[][] obstacleGrid ,int i , int j){
        if(i >=obstacleGrid.length || j>=obstacleGrid[0].length){
            return false ;
        }

        //该点是障碍物
        if(obstacleGrid[i][j] ==1 ) return false ;

        //本节已到达  到达一次 计数一次
        if(i == obstacleGrid.length-1 && j ==obstacleGrid[0].length-1){
            counter ++ ;
            System.out.println(counter);
            return true ;
        }else {//下一个节点 是否可以到达
            boolean flag1 = couldFinish(obstacleGrid,i+1 ,j );
            boolean flag2 = couldFinish(obstacleGrid ,i,j+1 );

            return    flag1|| flag2;
        }
    }


    /**
     * 可以 到达 自己的右边 和 下部
     * 那么 来自于自己的 左边 和 上部
     *
     * 尝试使用 动态规划的方法
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int width = obstacleGrid[0].length  ;
        int height = obstacleGrid.length   ;
        //只需要定义最后一行宽度的 数组

        int [] result = new int [width] ;

        //可达的
        result[0] =1 ;

        for(int i = 0 ; i<height ;i++){
            for(int j = 0 ; j <width ; j++){
                //不停地修改 result 数组
                //如果该点不可达  那么该点 的 下一次 位置值是多少
                // 该点的 左侧 可能性 + 该点的 上部的 可能性
                //上部 的额结果 就是自身的旧数据
                if(obstacleGrid[i][j] == 1){
                    result[j] = 0 ;
                }else if(j >0 ){
                    result[j]  += result[j-1] ;
                }
            }
        }
        return result[width-1];
    }
}