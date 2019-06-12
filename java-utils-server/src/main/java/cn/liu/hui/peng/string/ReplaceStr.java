package cn.liu.hui.peng.string;

/**
 * @author hz16092620
 * @date 2018年8月16日 上午10:06:12
 */
public class ReplaceStr {

    public static void main(String[] args) {
        replacePlaceholder();
    }


    public static void testReplace() {
        System.out.println(replaceChar("6789", 1, 4));
        System.out.println("6789@qq.com".indexOf("@"));
        System.out.println(replaceChar("6789@qq.com", 1, 4));

        System.out.println("222".replaceAll("\\[|\\]", ""));
    }

    /*加密*/
    public static String replaceChar(String orgString, int startIndex, int lastNum) {
        if (orgString != null) {
            startIndex = startIndex - 1;
            StringBuilder str = new StringBuilder(orgString.length());
            for (int i = 0; i < orgString.length(); i++) {
                if ((orgString.length() - lastNum) <= i) {
                    str.append(orgString.charAt(i));
                } else {
                    if (i >= startIndex) {
                        str.append("*");
                    } else {
                        str.append(orgString.charAt(i));
                    }
                }
            }
            return str.toString();
        }
        return null;
    }

    /*测试替换占位符*/
    public static void replacePlaceholder() {
        String placeholder = String.format("{{%s}}", "coverage");
        System.out.println(placeholder);
        String str = "确认保额{{coverage}}是否正确？";
        System.out.println(str.replace(placeholder, "50万"));
    }

}
 