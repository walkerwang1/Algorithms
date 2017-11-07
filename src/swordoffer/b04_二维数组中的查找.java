package swordoffer;

/*
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序
 * 排序，每一列都按照从上到下递增的顺序排序。请完成一个函
 * 数，输入这样的一个二维数组和一个整数，判断数组中是否含
 * 有该整数。
 */
public class b04_二维数组中的查找 {
	
	public static void main(String[] args) {
		int[][] arr = {{1,2,8,9,11},
					   {2,4,9,12,14},
					   {4,7,10,13,16},
					   {6,8,11,15,20}};
		int k = 7;
		System.out.println(find(arr, k));
	}
	
	/*
	 */
	public static boolean find(int[][] arr, int k) {
		boolean flag = false;
		if (arr.length < 0) {
			return flag;
		}
		int rows = arr.length;		//数组行数
		int cols = arr[0].length;	//数组列数
		
		int cur_row = 0;
		int cur_col = arr[0].length - 1;
		
		//从右上角往左下角开始扫描
		while(cur_row < rows && cur_col >= 0) {
			if (arr[cur_row][cur_col] == k) {
				flag = true;
				break;
			} else if (arr[cur_row][cur_col] < k) {
				++cur_row;
			} else {
				--cur_col;
			}
		}
		
		return flag;
	}

}
