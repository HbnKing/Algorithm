package indi.hbn.algorithm.ahaalgorithm.chapter4;

/**
 * @author wangheng
 * @create 2018-10-21 下午10:49
 * @desc
 **/


import java.util.*;

public class _4bomb_Two {


    static int n;    //行
    static int m;    //列
    static char maze[][];    //存储地图
    static int book[][];    //标记
    static int x[];    //队列横坐标
    static int y[];    //队列纵坐标
    static int step[];    //步数
    static int max=0;    //存储最大敌人数
    static int save_x;    //存储目标横坐标
    static int save_y;    //存储目标纵坐标

    static void Totall(int x,int y) {    //统计可消灭敌人数

        int total=0;
        int dx=x;
        int dy=y;
        while(maze[dx][dy]!='#') {    //右
            if(maze[dx][dy]=='G') {
                total++;
            }
            dy++;
        }
        dx=x;
        dy=y;
        while(maze[dx][dy]!='#') {    //下
            if(maze[dx][dy]=='G') {
                total++;
            }
            dx++;
        }
        dx=x;
        dy=y;
        while(maze[dx][dy]!='#') {    //左
            if(maze[dx][dy]=='G') {
                total++;
            }
            dy--;
        }
        dx=x;
        dy=y;
        while(maze[dx][dy]!='#') {    //上
            if(maze[dx][dy]=='G') {
                total++;
            }
            dx--;
        }
        if(total>max) {
            save_x=x;
            save_y=y;
            max=total;
        }
    }

    public static void main(String[] args) {

        Scanner reader=new Scanner(System.in);
        n=reader.nextInt();
        m=reader.nextInt();
        int start_x=reader.nextInt();    //炸弹人初始位置
        int start_y=reader.nextInt();
        x=new int[n*m];
        y=new int[n*m];
        step=new int[n*m];
        int dir[][]= {{0,1},{1,0},{0,-1},{-1,0}};    //右、下、左、上
        int head=0;    //头结点
        int tail=0;    //尾结点
        maze=new char[n][m];
        book=new int[n][m];
        for(int i=0;i<n;i++) {
            String ss=reader.next();
            maze[i]=ss.toCharArray();
        }



        for(int i=0;i<n;i++) {    //标记数组初始化
            for(int j=0;j<m;j++) {
                book[i][j]=0;
            }
        }
        Totall(start_x,start_y);    //统计初始位置可灭敌数
        //初始位置入队列
        x[tail]=start_x;
        y[tail]=start_y;
        step[tail]=0;
        book[start_x][start_y]=1;
        tail++;    //尾指针后移
        while(head<=tail) {
            for(int i=0;i<4;i++) {
                int dx=x[head]+dir[i][0];
                int dy=y[head]+dir[i][1];
                if(dx<0 || dx>n || dy<0 || dy>m) {    //越界判断
                    continue;
                }
                if(maze[dx][dy]!='.' || book[dx][dy]==1) {    //障碍点和空地判断
                    continue;
                }
                //符合条件
                x[tail]=dx;
                y[tail]=dy;
                step[tail]=step[head]+1;
                book[dx][dy]=1;
                tail++;
                Totall(dx,dy);    //统计敌人数
            }
            head++;    //出队列
        }
        System.out.println("("+save_x+","+save_y+")"+" "+max);
    }

}