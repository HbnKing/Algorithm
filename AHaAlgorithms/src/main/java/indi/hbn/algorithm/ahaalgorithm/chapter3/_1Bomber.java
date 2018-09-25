package indi.hbn.algorithm.ahaalgorithm.chapter3;

/**
 * @author wangheng
 * @create 2018-09-21 下午1:48
 * @desc   求出炸弹最合适的位置 （既消灭的敌人数目 最多 ）
 *
 **/
public class _1Bomber {
    /**
     * 创建一个地图信息
     * # 表示 墙体
     * G表示敌人
     * .表示 空
     *  采用穷举的 方法
     * 输出结果为 1 - 11
     * 但是其实并不能走到 该处
     */
    public static  String [] maps = new String[]{
            "#############",
            "#GG.GGG#GGG.#",
            "###.#G#G#G#G#",
            "#.......#..G#",
            "#G#.###.#G#G#",
            "#GG.GGG.#.GG#",
            "#G#.#G#.#.###",
            "##G...G.....#",
            "#G#.#G###.#G#",
            "#...G#G##.GG#",
            "#G#.#G#G#.#G#",
            "#GG.GGG#G.GG#",
            "#############",
    };


    public static String getLocation() {
        int max = 0 ;
        String result ="";
        int x = maps.length;
        int y = maps[0].length();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                char tmp = maps[i].charAt(j);
                if (tmp == '#' || tmp == 'G') {
                    continue;
                } else if (tmp == '.') {
                   if(getmax(i,j) >max ){
                       max = getmax(i , j);
                       result = "" + i + "  " + j ;
                   }
                }
            }
        }

        return  result ;
    }

    public static  int  getmax( int x ,int y){
        int sum = 0;
        /**
         * 先求出改行的总和
         */
        for(int starter = y; starter >0 ; starter --){
            if(maps[x].charAt(starter)=='#'){
                break;
            }else if(maps[x].charAt(starter)=='G'){
                sum ++ ;
            }
        }
        for(int starter = y ; starter <maps[x].length() ; starter ++){
            if(maps[x].charAt(starter)=='#'){
                break;
            }else if(maps[x].charAt(starter)=='G'){
                sum ++ ;
            }
        }
        /**
         * 在求出该列的综合
         */
        for(int starter = x ; starter <maps.length; starter ++){
            if(maps[starter].charAt(y)=='#'){
                break;
            }else if(maps[starter].charAt(y)=='G'){
                sum ++ ;
            }
        }
        for(int starter = x ; starter >0 ; starter --){
            if(maps[starter].charAt(y)=='#'){
                break;
            }else if(maps[starter].charAt(y)=='G'){
                sum ++ ;
            }
        }


        return sum ;

    }



}
