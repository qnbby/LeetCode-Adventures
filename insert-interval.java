// took me too long to do this
// array traversal - index tracking
// comments explains my approach 
// main point: keep an eye of out of bound tracker comments and think why they lie there. 
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int [][] {newInterval}; // out of bound check
        ArrayList<int[]> ins = new ArrayList<>();
        int index = 0;
        for (int[] i : intervals) // go through all unecessary intervals
        {
            if (i[1] < newInterval[0])
            {
                ins.add(i);
                index++;
            }
            else
                break;
        }   
        if (index >= intervals.length)
        {
            ins.add(newInterval);
            int[][] intArray = new int[ins.size()][];

            for (int i = 0; i < ins.size(); i++) {
                intArray[i] = ins.get(i);
            }
            return intArray;
        }
        int startVal = 0;
        int endVal = 0;
        // if got here, means that intervals[index][1] > newInterval[0]
        // case 1: intervals[index][0] < newInterval[0] -> start val = intervals[index][0]
        if (intervals[index][0] < newInterval[0])
        {
            startVal = intervals[index][0];
            if (index + 1 >= intervals.length) endVal = intervals[index][1] > newInterval[1] ? intervals[index][1] : newInterval[1]; // out of bound check
        }         
        // case 2: intervals[index][0] > newInterval[0]
        else
        {
            startVal = newInterval[0];
            if (index + 1 >= intervals.length) endVal = intervals[index][1] > newInterval[1] ? intervals[index][1] : newInterval[1]; // out of bound check
        }


        while (index < intervals.length)
        {
            if (intervals[index][1] < newInterval[1])
            {
                index++;
                if (index >= intervals.length) endVal = newInterval[1]; // out of bound check
                continue;
            }
            else
            {
                if (newInterval[1] < intervals[index][0])
                {
                    endVal = newInterval[1];
                    break;
                }
                else
                {
                    endVal = intervals[index][1];
                    index++;
                    break;
                }

            }

        }
        ins.add(new int[] {startVal, endVal});

        while (index < intervals.length)
        {
            ins.add(intervals[index]);
            index++;
        }
        int[][] intArray = new int[ins.size()][];

        for (int i = 0; i < ins.size(); i++) {
            intArray[i] = ins.get(i);
        }
        return intArray;
    }
}