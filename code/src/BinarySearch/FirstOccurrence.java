package BinarySearch;

public class FirstOccurrence {
    public static void main(String[] args){
        FirstOccurrence sol = new FirstOccurrence();
        int[] arr = {1,2,2,3,3,4};
        int target = 3;
        int target2 = 0;
        System.out.println(sol.firstOccurrence(arr,target) +"\n"+ sol.firstOccurrence(arr,target2));
    }
    public int firstOccurrence(int[] array, int target){

        if(array == null){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;

        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(array[mid] == target){
                right = mid;
            }else if(array[left] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(array[left] == target){
            return left;
        }else if(array[right] == target){
            return right;
        }else{
            return -1;
        }
    }
}
