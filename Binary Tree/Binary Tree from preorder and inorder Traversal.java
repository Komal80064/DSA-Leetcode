/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int preIdx;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0;
        for(int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return build(preorder, inorder, 0, inorder.length-1);
    }
    private TreeNode build(int[] preorder, int[] inorder, int left, int right){
        if(left> right) return null;

        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(rootVal);

        root.left = build(preorder, inorder, left , mid-1);
        root.right = build(preorder, inorder, mid+1, right);

        return root;
    }
}
