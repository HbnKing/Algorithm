package chapter1;

/**
 * @author wangheng
 * @create 2018-09-20 上午11:12
 * @desc   冒泡排序 算法
 **/
public class _2BubbleSort {

    public static void main(String[] args) {
        int [] inpudata = new int[]{23,45,6,1,342,7465,243,124,345,45,34,654,34};


        /**
         *
         * 通过两次循环 可以将其本身重新排序
         * 该算法的 时间复杂度 N^2
         *
         */
        for(int i=0 ;i<inpudata.length;i++){
            for(int j=0 ;j<inpudata.length;j++){
                if(inpudata[j] <inpudata[i] ){
                   int tmp = inpudata[j];
                   inpudata[j] = inpudata[i];
                   inpudata[i]=tmp ;
                }
            }
        }

        for(int tmp: inpudata){
            System.out.println(tmp);
        }

    }
}
