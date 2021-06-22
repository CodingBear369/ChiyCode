package BinarySearch;

public class SearchInSortedMatrixI {
    public int[] search(int[][] matrix, int target) {
        // Write your solution here
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if(matrix == null){
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(matrix[mid/col][mid%col] == target){
                res[0] = mid/col;
                res[1] = mid%col;
                return res;
            }else if(matrix[mid / col][mid % col] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }
}
