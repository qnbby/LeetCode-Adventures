// no shot this is a medium problem dawg
// returns an array of multiplicative of all numbers except for itself. 
// approach: O(2n) first iteration: go through all of array and multiply them all together. keep track of total number of 0s and DONT include in the multiply holder
// if num 0 > 2, means that if not include a 0 still include the other 0 so just return an array of 0s. 
// else then 2nd iteration: with the new product holder, iterate through each element and replace it with the product divided by itself
// if num 0 == 1, skip all elements except for the one with value == 0, then set it to product and DONE
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zCount = 0;
        int product = 1;
        int length = nums.length;
        int [] ans = new int[length];
        for (int i : nums)
        {
            if (i != 0) product *= i;
            else
                zCount++;
        }

        if (zCount > 1) return ans;

        for (int i = 0; i < length; i++)
        {
            if (zCount == 1)
            {
                if (nums[i] == 0)
                {
                    ans[i] = product;
                    break;
                }
            }
            else
                ans[i] = product / nums[i];
        }

        return ans;
    }
}