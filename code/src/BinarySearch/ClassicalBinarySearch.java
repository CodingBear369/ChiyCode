package BinarySearch;

public class ClassicalBinarySearch {
    public static void main(String[] args){
        ClassicalBinarySearch sol = new ClassicalBinarySearch();
        int[] arr = {1,2,3,4,5};
        int target = 5;
        int target1 = 0;
        System.out.println(sol.binarySearch(arr,target));
        System.out.println(sol.binarySearch(arr,target1));
    }

    public Boolean binarySearch(int[] array, int target){
        // corner case
        if(array.length == 0 || array == null){
            return false;
        }
        int left = 0;
        int right = array.length -1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(array[mid] == target){
                return true;
            }else if(array[mid] < target){
                left = mid + 1;
            }else if(array[mid] > target){
                right = mid - 1;
            }
        }
        return false;
    }
}
