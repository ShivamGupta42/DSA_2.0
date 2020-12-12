package Arrays.Misc;

import java.util.ArrayList;
import java.util.List;

public class LC118_PascalTriangle {

	public static List<List<Integer>> generate(int numRows) {

		List<List<Integer>> result = new ArrayList<>();
		if (numRows < 1) {
			return result;
		}

		List<Integer> list = new ArrayList<>();
		list.add(1);
		result.add(list);

		if (numRows == 1) {
			return result;
		}

		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(1);
		result.add(list2);

		if (numRows == 2) {
			return result;
		}

		generatePascalsRows(result, numRows, 3);
		return result;
	}

	public static void generatePascalsRows(List<List<Integer>> result, int numRows, int current) {
		if (current > numRows) {
			return;
		}

		List<Integer> cur = new ArrayList<>();
		cur.add(1);

		List<Integer> prev = result.get(current - 2);
		if (prev.size() > 1) {
			for (int i = 0; i < prev.size() - 1; i++) {
				cur.add(prev.get(i) + prev.get(i + 1));
			}
		}

		cur.add(1);
		result.add(cur);
		generatePascalsRows(result, numRows, current + 1);
	}

	public static void main(String[] args) {
		List<List<Integer>> result = generate(4);
	}
}
