package DiYCross;

public class SquareRoot1 {
    public static void main(String[] args){
        SquareRoot1 sol = new SquareRoot1();
        int x= 6666666;
        System.out.println(sol.sqrt(x));
    }
    public int sqrt(int x) {
        // Write your solution here
        if(x == 0 || x == 1){
            return x;
        }
        int left = 1;
        int right = x/2;
        int ans = 0;
        while(left < right){
            int mid = left + (right - left)/2;
            if(mid * mid == x){
                return mid;
            }else if(mid > x / mid){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }


        return right;

    }
}
