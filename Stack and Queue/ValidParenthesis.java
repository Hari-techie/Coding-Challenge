import java.util.Stack;

/*
 * Problem Statement: Check Balanced Parentheses. Given string str containing just the characters '(', ')', '{', '}', '[' and ']', 
 * check if the input string is valid and return true if the string is balanced otherwise return false.

Note: string str is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Example 1:

Input: str = "( )[ { } ( ) ]"

Output: True

Explanation: As every open bracket has its corresponding 
close bracket. Match parentheses are in correct order 
hence they are balanced.
Example 2:

Input: str = "[ ( )"

Output: False

Explanation: As '[' does not have ']' hence it is 
not valid and will return false.
 */

public class ValidParenthesis {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == ' ') {
                continue;
            }
            else if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            else {
                char item = stack.pop();
                if(stack.isEmpty()) {
                    return false;
                }
                else if((item == '(' && s.charAt(i) == ')') || (item == '{' && s.charAt(i) == '}') || (item == '[' && s.charAt(i) == ']')) {
                   continue;
                }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // String str = "( )[ { } ( ) ]";
        String str = "[ ( )";
        System.out.println(isValid(str));
    }    
}
