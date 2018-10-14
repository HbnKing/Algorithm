package indi.hbn.algorithm.ahaalgorithm.chapter4;

/**
 * @author wangheng
 * @create 2018-10-14 下午6:04
 * @desc
 *
 * 用 深度搜索 来进行 数的全排列
 *  本身 该如何做 下一步 该如何做
 **/
public class _1DepthFirstSearch {

    public static void main(String[] args) {
        _1DepthFirstSearch  tt = new _1DepthFirstSearch();
        tt.dfs(1);
    }
    int [] a = new int[10]; // 有序的存入 十个数
    //一个共享的变量 book 表示 其角标的数值是否被使用
    int [] book = new int[10]; //
    int n = 9 ;


    public void dfs(int step){

        int i = 0 ;

        //输出已经排序的数据  step ==10 表示前面的1-9数值 已经排好序了
        if(step ==10){
           for(i = 1 ; i<a.length ; i++){
               System.out.print(a[i]);
           }
            System.out.print('\n');
        }
        //否则 我们就排序吧n

        //每一层 都会从 1-9中的数字尝试 一遍
        for(i = 1 ;i<=n ; i++ ){
            if(book[i] == 0){ // i 还未被使用
                a[step] = i ;
                book[i] = 1 ;
                //下一步
                dfs(step +1);
                //这一次的结果执行完毕之后  将这个数字 放回 池中
                book[i] = 0 ;
                //然后进行下一次递增
            }
        }
    }
}
