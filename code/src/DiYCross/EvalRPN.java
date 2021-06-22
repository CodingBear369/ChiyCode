package DiYCross;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRPN {
    public static void main(String[] args){
        EvalRPN sol = new EvalRPN();
        String[] s = {"0","12","4","+","-"};

        System.out.println(sol.evalRPN(s));
    }
    public int evalRPN(String[] tokens) {
        // Write your solution here
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < tokens.length; i++){
            String tmp = tokens[i];
            if(isNumeric(tmp)){
                stack.offerFirst(Integer.valueOf(tmp));
            }else{
                char operator = tmp.charAt(0);
                int first = stack.pollFirst();
                int second = stack.pollFirst();
                if(operator == '+'){
                    stack.offerFirst(second + first);
                }else if(operator == '-'){
                    stack.offerFirst(second - first);
                }else if(operator == '*'){
                    stack.offerFirst(second * first);
                }else if(operator == '/'){
                    stack.offerFirst(second / first);
                }
            }
        }
        return stack.pollFirst();
    }
    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
}
