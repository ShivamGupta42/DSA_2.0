package Strings.Reduction;

import java.util.*;
import java.util.stream.Collectors;

public class LC71_SimplifyPath {
    public static String simplifyPath(String path) {
        if (path == null) {
            return null;
        }

        path = path.trim();
        //path = reducePath(path);
        String[] split = path.split("/");

        Deque<String> st = new LinkedList<>();
        for (int i = 0; i < split.length; i++) {

            if (split[i].equals("")) {
                continue;
            } else if (split[i].equals(".")) {
                continue;
            } else if (split[i].equals("..")) {
                if (st.size() != 0) {
                    st.pop();
                }
                continue;
            } else if (split[i].matches("^.*$") ||
                    split[i].matches("([.]){3,}")) {
                st.push("/" + split[i]);
            }

        }

        if (st.size() == 0) {
            st.addLast("/");
        }

        StringBuilder sb = new StringBuilder();
        while (st.peek() != null) {
            sb.append(st.pollLast());
        }
        return sb.toString();
    }

    /* Not requires since split function will take care of it */
    private static String reducePath(String path) {
        StringBuilder sb = new StringBuilder();
        sb.append(path.charAt(0));
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/' && path.charAt(i - 1) == '/') {
                continue;
            }
            sb.append(path.charAt(i));
        }
        return sb.toString();
    }

    public static String simplifyPath2(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/..home/"));
        System.out.println(simplifyPath("/home//foo"));
        System.out.println(simplifyPath("/home//////foo/auth_keys"));
    }
}
