/*You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1. */


/* Key Insights:
In-place merging: Instead of merging the arrays from the beginning, we start from the end. This allows us to avoid overwriting elements in nums1 before we have merged them.

Two pointers: We can use two pointers to traverse the two arrays: one pointer starting from the end of the valid elements in nums1 and another from the end of nums2. Then, we fill nums1 from the back to the front.

Plan:
Start from the end: The last element of nums1 is at index m + n - 1. The valid elements of nums1 are in the range 0 to m-1, and the elements of nums2 are in the range 0 to n-1.

Compare and insert: Start by comparing the elements at the current pointers of nums1 and nums2. The larger of the two should be placed at the last position in nums1.

Move the pointers: After placing an element, move the corresponding pointer one step left (decrement the pointer).

Handle remaining elements: If nums2 still has elements left after nums1 is exhausted, copy the remaining elements of nums2 into nums1. No need to do anything for nums1 as it is already sorted. */

public class MergeSortedArray {
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
         // Start from the end of both arrays
         int i = m - 1;  // Pointer for the last valid element in nums1
         int j = n - 1;  // Pointer for the last element in nums2
         int k = m + n - 1; // Pointer for the last position in nums1
 
         // Merge the arrays starting from the end
         while (i >= 0 && j >= 0) {
             if (nums1[i] > nums2[j]) {
                 nums1[k--] = nums1[i--];
             } else {
                 nums1[k--] = nums2[j--];
             }
         }
 
         // If there are remaining elements in nums2, copy them
         while (j >= 0) {
             nums1[k--] = nums2[j--];
         }
     }

     public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);

        for (int i : nums1) {
            System.out.print(i+" ");
        }

        /*Initially:

        nums1 = [1, 2, 3, 0, 0, 0]

        nums2 = [2, 5, 6]

        We start comparing from the end:

        Compare 3 (from nums1) and 6 (from nums2), since 6 > 3, we place 6 in the last position of nums1.

        Compare 3 and 5, 5 > 3, so place 5.

        Compare 3 and 2, 3 > 2, so place 3.

        Compare 2 and 2, 2 == 2, so place 2.

        Now, nums1 is [1, 2, 2, 3, 5, 6]. */
     }
}

/*Explanation of the Code:
Initialization:

i points to the last valid element in nums1 (i.e., m - 1).

j points to the last element in nums2 (i.e., n - 1).

k points to the last position in nums1 (i.e., m + n - 1).

Merging:

We compare nums1[i] and nums2[j]:

If nums1[i] > nums2[j], we place nums1[i] at position k and decrement both i and k.

If nums2[j] >= nums1[i], we place nums2[j] at position k and decrement both j and k.

We continue this process until either i or j becomes negative.

Copying remaining elements from nums2:

If there are still elements in nums2 that haven't been merged (i.e., j >= 0), we copy the remaining elements from nums2 to nums1.

No need to copy elements from nums1: If i >= 0, the remaining elements in nums1 are already in the correct place because they were placed there earlier. */
