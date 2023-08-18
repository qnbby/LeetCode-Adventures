// given an array of int, return the total permutaions of them (permutation: order matters)
// approach O(n*n!): have an index to keep track of chosen element. traverse thru num array
// If number is contained in the permutation array, consider next element. Else, add element to array, then run recursive solve with added element in array
// then remove element; choose next element in array instead
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List <List<Integer>> ans = new ArrayList<>();
        int [] holder = new int[nums.length];
        Arrays.fill(holder, 11);
        solve(ans, nums, holder, 0);

        return ans;
    }

    public void solve (List<List<Integer>> ans, int [] nums, int [] per, int index)
    {
        if (index == nums.length)
        {
            List<Integer> permutation = new ArrayList<>();
            for (int num : per) {
                permutation.add(num);
            }
            ans.add(permutation);
            return;
        }
        for (int i = 0; i < nums.length; i++)
        {
            if (per[i] == 11) 
            {
                per[i] = nums[index];
                solve(ans, nums, per, index + 1);
                per[i] = 11;
            }
                
        }
    }

}