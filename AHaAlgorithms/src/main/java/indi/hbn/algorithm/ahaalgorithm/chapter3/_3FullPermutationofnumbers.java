package indi.hbn.algorithm.ahaalgorithm.chapter3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangheng
 * @create 2018-10-14 上午12:45
 * @desc 数的全排列
 * 123  132 213 231 312 321
 **/
public class _3FullPermutationofnumbers {


    public static void main(String[] args) {
        _3FullPermutationofnumbers  tt = new _3FullPermutationofnumbers();
        tt.getNumbers();

    }

    /**
     * 那就来个九层的吧
     */
    public void getNumbers(){
        Set set = new HashSet();
        for(int c1 = 1 ;c1<10 ;c1 ++){
            for(int c2 = 1 ;c2<10 ;c2 ++){
                for(int c3 = 1 ;c3<10 ;c3 ++){
                    for(int c4 = 1 ;c4<10 ;c4 ++){
                        for(int c5 = 1 ;c5<10 ;c5 ++){
                            for(int c6 = 1 ;c6<10 ;c6++){
                                for(int c7 = 1 ;c7<10 ;c7++){
                                    for(int c8 = 1 ;c8<10 ;c8 ++){
                                        for(int c9 = 1 ;c9<10 ;c9 ++){

                                            set.clear();
                                            set.add(c1);
                                            set.add(c2);
                                            set.add(c3);
                                            set.add(c4);
                                            set.add(c5);
                                            set.add(c6);
                                            set.add(c7);
                                            set.add(c8);
                                            set.add(c9);
                                           if(set.size() !=9)continue;
                                            System.out.println("" +c1 +c2 +c3 +c4 +c5 +c6 +c7 +c8 +c9);

                                        }
                                    }
                                }
                            }
                        }
                    }
                }


            }
        }

    }


}
