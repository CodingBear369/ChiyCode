package DiYCross;

public class InterleaveStrings {
    public static void main(String[] args){
        InterleaveStrings sol = new InterleaveStrings();
        String a = "abgcd";
        String b = "bebgf";
        String c = "babebggcfd";

        System.out.println(sol.canMerge(a,b,c));
    }
    public boolean canMerge(String a, String b, String c) {
        // Write your solution here

        if(a.length() + b.length() != c.length()){
            return false;
        }

        if(a.length() == 0){
            return b == c;
        }else if(b.length() == 0){
            return a == c;
        }

        StringBuilder res = new StringBuilder();
        char[] cArray = c.toCharArray();
        char[] aArray = a.toCharArray();


        // int j =0;
        // int k = 0;
        // for(int i = 0; i < cArray.length; i++){
        //   if(j < aArray.length && cArray[i] == aArray[j]){
        //     j++;
        //   }else if(j >= aArray.length){
        //     res.append(cArray[i]);
        //   }
        // }

        int slow = 0;
        int fast = 0;
        int index = 0;

        while(fast < cArray.length){
            if(index < aArray.length && cArray[fast] != aArray[index]){
                swap(cArray, fast, slow);
                slow++;
                index++;
            }

                if(slow >= aArray.length){
                res.append(new String(cArray,0,slow-1));
                break;
            }
            fast++;
        }

        return res.toString().equals(b);
    }

    private void swap(char[] arr, int left, int right){
        char tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
