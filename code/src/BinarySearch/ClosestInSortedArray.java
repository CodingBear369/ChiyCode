package BinarySearch;

public class ClosestInSortedArray {
    public static void main(String[] args){
        ClosestInSortedArray sol = new ClosestInSortedArray();
        int[] arr = {3,4,5,6,6,12,16};
        int target = 10;

        System.out.println(sol.closestInSortedArray(arr,target));
    }
    public int closestInSortedArray(int[] arr, int target){
        if(arr == null){
            return -1;
        }
        int left = 0;
        int right = arr.length -1;


        while(left < right -1){
            int mid = left + (right - left)/2;
            if(arr[mid] == mid){
                return mid;
            }else if(arr[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(Math.abs(arr[left] - target) < Math.abs(arr[right] - target)){
            return left;
        }else {
            return right;
        }
    }
}
