package Arrays.Array;

import java.io.*;
import java.util.HashMap;

public class MaxSubArraySum {

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

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Reader scan = new Reader();
		int T = scan.nextInt();

		while (T-- > 0) {
			int n = scan.nextInt();
			int[] arr = new int[n];
			int[] pSum = new int[n];
			int sum = 0;

			int curMax = 0;
			int totalMax = Integer.MIN_VALUE;
			int start = 0;
			int end = -1;

			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextInt();
				sum += arr[i];
				pSum[i] = sum;

				curMax = curMax + arr[i];
				if (curMax > totalMax) {
					totalMax = curMax;
					end = i;
				}

				if (curMax < 0) {
					map.put(pSum[i], sum);
					curMax = 0;
					start = i + 1;
				}
			} // end

			if (end != -1 && start < end) {
				for (int i = start; i < end + 1; i++) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}
	}
}
