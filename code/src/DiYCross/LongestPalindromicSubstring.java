package DiYCross;

public class LongestPalindromicSubstring {
    public static void main(String[] args){
        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
        String s = "bcbccaacdca";
        System.out.println(sol.longestPalindrome(s));
    }
    public String longestPalindrome(String input) {
        // Write your solution here
        int[] array = new int[input.length()+1];
        array[0] = 1;
        int max = 1;
        int max_left = 0;
        int max_right = 0;
        for(int i = 1; i <= input.length(); i++){
            int cur = 1;
            for(int j = 0; j < i; j++){
                if(isPalindrome(input.substring(j,i))){
                    cur = i-j;
                    if(cur > max){
                        max = cur;
                        max_left = j;
                        max_right = i;

                    }
                }
            }
            array[i] = cur;

        }
        return input.substring(max_left,max_right);
    }

    private boolean isPalindrome(String input){
        int left = 0;
        int right = input.length()-1;
        while(left <= right){
            if(input.charAt(left) != input.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
