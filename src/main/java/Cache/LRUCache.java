package Cache;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {

	Deque<Integer> dq; // LRU Cache Queue
	HashSet<Integer> map;// LRU Cache Lookup
	final int cacheSize;

	public LRUCache(int cacheSize) {
		dq = new LinkedList<Integer>();
		map = new HashSet<Integer>();
		this.cacheSize = cacheSize;
	}

	private void display() {
		Iterator<Integer> i = dq.iterator();
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}

	}

	void refer(int x) {
		// Fresh entry
		if (!map.contains(x)) {
			// If cache is full remmove last entry
			if (dq.size() == cacheSize) {
				int last = dq.removeLast();
				map.remove(last);
			}
		}
		// Existing entry - Remove from LRU Cache queue
		else {
			dq.remove(x);
		}

		dq.add(x);// Add to front of cache queue
		map.add(x);// Add to cache lookup
	}

}
