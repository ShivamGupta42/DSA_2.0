
package Arrays.Array;

import java.io.*;

public class AreConsecutive {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

	public static void main(String[] args) throws IOException {
		Reader scan = new Reader();
		int T = scan.nextInt();

		while (T > 0) {
			T--;

			int n = scan.nextInt();
			int[] a = new int[n];
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;

			// find max and min
			for (int i = 0; i < n; i++) {
				a[i] = scan.nextInt();
				if (a[i] > max) {
					max = a[i];
				}
				if (a[i] < min) {
					min = a[i];
				}
			}

			
			
			boolean areConsecutive = true;
			boolean[] visited = new boolean[n];

			//baselining
			if (max - min + 1 == n) {
				int j;
				for (int i = 0; i < n; i++) {
					j = a[i] - min;

					if (!visited[j]) {
						visited[j] = true;
					} else {
						areConsecutive = false;
						break;
					}
				}

			} else {
				areConsecutive = false;
			}

			
			
			if (areConsecutive) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}

		} // end of testcases

	}

}
