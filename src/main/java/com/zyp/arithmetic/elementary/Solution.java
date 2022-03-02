package com.zyp.arithmetic.elementary;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
  /*  给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    你可以按任意顺序返回答案。*/
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j && nums[i]+nums[j]==target){
                  return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
    @Test
    public void twoSumTest(){
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4},6)));
    }

    public int[] twoSumOther(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }

        return indexs;
    }
    @Test
    public void twoSumOtherTest(){
        System.out.println(Arrays.toString(twoSumOther(new int[]{5,5,7},10)));
    }
}
