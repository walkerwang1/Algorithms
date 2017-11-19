package swordoffer;

import java.util.HashMap;
import java.util.Map;

import common.BinaryTreeNode;
import util.PrintBinaryTree;

/*
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果都不含重复的数字。
 * 例如，输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6},
 * 则重建二叉树，并输出头结点
 */
public class b07_重建二叉树 {
	
	public static void main(String[] args) {
		System.out.println("1-普通二叉树");
		test1();
		System.out.println();
		
		System.out.println("2-所有结点都没有右子树");
		test2();
		System.out.println();
		
		System.out.println("3-所有结点都没有左子树");
		test3();
		System.out.println();
		
		System.out.println("4-树中只有一个结点");
		test4();
		System.out.println();
		
		System.out.println("5-完全二叉树");
		test5();
		System.out.println();
		
		System.out.println("6-输入空指针");
		test6();
		System.out.println();
		
		System.out.println("7-输入的两个序列不匹配");
		test7();
		System.out.println();
	}
	
	/**
	 * 根据前序遍历和遍历构建二叉树
	 * 
	 * @param pre	前序遍历数组
	 * @param in	中序遍历数组
	 * @return
	 */
	private static BinaryTreeNode constructBinaryTree(int[] pre, int[] in) {
		
		if (pre == null || in == null || pre.length != in.length || pre.length <= 0) {
			return null;
		}
		
		int p_start = 0, p_end = pre.length-1;
		int i_start = 0, i_end = in.length - 1;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = i_start; i <= i_end; i++) {
			map.put(in[i], i);
		}
		
		return construct(pre, p_start, p_end, in, i_start, i_end, map);
	}
	
	/**
	 * 递归构建过程
	 * 
	 * @param pre			前序遍历数组
	 * @param p_start		前序遍历数组起始位置
	 * @param p_end			前序遍历数组结束位置
	 * @param in			中序遍历数组
	 * @param i_start		中序遍历数组起始位置
	 * @param i_end			中序遍历数组结束位置
	 * @param map			记录中序遍历元素对应的下标
	 * @return
	 */
	private static BinaryTreeNode construct(int[] pre, int p_start, int p_end, 
			int[] in, int i_start, int i_end, Map<Integer, Integer> map) {
		if (p_start > p_end) {
			return null;
		}
		
		//取前序遍历的第一个数字，就是当前的根结点
		int value = pre[p_start];	
			
		//在中序遍历数组中找到根结点的位置
		int i_loc = -1;
		try {
			i_loc = map.get(value);
		} catch (Exception e) {
			throw new IllegalArgumentException("数据有问题");
		}
		
		BinaryTreeNode head = new BinaryTreeNode(value);
		head.left = construct(pre, p_start+1, p_start+i_loc-i_start, in, i_start, i_loc-1, map);
		head.right = construct(pre, p_start+i_loc-i_start+1, p_end, in, i_loc+1, i_end, map);
		
		return head;
	}
	
	// 普通二叉树  
    //              1  
    //           /     \  
    //          2       3  
    //         /       / \  
    //        4       5   6  
    //         \         /  
    //          7       8  
    private static void test1() {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = constructBinaryTree(pre, in);
        PrintBinaryTree.print(root);
    }
    
    // 所有结点都没有右子结点  
    //            1  
    //           /  
    //          2  
    //         /  
    //        3  
    //       /  
    //      4  
    //     /  
    //    5  
    private static void test2() {
        int[] pre = {1, 2, 3, 4, 5};
        int[] in = {5, 4, 3, 2, 1};
        BinaryTreeNode root = constructBinaryTree(pre, in);
        PrintBinaryTree.print(root);
    }
    
    // 所有结点都没有左子结点  
    //            1  
    //             \  
    //              2  
    //               \  
    //                3  
    //                 \  
    //                  4  
    //                   \  
    //                    5  
    private static void test3() {
        int[] pre = {1, 2, 3, 4, 5};
        int[] in = {1, 2, 3, 4, 5};
        BinaryTreeNode root = constructBinaryTree(pre, in);
        PrintBinaryTree.print(root);
    }
    
 // 树中只有一个结点  
    private static void test4() {
        int[] pre = {1};
        int[] in = {1};
        BinaryTreeNode root = constructBinaryTree(pre, in);
        PrintBinaryTree.print(root);
    }
    // 完全二叉树  
    //              1  
    //           /     \  
    //          2       3  
    //         / \     / \  
    //        4   5   6   7  
    private static void test5() {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] in = {4, 2, 5, 1, 6, 3, 7};
        BinaryTreeNode root = constructBinaryTree(pre, in);
        PrintBinaryTree.print(root);
    }
    // 输入空指针  
    private static void test6() {
        constructBinaryTree(null, null);
    }
    // 输入的两个序列不匹配  
    private static void test7() {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] in = {4, 2, 8, 1, 6, 3, 7};
        BinaryTreeNode root = constructBinaryTree(pre, in);
        PrintBinaryTree.print(root);
    }
}
