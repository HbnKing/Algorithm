package indi.hbn.algorithm.ahaalgorithm.chapter4;

import java.util.LinkedList;

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
public class _3BreadthFirstSearch{
    public static void main(String[] args) {
        int[][] array={
                {0,0,1,0},
                {1,0,1,0},
                {0,0,1,0},
                {0,0,0,0}
        };
        new _3BreadthFirstSearch().findMinRold(array);
    }
    //定义图的节点信息
    class Node{
        //定义坐标和距离第一个节点的距离
        int x;
        int y;
        int dis;
        //定义节点的前缀，用于绘制整个最短路径的  线路图
        Node pre;
        public Node(int x , int y , int dis , Node pre) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.pre = pre;
        }
    }

    public void findMinRold(int[][] arr) {
        //定义  上下左右四个方向
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //创建队列
        LinkedList<Node> queue = new LinkedList<Node>();
        //创建开始节点
        Node start = new Node(0, 0, 0, null);
        //把开始节点放入队列中，并做下标记，在原来数组中做标记
        queue.offer(start);
        arr[0][0] = 1;
        //循环操作队列，进行广度遍历
        Node temp = null;
        ok:
        while (!queue.isEmpty()) {
            temp = queue.poll();
            //依次遍历这个节点的四个方向，查找还没有遍历的相连节点
            for (int i = 0; i < 4; i++) {
                int newX = temp.x + direction[i][0];
                int newY = temp.y + direction[i][1];
                //是否越界，坐标
                if (newX < 0 || newX >= 4 || newY < 0 || newY >= 4) {
                    continue;
                }
                //判断是否该节点可以通过，即为0
                if (arr[newX][newY] == 1) {
                    continue;
                }
                //构造节点
                Node next = new Node(newX, newY, temp.dis + 1, temp);
                //该节点可以通过，判断该节点是否是最终节点
                if (newX == 3 && newY == 3) {
                    queue.clear();
                    //相当于头插法，转置
                    queue.offerFirst(next);
                    Node preNode = next.pre;
                    while (preNode != null) {
                        queue.offerFirst(preNode);
                        preNode = preNode.pre;
                    }
                    int len = queue.size();
                    System.out.println("最短路径长度为：" + (len - 1));
                    for (Node it : queue) {
                        System.out.println("(" + it.x + "," + it.y + ") ");
                    }
                    break ok;
                }
                arr[newX][newY] = 1;
                queue.offer(next);
            }//for

        }//while

    }

}
