package indi.hbn.algorithm.ahaalgorithm.chapter2;

import indi.hbn.algorithm.ahaalgorithm.DataUtil;

/**
 * @author wangheng
 * @create 2018-09-21 上午9:53
 * @desc  模拟一个队列
 **/
public class _1Queue {

    /**
     * 模拟一个队列的过程 head  tail
     * FIFO 先进先出
     *
     */
    public static void getQueue(){
        int [] nums = new int[100];
        int head = 0 ; //起始位置
        int tail = DataUtil.inpudata.length ;
        System.arraycopy(DataUtil.inpudata,0,nums,0,tail);
        //创建了一个数组  前面是数据本身 ，尾部 填充0

        while(head <DataUtil.inpudata.length){
            //System.out.println(nums[head]);
            //过滤不想要的元素
            if(head != 0 || head%2 ==1){
                head++ ;
            }
            nums [tail] = nums[head];
           // System.out.println(nums[tail]);
            tail ++;
            head ++ ;

        }
        //执行完毕之后 新的数据加入到尾部

        int starter = DataUtil.inpudata.length ;
        while(starter <nums.length){
            if(nums[starter] != 0)
            System.out.println(nums[starter]);
            starter ++ ;
        }

    }

}
