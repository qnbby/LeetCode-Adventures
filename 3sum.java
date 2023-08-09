// looked-up solution; mine worked but runtime exceed 
// approach: sort array first: O(nlogn)
// traverse sorted array: O(n^2) adding smallest && largest value together (only - and + sum make a 0)
// if too small, j++ , too big -> k-- --> prevents dup incrementer 
// hashset prevents same triplets
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List <List<Integer>> summer = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
        {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k)
            {
                int summ = nums[i] + nums[j] + nums[k];
                if (summ == 0)
                {
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if (summ < 0)
                    j++;
                else
                    k--;
            }
        }
        summer.addAll(s);
        return summer;
    }
}