package BinarySearch;

public class LastOccurrence {
    public static void main(String[] args){
        LastOccurrence sol = new LastOccurrence();
        int[] arr = {1,2,2,3,3,4};
        int target = 3;
        int target2 = 2;
        System.out.println(sol.lastOccurrence(arr,target) +"\n"+ sol.lastOccurrence(arr,target2));
    }
    public int lastOccurrence(int[] arr, int target){
        if(arr == null){
            return -1;
        }
        int left = 0;
        int right = arr.length -1;
        while(left < right -1){
            int mid = left + (right - left) / 2;
            if(arr[mid] <= target){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(arr[right] == target){
            return right;
        }else if(arr[left] == target){
            return left;
        }else{
            return -1;
        }
    }
}
