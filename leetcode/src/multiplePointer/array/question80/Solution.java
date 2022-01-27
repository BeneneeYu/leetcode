package multiplePointer.array.question80;

/**
 * @program: leetcode
 * @description:给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *nums[fast]是第一个待检查的元素，nums[slow-1]是上一个应该被保留的元素所移动到的指定位置
 *  
 * @author: Shen Zhengyu
 * @create: 2021-04-06 15:15
 **/
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        //前两个是一定不用动的
        if (nums.length <= 2){
            return nums.length;
        }
        //一个指向下一个待检查元素的快指针，一个指向准备放置通过检查的元素的慢指针
        int slow = 2;
        int fast = 2;
        //当没有检查完毕时
        while(fast < n){
            //如果当前检查到的元素和准备放置的前一个元素的再前一个元素一样，那么就是三个元素一样，不可接受；否则可以放置
            if (nums[fast] != nums[slow -2]){
                //放置，并后移
                nums[slow++] = nums[fast];
            }
            //无论怎样都需要检查下一个
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
