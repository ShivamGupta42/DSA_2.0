package Trees.Equality;

public class CorrespondingNodeInClonedTree_LC1379 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }


        public final TreeNode getTargetCopy
                (final TreeNode original, final TreeNode cloned, final TreeNode target) {

            if (original == null || cloned == null) {
                return null;
            }

            if (original == target) {
                return cloned;
            }

            TreeNode res = getTargetCopy(original.left, cloned.left, target);

            if (res != null) {
                return res;
            }
            return getTargetCopy(original.right, cloned.right, target);

        }

    }
}