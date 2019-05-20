package cn.liuhp.binarytree;

/**
 * @description: 二叉查找树
 * @author: hz16092620
 * @create: 2019-05-20 10:39
 */
public class BSTree<T extends Comparable> {

    private BSNode mRoot;//根节点


    /*节点*/
    private class BSNode<T> {
        private T key;//节点数据
        private BSNode<T> parent;//父节点
        private BSNode<T> left;//左子树
        private BSNode<T> right;//右子树

        public BSNode (T key, BSNode<T> parent, BSNode<T> left, BSNode<T> right) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }


}
