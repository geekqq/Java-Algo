package Day45;

public class RegionMatch {
    public static void main(String[] args) {
        String firstStr = "Welcome to Microsoft";
        String secondStr = "I work with microsoft";
        boolean match1 = firstStr.regionMatches(11, secondStr, 12, 9);
        //true表示不区分大小写
        boolean match2 = firstStr.regionMatches(true, 11, secondStr, 12, 9);
        System.out.println("区分大小写的返回值：" + match1);
        System.out.println("不区分大小写的返回值：" + match2);
    }
}
