package BinarySearch;

public class Problem4 {


    public static void main(String[] args){
        Problem4 sol = new Problem4();
        String[] arr = new String[]{"ALICE","CHARLES","ERIC","SOPHIA"};
        System.out.println(sol.canFormLoop(arr));
    }
    public boolean canFormLoop(String[] array){
        return dfs(array,1);
    }
    private boolean dfs(String[] array, int i){
        if(i == array.length){
            return canSit(array[i - 1], array[0]);
        }
        for(int j = i; j < array.length; j++){
            if(canSit(array[i - 1],array[j])){
                swap(array, i , j);
                if(dfs(array, i + 1)){
                    return true;
                }
                swap(array,i,j);
            }

        }
        return false;
    }

    private boolean canSit(String first, String second){
        return first.charAt(first.length() - 1) == (second.charAt(0));
    }
    private void swap(String[] array, int i, int j){
        String tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
