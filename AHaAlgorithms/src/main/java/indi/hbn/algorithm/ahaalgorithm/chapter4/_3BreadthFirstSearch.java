package indi.hbn.algorithm.ahaalgorithm.chapter4;

/**
 * @author wangheng
 * @create 2018-10-21 下午5:21
 * @desc  一个迷宫问题   从起点到终点的的过程
 * 直到遇到断头路  然后往其他方向 一直发展 到端头
 * 一个迷宫  1 为障碍物
 * 二维数组 地图如下
 *
 * 0010
 * 0000
 * 0010
 * 01x0
 * 0001
 *
 * 入口为止 1，1
 * 目标为止 4，3  (x位置)
 *
 **/
public class _2saveXiaoHa {


    public static void main(String[] args) {
        _2saveXiaoHa test = new _2saveXiaoHa();
        test.dfs(0,0,1);


    }

    /**
     * 地图信息
     *
     */

    int [][] map = new int[][]{{0,0,1,0},{0,0,0,0},{0,0,1,0},{0,1,99,0},{0,0,0,1}};
    int [][] book = new int[5][5];


    int  next[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};


    public void  dfs(int x ,int y ,int step){

        //到达目标位置
        if(map[x][y] ==99) {
            System.out.println("目前已经找到 小哈 ，当前坐标是 x ="+ x + "  y= " +y + "STEP =" +step );

        }

        //如果当前位置 不是  ，就要往 当前位置的四个方向 去处理
        for(int index = 0 ; index <4 ;index ++){
            x = x +next[index][0];
            y = y +next[index][1];


            if(x <0 || x >3 ||y <0 ||y >3){
                continue;
            }

            //走过的路记录在book中  标记 为1
            //同时  该点不能为障碍物
            if(map[x][y] !=1 &&book[x][y]==0){
                book[x][y] = 1;
                dfs(x ,y ,step+1);
                book[x][y] = 0;

            }
        }

    }

}
