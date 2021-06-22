package DiYCross;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ArrayHopperIV {
    public static void main(String[] args){
        ArrayHopperIV sol = new ArrayHopperIV();
        int[] arr = {4,2,1,2,0,0};
        System.out.println(sol.minJump(arr,1));
    }
    public int minJump(int[] array, int index) {
        // Write your solution here
        if(array.length == 1 || index == array.length - 1){
            return 0;
        }
        Entity[] entityArr = new Entity[array.length];
        for(int i = 0; i < array.length; i++){
            entityArr[i] = new Entity(i,array[i]);
        }
        Set<Integer> set =new HashSet<>();

        Queue<Entity> queue = new LinkedList<>();
        queue.offer(entityArr[index]);
        int minStep = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            minStep++;
            for (int j = 0; j < size; j++){
                Entity tmp = queue.poll();
                if(tmp.index == array.length-1){
                    return minStep;
                }
                if(tmp.index + tmp.val >= array.length-1 ){
                    return minStep;
                }
                for(int i = 1; i <= tmp.val;i++){
                    if(tmp.index + i < array.length && set.add(tmp.index + i)){
                        queue.offer(entityArr[tmp.index+i]);
                    }
                    if(tmp.index - i >= 0 && set.add(tmp.index - i)){
                        queue.offer(entityArr[tmp.index-i]);
                    }
                }
            }

        }
        return -1;
    }

    private static class Entity{
        int index;
        int val;
        Entity(int index, int val){
            this.index = index;
            this.val = val;
        }
    }
}
