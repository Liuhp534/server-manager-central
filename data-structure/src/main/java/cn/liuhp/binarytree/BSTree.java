package cn.liuhp.binarytree;

/**
 * @description: 二叉查找树
 * @author: hz16092620
 * @create: 2019-05-20 10:39
 */
public class BSTree<T extends Comparable> {

    private BSNode<T> mRoot;//根节点


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

        public T getKey() {
            return key;
        }
    }

    /**
    * @Description: 删除数据
    * @param
    * @return
    * @throws
    * @author hz16092620
    * @date 2019/5/24 13:58
    */
    public T deleteByKey(T key) {
        return this.delete(key);
    }

    private T delete(T key) {
        BSNode<T> x = this.mRoot;
        if (null == x) {
            return null;
        }
        int temp = 0;
        while (null != x) {
            temp = x.key.compareTo(key);
            if (temp > 0) {
                x = x.left;
            } else if (temp < 0) {
                x = x.right;
            } else {
                return x.key;
            }
        }
        return null;
    }

    /**
    * @Description:
     * 插入新节点
    * @param
    * @return
    * @throws
    * @author hz16092620
    * @date 2019/5/24 13:49
    */
    public void insert(T key) {
        BSNode<T> newNode = new BSNode<T>(key, null, null, null);
        this.insert(newNode);
    }

    private void insert(BSNode<T> newNode) {
        if (null == this.mRoot) {
            this.mRoot = newNode;
            return;
        }
        int temp;
        BSNode<T> x = null;
        BSNode<T> y = this.mRoot;
        while (null != y) {
            x = y;
            temp = y.key.compareTo(newNode.key);
            if (temp < 0) {
                y = y.right;
            } else if (temp >0) {
                y = y.left;
            }
        }

        if (null == x) {
            this.mRoot = newNode;
        } else {
            temp = x.key.compareTo(newNode.key);
            if (temp < 0) {
                x.right = newNode;
            } else if (temp >0) {
                x.left = newNode;
            }
        }
    }

    /**
     * @Description: 获取最小节点
     * @param
     * @return
     * @throws
     * @author hz16092620
     * @date 2019/5/24 11:23
     */
    public BSNode<T> min() {
        return this.max(mRoot);
    }

    private BSNode<T> min(BSNode<T> node) {
        if (null == node) {
            return null;
        }
        if (node.left != null) {
            return max(node.left);
        } else {
            return node;
        }
    }

    /**
    * @Description: 获取最大节点
    * @param
    * @return
    * @throws
    * @author hz16092620
    * @date 2019/5/24 11:23
    */
    public BSNode<T> max() {
        return this.max(mRoot);
    }

    private BSNode<T> max(BSNode<T> node) {
        if (null == node) {
            return null;
        }
        if (node.right != null) {
            return max(node.right);
        } else {
            return node;
        }
    }

    /*查询*/
    public BSNode<T> search(T key) {
        return this.search(mRoot, key);
    }

    private BSNode<T> search(BSNode<T> node, T key) {
        if (null == node) {
            return null;
        }
        int i = node.key.compareTo(key);
        if (i < 0) {
            return search(node.right, key);
        } else if (i > 0) {
            return search(node.left, key);
        } else {
            System.out.println("查找数据 " + node.key);
            return node;
        }
    }

    /*前序遍历树*/
    public void preOrder() {
        System.out.println("-------------前序数据-------------");
        if (null != this.mRoot) {
            this.preOrder(this.mRoot);
            System.out.println();
        }
        System.out.println("-------------前序数据-------------");
    }

    private void preOrder(BSNode<T> node) {
        if (null != node) {
            System.out.print(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /*中序遍历树*/
    public void midOrder() {
        System.out.println("-------------中序数据-------------");
        if (null != this.mRoot) {
            this.midOrder(this.mRoot);
            System.out.println();
        }
        System.out.println("-------------中序数据-------------");
    }

    private void midOrder(BSNode<T> node) {
        if (null != node) {
            midOrder(node.left);
            System.out.print(node.key);
            midOrder(node.right);
        }
    }

    /*后续遍历树*/
    public void postOrder() {
        System.out.println("-------------后序数据-------------");
        if (null != this.mRoot) {
            this.postOrder(this.mRoot);
            System.out.println();
        }
        System.out.println("-------------后序数据-------------");
    }

    private void postOrder(BSNode<T> node) {
        if (null != node) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key);
        }
    }

}
