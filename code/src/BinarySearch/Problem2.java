package BinarySearch;

public class Problem2{
    public static void main(String[] args){
        Problem2 sol = new Problem2();
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        TreeNode five = root.left;
        five.left = new TreeNode(3);
        five.right = new TreeNode(10);
        TreeNode ten = five.right;
        ten.left = new TreeNode(8);


        System.out.println(sol.distance(root,five.left,root.right));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int distance(TreeNode root, TreeNode one, TreeNode two){
        if(one== null || two == null){
            return -1;
        }
        if(one == two){
            return 0;
        }
        TreeNode lowComAncestor = lowestCommonAncestor(root, one, two);
        int[] leftDis = new int[]{0};
        int[] rightDis = new int[]{0};
        findDistance(root,one,leftDis);
        findDistance(root,two,rightDis);
        return leftDis[0] + rightDis[0];
    }
    private void findDistance(TreeNode root, TreeNode node,int[] rightDis){
        if(root == null){
            return;
        }
        if(node.val == root.val){
            return;
        }else if(node.val < root.val){
            rightDis[0]++;
            findDistance(root.left,node,rightDis);
        }else{
            rightDis[0]++;
            findDistance(root.right,node,rightDis);
        }
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two){
        if(root == null || one == root || two == root){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);

        if(left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }
}
