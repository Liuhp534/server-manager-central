package cn.liuhp.binarytree;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 测试类
 * @author: hz16092620
 * @create: 2019-05-24 13:58
 */
public class BSTreeTest {


    public static void main(String[] args) {
        //m1();
        m2();
    }

    private static void m2() {
        BSTree<Integer> tree = new BSTree<>();
        List<Integer> list = Arrays.asList(7, 4, 1, 9, 0, 2, 6, 3, 5, 8);
        for (Integer i : list) {
            tree.insert(i);
        }
        System.out.println(tree.search(9));
    }

    private static void m1() {
        BSTree<Integer> tree = new BSTree<>();
        List<Integer> list = Arrays.asList(7, 4, 1, 9, 0, 2, 6, 3, 5, 8);
        for (Integer i : list) {
            tree.insert(i);
        }
        tree.preOrder();
        tree.midOrder();
        tree.postOrder();
    }


}
