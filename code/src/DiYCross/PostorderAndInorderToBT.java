package DiYCross;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostorderAndInorderToBT {
    public static void main(String[] args){
        PostorderAndInorderToBT sol = new PostorderAndInorderToBT();

        int[] post = new int[]{1, 4, 3, 11, 8, 5};
        int[] in = new int[]{1, 3, 4, 5, 8, 11};
        TreeNode root = sol.reconstruct(post,in);
        System.out.println(sol.postOrder(root));
    }

    static class TreeNode{
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }
    public TreeNode reconstruct(int[] inOrder, int[] postOrder) {
        // Write your solution here
        List<Integer> postList = new ArrayList<>();
        for(int val: postOrder){
            postList.add(val);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inOrder.length; i++){
            map.put(inOrder[i], i);
        }
        return helper(postList, map);
    }

    private TreeNode helper(List<Integer> postList, Map<Integer,Integer> map){
        if(postList.size() == 0){
            return null;
        }
        int val = postList.remove(postList.size() - 1);
        TreeNode root = new TreeNode(val);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for(int ele: postList){
            if(map.get(ele) < map.get(val)){
                left.add(ele);
            }else{
                right.add(ele);
            }
        }
        root.left = helper(left, map);
        root.right = helper(right, map);
        return root;
    }
    private List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper2(root,res);

        return res;
    }
    private void helper2(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }

        helper2(root.left,res);

        helper2(root.right,res);
        res.add(root.key);
    }
}
