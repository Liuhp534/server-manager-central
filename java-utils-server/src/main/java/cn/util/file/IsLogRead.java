package cn.util.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 获取txt文件，并安行读取
 *
 * @description:
 * @author: liuhp534
 * @create: 2020-02-25 10:57
 */
public class IsLogRead {
    public static void main(String[] args) {
        Set<String> sets = readTxtFileIntoStringArrList("C:\\Users\\liuhp\\Desktop\\islog.txt");
        System.out.println(sets.size());
        System.out.println(sets);
    }

    public static Set<String> readTxtFileIntoStringArrList(String filePath) {
        Set<String> sets = new HashSet<>();
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                int start = 0;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    start = lineTxt.indexOf("20200224");
                    if (start != -1) {
                        lineTxt = lineTxt.substring(start, start + 14);
                        sets.add(lineTxt);
                    }
                }
                bufferedReader.close();
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        return sets;
    }
}
