// rule: 1st value must be positive, last value must be positive
// runthrough: have 2 options: with a total sum, choose to leave the lower index number
// or leave the higher index number. If leave, subtract from total and incraese/decrease
// index 
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++)
        {
            currentSum += nums[i];

            if (currentSum > maxSum)
            {
                maxSum = currentSum;
            }

            if (currentSum < 0)
            {
                currentSum = 0;
            }
        }

        return maxSum;
    }
}