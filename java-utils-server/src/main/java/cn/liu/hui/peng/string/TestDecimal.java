package cn.liu.hui.peng.string;

import java.text.DecimalFormat;

/**
 * decimalformat 用于格式化数据
 *
 * @author hz16092620
 * @date 2018年3月16日 上午10:28:43
 */
public class TestDecimal {

    public static void main(String[] args) {
        decimal();
        price();
    }

    /*转换指定格式*/
    private static void decimal() {
        DecimalFormat format = new DecimalFormat("JM0000");
        Integer i = 114;
        System.out.println(format.format(i));
    }

    /*金额的转换*/
    private static void price() {
        double unit = 100;
        DecimalFormat df = new DecimalFormat("#0.00");
        String premium = df.format(1100 / unit);
        System.out.println(premium);
    }
}
 