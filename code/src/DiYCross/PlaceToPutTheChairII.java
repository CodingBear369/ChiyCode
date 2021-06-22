package DiYCross;

import java.util.ArrayList;
import java.util.List;

public class PlaceToPutTheChairII {
    public static void main(String[] args){
        PlaceToPutTheChairII sol = new PlaceToPutTheChairII();
        char[][] gym = {{' ',' ',' ',' ',' '},{' ',' ',' ',' ','E'},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '}};
        System.out.println(sol.putChair(gym));
    }
    public List<Integer> putChair(char[][] gym) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if(gym == null || gym.length == 0){
            return res;
        }
        List<Integer> rows = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();

        int m = gym.length;
        int n = gym[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(gym[i][j] == 'E'){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
//        for(int j = 0; j < n; j++){
//            for(int i = 0; i < m; i++){
//                if(gym[i][j] == 'E'){
//                    columns.add(j);
//                }
//            }
//        }


        res.add(rows.get(rows.size()/2));
        res.add(columns.get(columns.size()/2));

        return res;
    }
}
