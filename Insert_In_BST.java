This can be solve by many ways like iterative ,recursive etc
class Solution{
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newN=new TreeNode(val);
        if(root==null) return newN;
        TreeNode prev=null,curr=root;
        while(curr!=null)
        {
            prev=curr;
            if(curr.val>val) curr=curr.left;
            else curr=curr.right;
        }
        if(prev.val>val) prev.left=newN;
        else prev.right= newN;
        return root;
  }
}

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //TreeNode newN=new TreeNode(val);
        if(root==null) return new TreeNode(val);
        if(root.val > val) root.left = insertIntoBST(root.left,val);
        else root.right =insertIntoBST(root.right,val);
        return root;
    }
}
