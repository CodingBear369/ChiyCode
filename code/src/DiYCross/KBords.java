package DiYCross;

public class KBords {
    public static void main(String[] args){
        KBords sol = new KBords();
        int[] boards = {3,6,5,5};
        System.out.println(sol.minCut(boards,2));
    }
    public int minCut(int[] boards, int k){
        int n = boards.length;
        return helper(boards,n,k);
    }


    private int helper(int[] boards, int n, int k){
        if(k == 1){
            return sum(boards,0,n-1);
        }
        if(n == 1){
            return boards[0];

        }

        int best = Integer.MAX_VALUE;
        for(int i =0; i <=n; i++){
            best = Math.min(best, Math.max(helper(boards,i,k-1),sum(boards,i,n-1)));
        }
        return best;
    }


    private int sum(int arr[], int from, int to){
        int total = 0;
        for (int i = from; i <= to; i++)
            total += arr[i];
        return total;
    }
}
