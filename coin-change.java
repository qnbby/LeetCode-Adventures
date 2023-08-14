// dp problem
// approach: create an array of all amounts, then test the minimum amount of coins required to match amount
// ex: coins = {4,5,6} , am = 6
// array = {0,7,7,7,7,7,7}
// run1: {0,7,7,7,7,7,7}
// run2: {0,7,7,7,7,7,7}
// run3: {0,7,7,7,7,7,7}
// run4: {0,7,7,1,7,7,7}
// run5: {0,7,7,1,1,7,7}
// run6: {0,7,7,1,1,7,7} ; 6 - 4 = 2 ->total[6] = 7; total[2] = 7
// -> return -1

class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        int [] total = new int[amount+1];
        Arrays.fill(total, amount+1);
        total[0] = 0;

        for (int i = 1; i < total.length; i++)
        {
            for (int c : coins)
                if (i - c >= 0)
                    total[i] = Math.min(total[i], total[i-c] + 1);
        }
        
        return total[amount] > amount ? -1 : total[amount];
    }
}