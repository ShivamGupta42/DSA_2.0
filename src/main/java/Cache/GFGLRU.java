package Cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class GFGLRU {

	Map<Integer, Integer> map;
	int capacity;

	public GFGLRU(int N) {
		capacity = N;
		map = new LinkedHashMap<Integer, Integer>();
	}

	public int get(int x) {
		if (map.containsKey(x)) {
			return map.get(x);
		} else {
			return -1;
		}
	}

	/* Sets the key x with value y in the LRU cache */
	public void set(int x, int y) {
		if (map.size() == capacity) {
			int key = map.keySet().iterator().next();
			map.remove(key);
		}

		map.put(x, y);
	}

}
