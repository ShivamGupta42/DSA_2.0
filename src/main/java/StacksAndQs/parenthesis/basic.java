package StacksAndQs.parenthesis;


import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class basic {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static class Reader {
		BufferedReader br;
		StringTokenizer st;
		
		public Reader() {
			br= new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() throws IOException {
			if(st==null||!st.hasMoreTokens()) {
				st=new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}
		
		Integer nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}

	public static void main(String[] args) throws IOException {
		Reader scan = new Reader();
		int T = scan.nextInt();

		while (T > 0) {
			T--;
			String s = scan.next();
			int length = s.length();
			Stack<Character> stack = new Stack<Character>();
			boolean balanced = true;

			for (int i = 0; i < length; i++) {
				char c = s.charAt(i);

				if (c == ']' ) {
					if(stack.size()==0||stack.pop() != '[') {
					balanced = false;
					break;}
					continue;
				}

				else if (c == '}') {
					if(stack.size()==0||stack.pop() != '{') {
					balanced = false;
					break;
					}
					continue;
				}

				else if (c == ')' ) {
					if(stack.size()==0||stack.pop() != '(') {
					balanced = false;
					break;}
					continue;
				} 
				
				stack.push(c);
				
			}

			if (stack.size()==0&&balanced) {
				bw.write("balanced" + "\n");
			} else {
				bw.write("not balanced" + "\n");
			}

			bw.flush();
		} // end of testcases
		bw.close();
	}

	

}
