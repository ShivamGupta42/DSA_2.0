package Strings.Reduction;

import java.util.ArrayList;
import java.util.Arrays;

public class SplitFunction {

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        String[] splits = split("/home//foo////random///stes////test/home//foo////random///stes////test" +
                "/home//foo////random///stes////test/home//foo////random///stes////test" +
                "/home//foo////random///stes////test/home//foo////random///stes////test" +
                "/home//foo////random///stes////test/home//foo////random///stes////test" +
                "/home//foo////random///stes////test/home//foo////random///stes////test" +
                "/home//foo////random///stes////test/home//foo////random///stes////test" +
                "/home//foo////random///stes////test/home//foo////random///stes////test" +
                "/home//foo////random///stes////test/home//foo////random///stes////test" +
                "/home//foo////random///stes////test/home//foo////random///stes////test" +
                "/home//foo////random///stes////test/home//foo////random///stes////test" +
                "/home//foo////random///stes////test/home//foo////random///stes////test" +
                "/home//foo////random///stes////test/home//foo////random///stes////test", '/');
        System.out.println(Arrays.deepToString(splits)+"\ntime: "+(System.currentTimeMillis()-start));
    }

    private static String[] split(String s, char del) {
        ArrayList<String> list = new ArrayList<>();
        String curString = "";
        boolean lastStringAdded = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == del) {
                if (!lastStringAdded) {
                    if (!curString.equals("")) {
                        list.add(curString);
                        curString = "";
                    }
                    lastStringAdded = true;
                }
                continue;
            }
            lastStringAdded = false;
            curString += s.charAt(i);
        }
        if(!curString.equals("")){
            list.add(curString);
        }

        String[] res = new String[list.size()];
        return list.toArray(res);
    }
}
