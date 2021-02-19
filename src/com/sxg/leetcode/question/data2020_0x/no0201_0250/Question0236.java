package com.sxg.leetcode.question.data2020_0x.no0201_0250;

import com.sxg.leetcode.entity.TreeNode;

/**
 * @ClassName: Question0236
 * @Author: Su_N
 * @Date: 2020/7/4 19:44
 * @Description: 使用一个堆栈
 * 先深度抖索获取起一个元素
 * 当获取到异地个元素的时候，这个时候堆栈里面就是他的父节点的路径
 * 之后每取出一个元素，进行深搜，搜索到第二个元素的时候，就是最近的公共父节点
 * （堆栈里面可以不放根节点，因为如果搜索到根节点的时候，根节点必然是公共父节点）
 *
 * 思路有问题，看了官方的思路才知道，自己太他吗菜了
 *
 * 我们递归遍历整棵二叉树，定义 fxf_xfx​ 表示 xxx 节点的子树中是否包含 ppp 节点或 qqq 节点，如果包含为 true，否则为 false。那么符合条件的最近公共祖先 xxx 一定满足如下条件：
 *
 * (flson && frson) ∣∣ ((x = p ∣∣ x = q) && (flson ∣∣ frson))(f_{\text{lson}}\ \&\&\ f_{\text{rson}})\ ||\ ((x\ =\ p\ ||\ x\ =\ q)\ \&\&\ (f_{\text{lson}}\ ||\ f_{\text{rson}})) (flson​ && frson​) ∣∣ ((x = p ∣∣ x = q) && (flson​ ∣∣ frson​))
 *
 * 其中 lson\text{lson}lson 和 rson\text{rson}rson 分别代表 xxx 节点的左孩子和右孩子。初看可能会感觉条件判断有点复杂，我们来一条条看，flson && frsonf_{\text{lson}}\ \&\&\ f_{\text{rson}}flson​ && frson​ 说明左子树和右子树均包含 ppp 节点或 qqq 节点，如果左子树包含的是 ppp 节点，那么右子树只能包含 qqq 节点，反之亦然，因为 ppp 节点和 qqq 节点都是不同且唯一的节点，因此如果满足这个判断条件即可说明 xxx 就是我们要找的最近公共祖先。再来看第二条判断条件，这个判断条件即是考虑了 xxx 恰好是 ppp 节点或 qqq 节点且它的左子树或右子树有一个包含了另一个节点的情况，因此如果满足这个判断条件亦可说明 xxx 就是我们要找的最近公共祖先。
 *
 * 你可能会疑惑这样找出来的公共祖先深度是否是最大的。其实是最大的，因为我们是自底向上从叶子节点开始更新的，所以在所有满足条件的公共祖先中一定是深度最大的祖先先被访问到，且由于 fxf_xfx​ 本身的定义很巧妙，在找到最近公共祖先 xxx 以后，fxf_xfx​ 按定义被设置为 true ，即假定了这个子树中只有一个 ppp 节点或 qqq 节点，因此其他公共祖先不会再被判断为符合条件。
 *
 * 下图展示了一个示例，搜索树中两个节点 9 和 11 的最近公共祖先。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 236. 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */
public class Question0236 {
    private TreeNode ans;


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

}
