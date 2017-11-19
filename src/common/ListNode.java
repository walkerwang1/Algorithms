package common;

/*
 * 链表结点
 */
public class ListNode {

	public int value;
	public ListNode next = null;
	
	public ListNode() {
	}
	
	public ListNode(int data) {
		this.value = data;
	}
	
	@Override
	public String toString() {
		return value + "";
	}
}
