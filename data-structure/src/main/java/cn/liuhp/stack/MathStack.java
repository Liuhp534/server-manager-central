package cn.liuhp.stack;

import java.util.*;

/**
 * @description: 组合的使用
 * @author: hz16092620
 * @create: 2019-05-30 11:53
 */
public class MathStack {

    static int cnt = 0;
    static EStack<Integer> s = new EStack<Integer>();
    static Map<String, Set<String>> hMap = new LinkedHashMap<>();
    static Map<String, Set<String>> tMap = new LinkedHashMap<>();
    static HashMap<String, String> convertMap = new HashMap<>();
    static Set<String> allSet = new LinkedHashSet<>(Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"));//12个里面分成均等两堆
    //static Set<String> allSet = new LinkedHashSet<>(Arrays.asList("01", "02", "03", "04"));//4个里面分成均等两堆

    static {
        convertMap.put("01", "鼠");
        convertMap.put("02", "牛");
        convertMap.put("03", "虎");
        convertMap.put("04", "兔");
        convertMap.put("05", "龙");
        convertMap.put("06", "蛇");
        convertMap.put("07", "马");
        convertMap.put("08", "羊");
        convertMap.put("09", "猴");
        convertMap.put("10", "鸡");
        convertMap.put("11", "狗");
        convertMap.put("12", "猪");
    }

    /**
     * 递归方法，当前已抽取的小球个数与要求抽取小球个数相同时，退出递归
     * @param curnum - 当前已经抓取的小球数目
     * @param curmaxv - 当前已经抓取小球中最大的编号
     * @param maxnum - 需要抓取小球的数目
     * @param maxv - 待抓取小球中最大的编号
     */
    public static void kase3(int curnum, int curmaxv,  int maxnum, int maxv){
        if(curnum == maxnum){
            cnt++;
            hMap.put(cnt + "", s.getH());
            tMap.put(cnt + "", s.getT(allSet));
            //System.out.println(s);
            return;
        }

        for(int i = curmaxv + 1; i <= maxv; i++){ // i <= maxv - maxnum + curnum + 1
            s.push(i);
            kase3(curnum + 1, i, maxnum, maxv);
            s.pop();
        }
    }
    /*打印数据*/
    private static void printHT() {
        for (Map.Entry<String, Set<String>> hentry : hMap.entrySet()) {
            System.out.println("正" + hentry.getKey() + " : " + hentry.getValue() + " | 反" + hentry.getKey() + " : " + tMap.get(hentry.getKey()));
        }
    }

    /*转换数据*/
    private static Map<String, Set<String>> convertData(Map<String, Set<String>> maps) {
        Map<String, Set<String>> resultMap = new LinkedHashMap<>();
        Set<String> result = null;
        for (Map.Entry<String, Set<String>> map : maps.entrySet()) {
            result = new LinkedHashSet<>();
            for (String str : map.getValue()) {
                result.add(convertMap.get(str));
            }
            resultMap.put(map.getKey(), result);
        }
        return resultMap;
    }

    /*正反相同那么去除*/
    private static void configHT() {
        Set<String> deleteKey = new HashSet<String>();
        /*Set<Map.Entry<String, Set<String>>> hentryset = hMap.entrySet();
        Iterator<Map.Entry<String, Set<String>>> hit = hentryset.iterator();*/
        for (Map.Entry<String, Set<String>> hentry : hMap.entrySet()) {
            for (Map.Entry<String, Set<String>> tentry : tMap.entrySet()) {
                if (isCommon(hentry.getValue(), tentry.getValue())) {//正反相同那么去除
                    if (deleteKey.contains(hentry.getKey())) {//如果包含在删除的范围内则跳过
                        continue;
                    }
                    deleteKey.add(tentry.getKey());
                }
            }
        }
        //System.out.println(deleteKey);
        for (String str : deleteKey) {
            hMap.remove(str);
            tMap.remove(str);
        }
        //System.out.println(hMap.size());
        //System.out.println(tMap.size());
    }

    /*判断正反是否相同*/
    private static boolean isCommon(Set<String> hSet, Set<String> tSet) {
        boolean flag = false;
        int count = 0;
        for (String h : hSet) {
            if (tSet.contains(h)) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        kase3(0, 0, 6, 12);
        //kase3(0, 0, 2, 4);
        //System.out.println(cnt);
        System.out.println("-----------------");
        //printHT();
        System.out.println("-----------------");
        //过滤掉相同的 如果正里面的内容，完全等于反里面的内容，那么就可以确定是相同的
        configHT();
        //打印和转换
        hMap = convertData(hMap);
        tMap = convertData(tMap);
        System.out.println("-----------------");
        printHT();
        System.out.println("-----------------");
    }

}
