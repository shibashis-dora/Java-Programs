/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 */

 /*Approach:
Start from the last digit (rightmost) of the array.

Add 1 to the last digit.

If the result is less than 10, you're done.

If the result is 10, set that digit to 0 and move to the next left digit, adding 1 to it.

Repeat this process until either there is no carry, or you run out of digits.

If you run out of digits (i.e., the number is all 9s), you'll need to add an extra digit (a 1 at the beginning of the array). */

public class PlusOne {

    public static int[] incrementLastByOne(int[] digits) {
        // Start from the last digit
        for (int i = digits.length - 1; i >= 0; i--) {
            // If the current digit is less than 9, just increment it and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If the current digit is 9, set it to 0 and continue
            digits[i] = 0;
        }
        
        // If all digits are 9, we need an extra digit at the front
        int[] result = new int[digits.length + 1];
        result[0] = 1; // Set the first digit to 1
        
        // The rest of the digits are already 0, no need to copy
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {9,9};
        int[] digits = incrementLastByOne(arr);
        for (int i : digits) {
            System.out.print(i+" ");
        }
    }
}

/*Explanation of the Code:
Loop through the digits in reverse order: We iterate over the digits starting from the least significant digit (rightmost), using the index i starting from digits.length - 1.

If the digit is less than 9, simply increment it by 1 and return the updated array of digits, because no carry is needed.

If the digit is 9, set it to 0 and move to the next left digit. This is because adding 1 to 9 causes a carry, so we need to handle it by resetting the current digit to 0.

If all digits are 9, it means the number was something like 999...99, so after the loop, we need to create a new array with an extra leading 1 followed by zeros. For example, [9, 9, 9] will become [1, 0, 0, 0]. */