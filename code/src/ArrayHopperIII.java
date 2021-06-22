
public class ArrayHopperIII {
    public static void main(String[] args){
        ArrayHopperIII sol = new ArrayHopperIII();
        int[] arr = {1, 3, 0};
        System.out.println(sol.minJump(arr));
    }
    public int minJump(int[] array) {
        // Write your solution here
        int[] minJumpArr = new int [array.length+1];
        minJumpArr[0] = 0;
        for(int i = 1; i < minJumpArr.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++){
                if(minJumpArr[j] != -1 && array[j] + j >= i){
                    min = Math.min(min, minJumpArr[j]+1);
                }
            }
            minJumpArr[i] = min==Integer.MAX_VALUE ? -1 : min;
        }


        return minJumpArr[minJumpArr.length-1];
    }
}
