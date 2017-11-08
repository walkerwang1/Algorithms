package swordoffer;

import java.util.Stack;

import alg4.StdOut;

/*
 * 题目：输入一个链表的头节点，从尾到头反过来打印出每个节点的值。
 */
public class b06_从尾到头打印链表 {
	
	public static void main(String[] args) {
		Node head = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		head.next = node1;node1.next = node2; node2.next = node3; node3.next =null;
		
		printList2(head);
		
	}
	
	/*
	 * 【思路1】题目要求是逆序打印，也就是链表中的元素先遍历后输出，正好满足栈的特点。
	 */
	public static void printList1(Node head) {
		Stack<Integer> stack = new Stack<>();
		
		Node p = head;
		while(p != null) {	//将链表中的元素添加到栈中
			stack.push(p.data);
			p = p.next;
		}
		
		//元素依次出栈
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	
	/*
	 * 【思路2】既然想到用栈来实现，而递归在本质上就是一个栈结果。于是考虑用递归实现。
	 * 
	 * 要实现反过来输出链表，每访问一个结点的时候，先递归输出它后面的结点，再输出该结点自身，
	 * 这样链表输出结果就反过来了。
	 */
	public static void printList2(Node head) {
		if (head != null) {
			if (head.next != null) {
				printList2(head.next);
			}
			System.out.print(head.data + " ");
		}
	}
	
	/*
	 * 定义链表的节点类
	 */
	private static class Node {
		int data;
		Node next = null;
		
		public Node(int data) {
			this.data = data;
		}
	}
}
