package chapter1;

/**
 * @author wangheng
 * @create 2018-09-20 下午12:31
 * @desc
 **/
public class _3QuickSort {

    /**
     * 快速排序（Quicksort）是对冒泡排序的一种改进。
     * 快速排序由C. A. R. Hoare在1962年提出。
     * 它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，
     * 其中一部分的所有数据都比另外一部分的所有数据都要小，
     * 然后再按此方法对这两部分数据分别进行快速排序，
     * 整个排序过程可以递归进行，
     * 以此达到整个数据变成有序序列。
     *
     * 快速排序 是基于一种二分的思想
     * 先分为 前后两个部分 再 对其内部进行各自的分割排序
     * 他的平均时间复杂度 是O(nlowgn)
     * @param args
     */
    public static void main(String[] args) {

        int [] nums = DataUtil.inpudata ;

        quicksort2( nums ,0 ,nums.length-1);
        for(int num : nums){
            System.out.println(num);
        }
    }

    /**
     * 快速 排序 采用 递归算法
     * 现将数组 分为两部分  比 middle 大的数 和 比 middle 小的数
     * 在 将这两部分  再次调用 快速排序 算法  直到找到结果 为止
     *
     */

    public static int partition(int []array,int low,int high){
        //固定的切分方式
        //获取第一个元素
        int key=array[low];
        while (low<high){
            //从后半部分向前扫描 直到找到一个比 基准要小的数目
            while (array[high]>=key&&high>low){
                high--;
            }

            //找到之后将它赋值给 第一位数【 low 】
            array[low]=array[high];
            //再从前面扫描
            while (array[low]<=key&&high>low){
                low++;
            }
            //前面 第一个
            array[high]=array[low];
        }
        //直到 low  和 high 相遇后
        //对中间值 赋值
        array[high]=key;
        return high;
    }

    public static void sort(int[] array,int low ,int high){
        if(low>=high){
            return ;
        }
        int index=partition(array,low,high);
        sort(array,low,index-1);
        sort(array,index+1,high);
    }

    public  static void quicksort2(int [] array , int left ,int right){
        int low = left ;
        int high =right ;
        if(low>=high){
            return ;
        }
        int key=array[low];
        while (low<high){
            //从后半部分向前扫描 直到找到一个比 基准要小的数目
            while (array[high]>=key&&high>low){
                high--;
            }

            //找到之后将它赋值给 第一位数【 low 】
            array[low]=array[high];
            //再从前面扫描
            while (array[low]<=key&&high>low){
                low++;
            }
            //前面 第一个
            array[high]=array[low];
        }
        //直到 low  和 high 相遇后
        //对中间值 赋值
        array[high]=key;

        quicksort2(array,left,high-1);
        quicksort2(array,high+1,right);

    }
}
