// stack stack pop stack stack
// this problem is explained easily by giving an example of how my code works
//ex: (2 + 3)* 5) - > String [] tokens = {"2", "3", "+", "10", "/"};
// we have stack initialized: stack = {}
// we go through string
// 2: stack = {2};
// 3: stack = {2,3};
// +: pop 2, 3, perform operation 2 + 3 = 5; push stack = {5};
// 10: stack = {5,10};
// /: pop 5, 10, perform operation 10 / 5 = 2; push stack = {2};
// end loop -> return only value in stack -> stack.pop() = 2; 

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        List<String> operatorList = List.of("+", "-", "*", "/");
        // int final = Integer.MIN_VALUE;
        for (String s : tokens)
        {
            if(!operatorList.contains(s))
                stack.push(s);
            else
            {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if (s.equals("+")) stack.push(Integer.toString(num1 + num2));
                else if (s.equals("-")) stack.push(Integer.toString(num2 - num1));
                else if (s.equals("*")) stack.push(Integer.toString(num1 * num2));
                else if (s.equals("/")) stack.push(Integer.toString(num2 / num1));
            }
        }
        return Integer.parseInt(stack.pop());
    }
}