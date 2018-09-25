package indi.hbn.algorithm.leetcode.Algorithms;

import java.util.Arrays;

/**
 * @author wangheng
 * @create 2018-09-19 下午1:39
 * @desc
 **/
public class _4 {
    /**
     * 求中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 ==null) return getMedian(nums2);
        if(nums2 ==null) return getMedian(nums1);
        int lengthA = nums1.length ;
        int lengthB = nums2.length ;
        int [] allNums = new int[lengthA+lengthB];
        System.arraycopy(nums1,0,allNums,0,lengthA);
        System.arraycopy(nums2,0,allNums,lengthA,lengthB);
        Arrays.sort(allNums);
        return getMedian(allNums);

    }

    public double getMedian(int [] allNums){
        int length = allNums.length ;
        if(length%2 ==1){
            return 0.0 + allNums[length/2 +1];
        }else {
            return (0.0 + allNums[length/2-1] +allNums[length/2 ])/2;
        }
    }


    public double getMedian2(int[] nums1, int[] nums2){

        if (nums1 ==null) return getMedian(nums2);
        if(nums2 ==null) return getMedian(nums1);
        int lengthA = nums1.length -1;
        int lengthB = nums2.length -1 ;
        int [] allNums = new int[nums1.length +nums2.length];
        int index = allNums.length -1 ;


        while (lengthA >=0 && lengthB >=0 && index>=0){
            System.out.println( lengthA + "  " + lengthB +"  " +index);

            if (nums1[lengthA] > nums2[lengthB])
            {
                allNums[index] = nums1[lengthA];
                --lengthA;
                --index;
            }else {
                allNums[index] = nums2[lengthB];
                --lengthB;
                --index ;
            }
        }

        while(lengthA >=0){
            allNums[index] = nums1[lengthA];
            --lengthA;
            --index;

        }
        while (lengthB >=0){
            allNums[index] = nums2[lengthB];
            --lengthB;
            --index ;
        }

        return  getMedian(allNums);

    }



    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        //等于最小的一个数的  长度
        int high = x;
        while(low <= high) {
            int partitionX = (low+high) / 2;
            int partitionY = (x+y+1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if((x+y) % 2==0)
                    return ((double)Math.max(maxLeftX, maxLeftY) + (double)Math.min(minRightX, minRightY)) / 2;
                else
                    return Math.max(maxLeftX, maxLeftY);
            }
            else if(maxLeftX > minRightY)
                high = partitionX - 1;
            else
                low = partitionX + 1;
        }
        throw new IllegalArgumentException();
    }
}
