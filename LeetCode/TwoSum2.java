/*
1. TwoSUm
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
 
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
 */

 /*Steps:
Initialize an empty hash map to store the numbers and their corresponding indices.

Loop through the array nums:

For each number num, calculate its complement: complement = target - num.

If the complement already exists in the hash map, it means we’ve found the two numbers that sum up to the target. In that case, return the current index and the index of the complement.

If the complement doesn't exist in the hash map, add the current number and its index to the hash map.

Since the problem guarantees exactly one solution, we don’t need to worry about multiple solutions or no solution. */

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 { 
    public static int[] twoSum(int[] nums, int target) {
        // Create a hash map to store the number and its index
        Map<Integer, Integer> map = new HashMap<>();
        
        // Loop through the nums array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];  // Calculate the complement
            
            // If the complement is already in the map, return the indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };  // return the stored index and current index
            }
            
            // Otherwise, add the current number and its index to the map
            map.put(nums[i], i);
        }
        
        // Return empty array if no solution is found (although the problem guarantees one solution)
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");

        int[] nums1 = {3,2,4};
        int target1 = 6;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Indices: [" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {3,3};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Indices: [" + result2[0] + ", " + result2[1] + "]");
    }
}

/*Explanation:
HashMap: We use a HashMap<Integer, Integer> where the key is the number itself, and the value is its index in the nums array.

Loop: We iterate through the array, and for each number num, we compute the complement (complement = target - num).

Check the map: If the complement exists in the map, that means we have found the pair of numbers that add up to the target. We then return the indices of these two numbers.

Store the number: If the complement is not found in the map, we add the current number and its index to the map for future reference. */