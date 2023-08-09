// Queue implementation
// longest substring so that no characters repeat
// logic: queue implementation: traverse thru string; if character not in queue, add character to queue
// if character in queue; push new max string size to subss, then remove the character from the front of list and add it to the end
// unecessary, but works as a way to keep track of substring length

import java.util.Queue;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int subss = 0;
        Queue<Character> queue = new LinkedList<>();
        int length = s.length();
        for (int i = 0; i < length; i++)
        {
            char curr = s.charAt(i);
            if (!queue.contains(curr))
                queue.add(curr);
            else
            {
                if (subss < queue.size())
                {
                    subss = queue.size();
                }
                while (queue.contains(curr))
                    queue.poll(); 
                queue.add(curr);
 
                
            }
        }
        // for (char i : queue)
        // {
        //     System.out.print(i + " ");
        // }
        if (subss < queue.size())
            subss = queue.size();
        return subss;
    }

}