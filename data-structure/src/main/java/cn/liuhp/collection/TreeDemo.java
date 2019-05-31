package cn.liuhp.collection;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description: 有关树结构的使用
 * @author: hz16092620
 * @create: 2019-05-31 09:15
 */
public class TreeDemo {


    public static void main(String[] args) {
        testTreeMap();
    }


    /*demo treeMap的自定义排序*/
    private static void testTreeMap() {
        //1.1、定义一个比较器comparator
        Comparator<String> positiveComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {//s1 > s2 返回1是升序，s1 > s2 返回-1是降序
                String[] ss1 = s1.split("_");
                String[] ss2 = s2.split("_");
                if (Integer.valueOf(ss1[1]).intValue() > Integer.valueOf(ss2[1]).intValue()) {
                    return 1;
                } else if (Integer.valueOf(ss1[1]).intValue() < Integer.valueOf(ss2[1]).intValue()) {
                    return -1;
                } else {//如果相等，则比较前面那个数据
                    if (Integer.valueOf(ss1[0]).intValue() > Integer.valueOf(ss2[0]).intValue()) {
                        return 1;
                    } else if (Integer.valueOf(ss1[0]).intValue() < Integer.valueOf(ss2[0]).intValue()) {
                        return -1;
                    } else {//相等的话就表示同一个数据，并且会更新数据，这里很重要啊
                        return 0;
                    }
                }
            }
        };
        Comparator<String> negativeComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {//s1 > s2 返回1是升序，s1 > s2 返回-1是降序
                String[] ss1 = s1.split("_");
                String[] ss2 = s2.split("_");
                if (Integer.valueOf(ss1[1]).intValue() > Integer.valueOf(ss2[1]).intValue()) {
                    return -1;
                } else if (Integer.valueOf(ss1[1]).intValue() < Integer.valueOf(ss2[1]).intValue()) {
                    return 1;
                } else {//如果相等，则比较前面那个数据
                    if (Integer.valueOf(ss1[0]).intValue() > Integer.valueOf(ss2[0]).intValue()) {
                        return -1;
                    } else if (Integer.valueOf(ss1[0]).intValue() < Integer.valueOf(ss2[0]).intValue()) {
                        return 1;
                    } else {//相等的话就表示同一个数据，并且会更新数据，这里很重要啊
                        return 0;
                    }
                }
            }
        };
        //1.2、定义一个比较器comparator  Comparator<? super K> comparator
        Comparator<CharSequence> superComparator = new Comparator<CharSequence>() {
            @Override
            public int compare(CharSequence o1, CharSequence o2) {
                return 0;//代码省略
            }
        };
        //1、创建一个treeMap，没有穿comparator的默认是自然排序
        Map<String, String> treeMap = new TreeMap<>(negativeComparator);
        treeMap.put("1_3", "11");
        treeMap.put("2_1", "22");
        treeMap.put("3_2", "33");
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey());
        }
    }


}
