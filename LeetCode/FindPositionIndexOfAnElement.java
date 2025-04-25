/*
Given a sorted array of distinct integers and a target value, 
    Return the index if the target is found. 
    If not found, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 
Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4 
*/

public class FindPositionIndexOfAnElement {
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i + " : " + nums[i]);
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println("index: "+searchInsert(nums, target));
    }
}
