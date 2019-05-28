package cn.liuhp.collection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description: map有关
 * @author: hz16092620
 * @create: 2019-05-28 10:27
 */
public class MapTest {

    public static void main(String[] args) {
        test1();
        SubC subC = new SubC();
        subC.test1();
    }



    private static void test1() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("name1", "name1");
        map.put("name2", "name2");
        map.put("name3", "name3");
        Set<Map.Entry<String, Object>> set = map.entrySet();
        for (Map.Entry<String, Object> entry : set) {//Iterable 为什么可以循环，这个应该是1.8之后才有的
            System.out.println(entry.getKey() + "_" + entry.getValue());
        }
    }
}
class SuperC {
    int modCount;
}
class SubC extends SuperC {


    public void test1() {
        System.out.println(++ this.modCount);
    }
}