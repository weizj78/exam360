package DesignPattern.jianzhioffer;

public class StringRepace {

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(str));
    }
    public static String replaceSpace(StringBuffer str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c==' '){
                builder.append("%20");
            }else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
