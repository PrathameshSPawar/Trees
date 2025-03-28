class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null || root.val==val) return root;
        TreeNode left=searchBST(root.left,val);
        return left!=null ? left : searchBST(root.right,val);
    }
}

//easy version
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)
        {
            return null;
        }
        if(root.val==val)
        {
            return root;
        }
        TreeNode left=searchBST(root.left,val);
        if(left!=null)
        {
            return left;
        }

        return searchBST(root.right,val);
    }
}
