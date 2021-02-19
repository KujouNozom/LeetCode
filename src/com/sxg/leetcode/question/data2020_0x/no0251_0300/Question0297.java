package com.sxg.leetcode.question.data2020_0x.no0251_0300;

import com.sxg.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: com.sxg.leetcode.question.data2020_0x.no0251_0300.Question0297
 * @Author: Su_N
 * @Date: 2020/10/9 22:28
 * @Description: 深搜或者广搜，深搜可以是前中后序，我这里使用前序遍历
 * 前序遍历的时候需要null节点添加一个null
 * 反序列化的时候 遇到null，返回一个null节点
 *
 * 297. 二叉树的序列化与反序列化
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例:
 *
 * 你可以将以下二叉树：
 *
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */
public class Question0297 {
    public static void main(String[] args) {
        Question0297 demo = new Question0297();
        TreeNode root = demo.deserialize("1,2,3,null,null,4,null,null,5,null,null");
        System.out.println(demo.serialize(root));

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        dfsSerialize(ans, root);
        if (ans.length() > 0) {
            ans = ans.deleteCharAt(ans.length() - 1);
        }
        return ans.toString();
    }

    private void dfsSerialize(StringBuilder ans, TreeNode root) {
        if (root == null) {
            ans.append("null").append(",");
        } else {
            ans.append(root.val).append(",");
            dfsSerialize(ans, root.left);
            dfsSerialize(ans, root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = new ArrayList<>(Arrays.asList(data.split(",")));
        return dfsDeserialize(nodes);
    }

    private TreeNode dfsDeserialize(List<String> nodes) {
        if (nodes.isEmpty() || nodes.get(0).equals("null")) {
            if (!nodes.isEmpty()) {
                nodes.remove(0);
            }
            return null;
        } else {
            String val = nodes.get(0);
            nodes.remove(0);
            TreeNode treeNode = new TreeNode(Integer.valueOf(val));
            treeNode.left = dfsDeserialize(nodes);
            treeNode.right = dfsDeserialize(nodes);
            return treeNode;
        }
    }
}
