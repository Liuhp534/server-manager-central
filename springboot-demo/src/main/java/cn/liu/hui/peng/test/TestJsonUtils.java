package cn.liu.hui.peng.test;

import cn.liuhp.domain.Person;
import cn.liuhp.utils.JackJsonUtils;

import java.util.Date;
import java.util.Map;

public class TestJsonUtils {

    public static void main(String[] args) {
        m1();
        m2();
        m3();
    }

    private static void m1() {
        Person person = new Person();
        //person.setName("jeff");
        //person.setAge(100);
        //person.setBirthday(new Date());
        String jsonStr = JackJsonUtils.beanToJson(person);
        System.out.println(jsonStr);

    }

    private static void m2() {
        Map<String, Object> map = JackJsonUtils.jsonToMap("{\"name\":\"jeff\",\"age\":100,\"birthday\":\"2019-09-30 14:09:22\"}");
        for (Map.Entry<String, Object> mapt : map.entrySet()) {
            System.out.println(mapt.getKey() + "_" + mapt.getValue());
        }
    }

    private static void m3() {
        Person person = JackJsonUtils.jsonToBean("{\"name\":\"jeff\",\"age\":100,\"birthday\":\"2019-09-30 14:09:22\"}", Person.class);
        System.out.println(person);
    }



}
