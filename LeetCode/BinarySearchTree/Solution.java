package BinarySearchTree;

/*🔹 Approach:
This is a divide and conquer problem.

Use the middle element of the array as the root node.

Recursively do the same for the left and right halves of the array to construct the left and right subtrees.

This ensures the tree remains height-balanced. */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int left, int right) {
        // Base case
        if (left > right) return null;

        // Always choose middle element as root
        int mid = left + (right - left) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);   // Recursively build left subtree
        node.right = helper(nums, mid + 1, right); // Recursively build right subtree

        return node;
    }
}

/*🔹 Explanation:
The helper function does the recursive work.

mid = (left + right) / 2 gives the middle index to pick as root.

Recursively call helper on the left half and right half to build subtrees.

🔹 Time and Space Complexity:
Time: O(n) – we visit each node exactly once.

Space: O(log n) – recursion stack height (balanced tree). */