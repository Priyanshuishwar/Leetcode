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
    public long kthLargestLevelSum(TreeNode root, int k) {
        // if(root == null){
        //     return 0;
        // }
        Queue<TreeNode> q = new LinkedList<>();
        List<Long> li = new ArrayList<>();

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            long sum = 0;

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                sum += node.val;

                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            li.add(sum);
           
        }
        if(li.size() < k){
            return -1;
        }
        Collections.sort(li,Collections.reverseOrder());

        return li.get(k - 1);
    }
}