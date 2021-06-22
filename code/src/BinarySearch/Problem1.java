package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    public static void main(String[] args){
        Problem1 sol = new Problem1();
        System.out.println(sol.decode("1121"));
    }

    public List<String> decode(String input){
        char[] arr = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        dfs(input,arr,sb,res,0);
        return res;
    }

    private void dfs(String input,char[] arr,StringBuilder sol,List<String> res,int level){
        //base case
        if(level == arr.length) {
            res.add(sol.toString());
            return;
        }
        int cur = arr[level] - '0';
        if(cur > 0 && cur <= 9){
            char tmp = (char) (cur - 1 + 'A');
            sol.append(tmp);
            dfs(input,arr,sol,res,level+1);
            sol.deleteCharAt(sol.length() - 1);
        }
        if(level + 1 < input.length()){
            int cur2 = (arr[level] - '0')* 10 + (arr[level+1] - '0');
            if(cur2 >= 10 && cur2 <= 26){
                char tmp = (char) (cur2 - 1 + 'A'); // A char is a single character, we can not cast cur2 to a char
                sol.append(tmp);
                dfs(input,arr,sol,res,level+2);
                sol.deleteCharAt(sol.length() - 1);
            }
        }

    }


}
