package cn.ben.test.binary;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 * @TIME 2018/8/7 14:31
 * @User yangkun
 * @DESCRIPTION
 */
public class BinaryTree {

    /**
     * 生成随机数组
     */
    private static int[] getRandomArray(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int nextInt = random.nextInt(10);
            array[i] = nextInt;
        }
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println("\n数组长度:" + array.length);
        return array;
    }

    /**
     * 生成二叉树
     */
    private static List<Node> getBinaryTree(int[] array) {
        List<Node> list = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            Node node = new Node(array[i]);
            list.add(node);
        }
        for (int i = 0; i < list.size() / 2 - 1; i++) {
            Node node = list.get(i);
            Node left = list.get(i * 2 + 1);
            Node right = list.get(i * 2 + 2);
            node.setLeft(left);
            node.setRight(right);

        }

        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        list.get(lastParentIndex).setLeft(list
                .get(lastParentIndex * 2 + 1));
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            list.get(lastParentIndex).setRight(list
                    .get(lastParentIndex * 2 + 2));
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = getRandomArray(200);
        List<Node> binaryTree = getBinaryTree(array);
//        System.out.println(binaryTree);
        int deep = getDeep(binaryTree.get(0));
        printTree(binaryTree.get(0), deep);
//        printNode(binaryTree.get(0),deep,0);
//        preTraver(binaryTree.get(0));
    }

    private static void printNode(Node node, int max, int deep) {
        if (node == null)
            return;
        for (int i = 0; i < max - deep; i++) {
            System.out.print("\t");
        }
        System.out.print(node.getLeft().getValue());
        for (int i = 0; i < deep; i++) {
            System.out.print("\t");
        }
        System.out.print(node.getRight().getValue());

    }

    public static void printTree(Node tree, int deep) {
        Queue queue = new LinkedList();
        Node last;
        Node nlast = null;
        Node tmpNode;
        queue.add(tree);
        last = tree;
        boolean b = true;
        while (!queue.isEmpty()) {
            tmpNode = (Node) queue.poll();
            if (null != tmpNode.getLeft()) {
                queue.add(tmpNode.getLeft());
                nlast = tmpNode.getLeft();
            }

            if (null != tmpNode.getRight()) {
                queue.add(tmpNode.getRight());
                nlast = tmpNode.getRight();
            }
            if (b) {
                for (int i = 0; i < Math.pow(2,deep-1); i++) {
                    System.out.print(" ");
                }
                b = false;
            }
            System.out.print(tmpNode.getValue());
            for (int i=0;i<Math.pow(2,deep)-1;i++){
                System.out.print(" ");
            }
            if (tmpNode.equals(last)) {
                System.out.print("\n");
                deep = deep - 1;
                b = true;
                last = nlast;
            } else {
                continue;
            }
        }
    }


    /**
     * 节点二叉树深度
     */
    private static int getDeep(Node node) {
        int i = 1;
        if (node == null) {
            return 0;
        }
        int deep = getDeep(node.getLeft());
        return i + deep;
    }


    /**
     * 先序遍历
     */
    public static void preTraver(Node node) {
        if (null == node)
            return;
        System.out.print(node.getValue() + "\t");
        preTraver(node.getLeft());
        preTraver(node.getRight());
    }

    /**
     * 中序
     */
    public static void midTraver(Node node) {
        if (null == node)
            return;
        midTraver(node.getLeft());
        System.out.print(node.getValue() + "\t");
        midTraver(node.getRight());
    }

    /**
     * 后序
     */
    public static void aftTraver(Node node) {
        if (null == node)
            return;
        aftTraver(node.getLeft());
        aftTraver(node.getRight());
        System.out.println(node.getValue());
    }

}


@Getter
@Setter
@ToString
class Node {
    private Node left;
    private Node right;
    private int value;

    Node(int value) {
        this.value = value;
    }
}

/**                                   n
                1                     5     16
        2               3             4     8          15
    4       5       6       7         3     4          7
  1   2   2   3   2   3   2   3       2     2          3
 1 2 3 4 5 6 7 8 1 2 3 4 5 6 7        1     1          1
                                      n     2的n-1方    2的n方-1
 */