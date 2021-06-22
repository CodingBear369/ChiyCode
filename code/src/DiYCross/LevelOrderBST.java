package DiYCross;

public class LevelOrderBST {
    public static void main(String[] args){
        LevelOrderBST sol = new LevelOrderBST();

        int[] level = new int[]{5, 3, 8, 1, 4, 11};
        int[] in = new int[]{1, 3, 4, 5, 8, 11};
        TreeNode root = sol.reconstruct(level);
        System.out.println(root);
    }
    static class TreeNode{
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }
    public TreeNode reconstruct(int[] level) {
        // Write your solution here
        TreeNode root = null;
        for(int i = 0; i < level.length; i++){
            root = helper(root, level[i]);
        }
        return root;

    }

    private TreeNode helper(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(root.key > val){
            root.left = helper(root.left, val);
        }
        if(root.key < val){
            root.right = helper(root.right, val);
        }
        return root;
    }
}
