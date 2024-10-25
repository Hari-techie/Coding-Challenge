import java.util.*;

public class ReverseWord {

    public static void funStack(String s) {
        Stack<String> stack = new Stack<>();
        s += " ";
        String temp = "";
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) != ' ') {
                temp += s.charAt(i);
            }
            else {
                stack.push(temp);
                temp = "";
            }
        }

        String ans = "";
        while(!stack.isEmpty()) {
            ans = ans + stack.pop() + " ";
        }
        System.out.println(ans);
    }

    public static void funLoop(String s) {
        String ans = "";
        String temp = "";
        s += " ";
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) != ' ') {
                temp += s.charAt(i);
            }
            else {
                ans = temp + " " + ans;
                temp = "";
            }
        }
        if(temp!= " ") {
            ans = temp + " " + ans;
        }
        System.out.println(ans);
    }

    public static void main(String [] args) {
        String s = "Have no Fear Hari is here";
        // funStack(s);
        funLoop(s);
    }
}