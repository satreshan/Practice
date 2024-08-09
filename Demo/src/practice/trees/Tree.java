package practice.trees;

public class Tree {
    int i=-1;
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;


        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    TreeNode createTree(int[] preorder){
        i++;
        if(preorder == null || preorder.length ==0)
            return null;
        if(preorder[i] == -1)
            return null;

        TreeNode node = new TreeNode(preorder[i]);
        node.left = createTree(preorder);
        node.right = createTree(preorder);
        return node;
    }

    void preorderTraversal(TreeNode root){
        if(root == null){
            return;
        }else {
            System.out.print(root.val + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        int[] values = {1,2,-1,-1,3,4,-1,-1,5,-1,-1};
        TreeNode root = t.createTree(values);
        System.out.print("PreorderTraversal:");
        t.preorderTraversal(root);
    }
}
