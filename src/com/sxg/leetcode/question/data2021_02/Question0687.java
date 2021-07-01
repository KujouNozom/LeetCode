package com.sxg.leetcode.question;

import com.sxg.leetcode.entity.TreeNode;

/**
 * @ClassName: Question0687
 * @Author: Su_N
 * @Date: 2021/2/23 23:38
 * @Description: 687. 最长同值路径
 */
public class Question0687 {
    private int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        function(root);
        return ans;
    }

    private int function(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val;

        int leftMaxLength = function(root.left);
        int rightMaxLength = function(root.right);

        int currentMaxLaength = 0;
        int maxLength = 0;
        if (root.left != null && root.left.val == val) {
            leftMaxLength += 1;
            maxLength = Math.max(maxLength, leftMaxLength);

            currentMaxLaength += leftMaxLength;
        }
        if (root.right != null && root.right.val == val) {
            rightMaxLength += 1;
            maxLength = Math.max(maxLength, rightMaxLength);
            currentMaxLaength += rightMaxLength;
        }

        ans = Math.max(ans, currentMaxLaength);
        return maxLength;
    }
}
