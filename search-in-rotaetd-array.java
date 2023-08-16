// spent way more time in this problem than i thought.
// find the part of the array (at target) of where it might have merged wrong. 
// approach: similar to searching sorted array in logn time, but keep track of max and min by checking if the top half and bottom half are sorted

class Solution {
    public int search(int[] nums, int target) {
        int max = nums.length - 1;
        int min = 0;
        int curr;

        while (max >= min)
        {
            curr = (max + min) / 2;
            
            if (nums[curr] == target) 
                return curr;
                
            if (nums[min] <= nums[curr])
            {
                if (nums[min] <= target && nums[curr] > target)
                    max = curr - 1;
                else
                    min = curr + 1;
            }
            else 
            {
                if (nums[curr] < target && target <= nums[max])
                    min = curr + 1;
                else
                    max = curr - 1;
            }
        }

        return -1;
    }
}