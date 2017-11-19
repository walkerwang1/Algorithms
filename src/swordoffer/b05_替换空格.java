package swordoffer;

import java.util.Arrays;

/*
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。
 * 例如输入"We are happy."，则输出"We%20are%20happy."
 */
public class b05_替换空格 {

	public static void main(String[] args) {
		String str = "We are happy";
		char[] chs = new char[15];		//申请长度为100的空间，后面扩容时可能会不够
		for (int i = 0; i < str.length(); i++) {
			chs[i] = str.charAt(i);
		}
		String ret = replaceWhite(chs, str.length());
		System.out.println(ret);
	}
	
	/*
	 * 【思路】双指针：从尾向前扫描并替换。
	 * p1:指向原数组的末尾；
	 * p2:执行扩容后数组的末尾。扩容时需要统计数组中空格个数，确定扩容后数组的长度。
	 * 指针p1从尾向前扫描，并将元素不断地复制到p2指针，遇到空格则在p2中进行替换。
	 */
	public static String replaceWhite(char[] chs, int len) {
		if (len < 1 || chs == null) {
			return null;
		}
		
		int cnt = 0;	//统计字符数组中空格的数量
		for(int i = 0; i < len; i++) {
			if (chs[i] == ' ') {
				cnt++;
			}
		}
		int p1 = len - 1;	//指向扩容前数组的末尾
		int p2 = len + 2*cnt - 1;	//指向扩容后数组的末尾
		
		if (p2 >= chs.length) {		//判断p2与申请的空间是否足够，不够则需要进行扩容
			System.out.println("申请的数组空间不够，进行简单的扩容。\n");
			int size = 2 * chs.length;
			//将新创建的字符数组复制到原数组
			chs = Arrays.copyOf(chs, size);
		}
		
		while (p1 >= 0) {
			if (chs[p1] == ' ') {
				chs[p2--] = '0';
				chs[p2--] = '2';
				chs[p2--] = '%';
			} else{
				chs[p2--] = chs[p1];
			}
			p1--;
		}
		
		return new String(chs);
	}
}
