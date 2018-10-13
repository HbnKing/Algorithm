package indi.hbn.algorithm.ahaalgorithm.chapter3;

/**
 * @author wangheng
 * @create 2018-10-14 上午12:10
 * @desc  给一个 数量为N的火柴  拼出 A+B =C  等式
 * 最高位不为零
 * 所有火柴必须用上
 * A !=B 时  A+B =C  和 B+A =C 为两个等式
 *
 *
 **/
public class _2Matchstick {

    /**
     * 一个根据数值 获取所需火柴数量的方法
     * @param num
     * @return
     */
    public int  numsOfMatch(int num){
        int result = 0 ;
        //定义一个基本数值 和 所需火柴数目的对应关系 0-9十个数
        int [] Matches = {6,2,5,5,4,5,6,3,7,6};
        //根据输入的数值 得到其数字的火柴数量
        while(num/10 !=0){  //num >10
            result = result +Matches[num%10];
            num = num/10;
        }
        result = result + Matches[num];
        return  result ;
    }

    public void  getRecords(int input){
        //个数输入input 可以设置 A 或者B 的上限
       // input =  ;

        //这里的上限 1111可以根据 input 动态调整 1所需最少 2根火柴  最多可以凑合(input -4 -2 )/2  个 1
        for(int i = 0 ; i<1111; i++){

            for(int j = 0 ; j<1111 ;j++){
                int k = i+j;

                if(numsOfMatch(i) +numsOfMatch(j) +numsOfMatch(k)==input-4){
                    System.out.println("" +i + " + "+j +" = "+ k);
                }

            }
        }


    }

    public static void main(String[] args) {
        _2Matchstick tt = new _2Matchstick();
        tt.getRecords(18);
    }


}
