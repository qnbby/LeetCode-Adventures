// problem: find all combinations that add up to target. the numbers within the array candidates CAN repeat. 
// approach: dp? no. backtracking since it involves going back to previous choices to take a different route
// O(nlogn + 2^n) worst case [target <= 40 do it is a constant but I like considering n cases]
// self-explanatory: if target > candidate[i] return. else add it to the stack and recursively run the function with the target subtracted by the index.
// then, 
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        addList(0, candidates, target, ans, new Stack<Integer>());
        return ans;
    }
    public void addList(int index, int [] candidates, int target, List<List<Integer>> list, Stack<Integer> stack)
    {
        if (target == 0)
        {
            list.add(new ArrayList<>(stack));
            return;
        } 

        if (index == candidates.length || target - candidates[index] < 0) return;

        stack.push(candidates[index]);
        addList(index, candidates, target - candidates[index], list, stack);
        stack.pop();

        addList(index + 1, candidates, target, list, stack);
    }
}