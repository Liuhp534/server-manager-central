package cn.liuhp.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

public class JackJsonUtils {


    //定义转换工具
    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);//配置是否包含null值的属性,默认包含
    }


    /*
    * 将json字符串转换成对象
    * */
    public static Map<String, Object> jsonToMap(String jsonStr) {
        Map<String, Object> map = null;
        try {
            map = objectMapper.readValue(jsonStr, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }


    /*
    * JSON字符串转对象
    * */
    public static <T>T jsonToBean(String jsonStr, Class<T> tClass) {
        T bean = null;
        try {
            bean = objectMapper.readValue(jsonStr, tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bean;
    }


    /*
     * 将对象转换成json字符串
     * */
    public static <T>String   beanToJson(T bean) {
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(bean);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

}
