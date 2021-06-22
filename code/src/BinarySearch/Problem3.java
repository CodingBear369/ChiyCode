package BinarySearch;

import java.util.Arrays;

public class Problem3{
    public static void main(String[] args){
        Problem3 sol = new Problem3();
        System.out.println(sol.minBox(7));
    }
    public int minBox(int input) {
        int[] M = new int[input + 1];
        Arrays.fill(M, Integer.MAX_VALUE);
        M[0] = 0;
        for (int i = 0; i <= input; i++) {
            for (int j = 1; j * j <= i; j++) {
                M[i] = Math.min(M[i], M[i - j * j] + 1);
            }
        }
        return M[input];
    }

}
