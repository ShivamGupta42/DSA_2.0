package StacksAndQs.parenthesis;

import java.util.*;

public class LC_1021_Remove_Outer_Parantheses {
    public String removeOuterParentheses(String s) {

        Deque<Character> st = new LinkedList<>();
        List<String> list = new ArrayList<>();

        int start=0;
        for(int i=0;i<s.length();i++){

            if(s.charAt(i)=='('){
                st.push('(');
            }

            else if (s.charAt(i)==')'){
                if(st.size()!=0){
                    st.pop();
                    if(st.size()==0){
                        list.add(s.substring(start,i+1));
                        start=i+1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String str : list){
            sb.append(process(str));
        }

        return sb.toString();

    }

    public String process(String s){
        if(s.length()>=2){
            return s.substring(1,s.length()-1);
        }

        return "";
    }
}
