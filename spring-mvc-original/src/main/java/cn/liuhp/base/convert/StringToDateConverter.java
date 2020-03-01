package cn.liuhp.base.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-03-01 11:56
 */
public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String dateStr) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = df.parse(dateStr);
            return date;
        } catch (Exception e) {
            throw new RuntimeException("类型转换错误");
        }
    }
}
