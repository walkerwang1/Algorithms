package common;

/*
 * 二叉树结点
 */
public class BinaryTreeNode {

	public int value;
	public BinaryTreeNode left = null;
	public BinaryTreeNode right = null;
	
	public BinaryTreeNode() {
	}
	
	public BinaryTreeNode(int data) {
		this.value = data;
	}
	
	@Override
	public String toString() {
		return value + "";
	}
}
