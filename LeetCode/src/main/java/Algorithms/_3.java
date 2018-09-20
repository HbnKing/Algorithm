package Algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hbn.king
 * @create 2018-09-19 下午1:19
 * @desc
 **/
public class _3 {
    /**
     * I 指向起始位置 J 指向 尾部  j-i 为长度
     *
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0, j = 0; j < n; j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            ans = Math.max(ans, j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return ans;
    }
}
