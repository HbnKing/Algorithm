package chapter1;

import java.util.Scanner;

/**
 * @author wangheng
 * @create 2018-09-20 上午10:46
 * @desc  初入桶排序
 **/
public class _1bucket {

    /**
     * 通过一个简单的例子 了解到什么是桶排序
     * 将 数值相同的只 放入一个 桶中
     * 这样就已经自动排好序了
     * 当然 你也看到了他的问题，非常的浪费空间
     * 及时我们只有很少的数目需要排序
     * 我们依然需要创建大量的桶  book[]
     * 来保证他的数据范围
     * 时间复杂度 O（2（m+n））
     * O(m+n)
     * @param args
     */
    public static void main(String[] args) {
        //初始化一个桶
        int [] book  = new int[1000];


        Scanner scanner = new Scanner(System.in);
        //接下来将输入 的数目的个数

        System.out.println("请输入 想要输入的数目");
        int nums =  scanner.nextInt();

        //将得到数 放入到该数值得 桶中 ，且该位置的值 +1
        for(int i =1 ;i<=nums;i++){
            System.out.println("这是第" + i + "数目 ");
            int  next = scanner.nextInt();
            book[next] ++ ;

        }

        //输出 结果
        for(int i = 0 ; i<book.length ;i++){
            if(book[i]==0){
                continue;
            }
            while(book[i] >0){
                System.out.println(i);
                book[i]--;
            }

        }

    }


}
