package cn.liuhp.ioc.prepare;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 日期属性的处理
 * @author: liuhp534
 * @create: 2019-06-22 17:18
 */
public class DatePropertyEditor extends PropertyEditorSupport {

    private String pattern = "yyyy-MM-dd";

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            Date date = dateFormat.parse(text);
            this.setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
