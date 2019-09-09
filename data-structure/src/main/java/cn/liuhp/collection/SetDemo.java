package cn.liuhp.collection;

import java.util.*;

/**
 * @description: set有关的使用
 * @author: hz16092620
 * @create: 2019-05-31 09:58
 */
public class SetDemo {


    public static void main(String[] args) {

    }


    /*给list去重*/
    private void remove() {
        List<Long> list = new ArrayList<>(Arrays.asList(1L, 1L, 2L));
        Set<Long> s1 = new HashSet<Long>();
        Iterator<Long> it = list.iterator();
        Long temp = null;
        while (it.hasNext()) {
            temp = it.next();
            if (s1.contains(temp)) {
                it.remove();
            }
            s1.add(temp);
        }
        System.out.println(list);
    }
}
