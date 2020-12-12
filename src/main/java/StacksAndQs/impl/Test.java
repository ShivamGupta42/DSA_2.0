package StacksAndQs.impl;

public class Test {
	public static void main(String[] args) {

		
		StackArrayImpl s = new StackArrayImpl(20);
		s.push(20);
		s.push(30);
		s.push(40);
		while(!s.isEmpty()) {
		  System.out.print(s.pop()+" ");	
		}
		
		
		StackLinkedListImpl s2 = new StackLinkedListImpl();
		s2.push(1);
		s2.push(2);
		s2.push(3);
		
		while(!s2.isEmpty()) {
			System.out.print(s2.pop()+" ");	
		}
	}
}
