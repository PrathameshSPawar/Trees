class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left,root.right);
    }

    public boolean helper(TreeNode p,TreeNode  q)
    {
        if(p==null && q==null) return true;
        if((p!=null && q==null) || (p==null && q!=null) || (p.val!=q.val)) return false;

        return (helper(p.left,q.right) && helper(p.right,q.left));
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty())
        {
            TreeNode newLeft=queue.poll();
            TreeNode newRight=queue.poll();
            
            if(newLeft==null && newRight==null) continue;
            
            if(newLeft==null || newRight==null) return false;
            
            if(newLeft.val!=newRight.val) return false;

            queue.offer(newLeft.left);
            queue.offer(newRight.right);
            queue.offer(newLeft.right);
            queue.offer(newRight.left);
        }
        return true;
    }
}
