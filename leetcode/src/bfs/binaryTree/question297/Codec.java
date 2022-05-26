package bfs.binaryTree.question297;

import bfs.binaryTree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-05-26 21:00
 **/
public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder res = serialize_helper(root, new StringBuilder());
        return res.toString();
    }

    public StringBuilder serialize_helper(TreeNode root, StringBuilder str) {
        if (null == root) {
            str.append("#,");
            return str;
        }
        str.append(root.val);
        str.append(",");
        str = serialize_helper(root.left, str); // serialize the left subtree first
        str = serialize_helper(root.right, str);// after the left subtree is handled
        return str;
    }

    public TreeNode deserialize(String data) {
        String[] str_word = data.split(",");
        List<String> list_word = new LinkedList<String>(Arrays.asList(str_word));
        return deserialize_helper(list_word);
    }

    public TreeNode deserialize_helper(List<String> li) {
        // this tree is null, skip
        if (li.get(0).equals("#")) {
            li.remove(0);
            return null;
        }
        TreeNode res = new TreeNode(Integer.parseInt(li.get(0)));
        li.remove(0);
        // resolve left subtree and assign
        res.left = deserialize_helper(li);
        res.right = deserialize_helper(li);
        return res;
    }
}
