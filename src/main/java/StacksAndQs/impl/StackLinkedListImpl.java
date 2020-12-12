package StacksAndQs.impl;

public class StackLinkedListImpl {
	
	 class Node{
		 int data;
		 Node next;
		 public Node(int data) {
			this.data=data;
		}
		 
	 }
	
	int capacityLimit=-1;
	int size;
	Node head;
	 
	public void setCapacityLimitTrue(int limit) {
		if(limit>0) {
			capacityLimit=limit;
		}
	}
	
    public void unSetCapacityLimit() {
		capacityLimit=-1;
	}

    
    public void push(int val) {
    	if(capacityLimit>0&&size==capacityLimit) {
    		throw new RuntimeException("Stack Overflow");
    	}
    	
    	Node n = new Node(val);
    	n.next=head;
    	head=n;
    	size++;
    }
    
    public int pop() {
    	if(head==null) {
    		throw new RuntimeException("Stack UnderFlow");
    	}
    	Node x = head;
    	head= head.next;
    	size--;
    	return x.data;
    }
    
    public boolean isEmpty() {
    	return size==0;
    }
}
