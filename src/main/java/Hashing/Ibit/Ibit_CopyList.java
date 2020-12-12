package Hashing.Ibit;

import java.util.HashMap;

public class Ibit_CopyList {

	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public RandomListNode copyRandomList2(RandomListNode h) {
		if (h == null) {
			return null;
		}

		RandomListNode p = h;
	

		while (p != null) {
			RandomListNode newNode = new RandomListNode(p.label);
			RandomListNode temp = p.next;
			p.next=newNode;
			newNode.next=temp;
			p=temp;
		}

		p = h;

		while (p != null) {
			if (p.random != null) {
				p.next.random = p.random.next;
			}
			p = p.next.next;
		}
		
		RandomListNode newHead=h.next;
		RandomListNode q=newHead;
		while(q!=null&&q.next!=null) {
			RandomListNode temp =q.next.next;
			q.next=temp;
			q=temp;
		}
		
		return newHead;

	}
	
	
	
	
	
	
	public RandomListNode copyRandomList(RandomListNode h) {
		if (h == null) {
			return null;
		}

		RandomListNode newHead = new RandomListNode(h.label);
		RandomListNode p = h;
		RandomListNode q = newHead;

		// This map will be used to remember nodes of the newly created list
		// When we will be updating the random Pointers
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		map.put(p, q);
		p = p.next;

		while (p != null) {
			RandomListNode temp = new RandomListNode(p.label);
			map.put(p, temp);
			q.next = temp;
			q = q.next;
			p = p.next;
		}

		p = h;
		q = newHead;

		while (p != null) {
			if (p.random != null) {
				q.random = map.get(p.random);
			}
			q = q.next;
			p = p.next;
		}

		return newHead;
	}
	
	
	
}
