package StacksAndQs.impl;

import java.util.Deque;
import java.util.LinkedList;

public class Ibit_DirecotrySimplify {

	public static String simplifyPath(String A) {
		if (A == null || A.length() == 0) {
			return "";
		}

		String[] folders = A.split("/");
		Deque<String> q = new LinkedList<>();
         
		if(folders.length<=1) {
			return A;
		}
		for (String s : folders) {
			if (s.equals(".")||s.equals("")) {
				continue;
			}

			else if (s.equals("..")) {
				if (!q.isEmpty()) {
					q.pop();
				}
			} else {
				q.push(s);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
           sb.append("/"+q.pollLast());
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		System.out.println(simplifyPath("/home/"));
		System.out.println(simplifyPath("/a/./b/../../c/"));
	}

}
