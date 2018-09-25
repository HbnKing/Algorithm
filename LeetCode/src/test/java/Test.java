package java;

import indi.hbn.algorithm.leetcode.Algorithms._2;
import indi.hbn.algorithm.leetcode.common.ListNode;

/**
 * @author hbn.king
 * @create 2018-09-17 下午7:38
 * @desc
 **/
public class Test {

    public static void main(String[] args) {
        _2   tmp = new _2();

        ListNode  l1 = new ListNode(9);
        ListNode l2 = new ListNode(9) ;

       ListNode result =  tmp.addTwoNumbers(l1 ,l2) ;

        System.out.println(result.val + "     "+ result.next.val);


    }




}
