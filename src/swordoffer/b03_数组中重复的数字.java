package swordoffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * 题目：在一个长度为n的数组里的所有数字都在0 ~ n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个
 * 数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入
 * 长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字
 * 2或者3。
 */
public class b03_数组中重复的数字 {

	public static void main(String[] args) {
//		int[] arr = {2,3,1,0,2,5,3};
		int[] arr = {2, 1, 3, 0, 4};
		
		//【思路1】快排。
		int ret = duplicate3(arr);
		System.out.println(ret);
	}
	
	/*
	 * 【思路1】排序。排序之后双指针往后走，直到找到相同的数字，则返回。
	 * 		时间复杂度：O(n*log(n))
	 */
	public static int duplicate1(int[] arr) {
		Arrays.sort(arr);	//使用自带排序方法。（快排）
		
		for(int i = 0; i < arr.length-1; i++) {
			if (arr[i] == arr[i+1]) {
				return arr[i];
			}
		}
		return -1;
	}
	
	/*
	 * 【思路2】哈希表，保存数字及出现的次数。
	 * 		时间复杂度：O(n)
	 * 		空间复杂度：O(n)
	 */
	public static int duplicate2(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}
		
		//遍历HashMap
		for(Entry<Integer, Integer> obj : map.entrySet()) {
			if (obj.getValue() > 1) {
				return obj.getKey();
			}
		}
		return -1;
	}
	
	/*
	 * 【思路3】题目特点：数组中n个元素都在0 ~ n-1范围内。可知，如果数组中没有重复元素，
	 * 		数组排序后下标i位置的数字为i，即arr[0]=0, arr[1]=1, … , arr[n-1]=n-1;
	 * 		由于数组中存在重复元素，则某些下标可能会存在多个数字，同时有些位置可能没有数字。
	 * 
	 * 		以数组{2,3,1,0,2,5,3}为例，可知,arr[0]!=0,则交换arr[0]和arr[arr[0]](即arr[2])的值，
	 * 		此时，数组为{1,3,2,0,2,5,3},可知arr[0]!=0,则交换arr[0]和arr[arr[0]](即arr[1])的值，
	 * 		此时，数组为{3,1,2,0,2,5,3},可知arr[0]!=0,则交换arr[0]和arr[arr[0]](即arr[3])的值，
	 * 		此时，数组为{0,1,2,3,2,5,3},可知arr[0]=0,此时，第0个下标位置的值等于0，即arr[0]=0，继续扫描下一个数字。
	 * 
	 * 		时间复杂度：O(n)
	 * 		空间复杂度：O(1)
	 */
	public static int duplicate3(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			while(arr[i] != i) {
				if (arr[arr[i]] == arr[i]) {	//数组位置冲突
					return arr[i];
				} else {
					//将下标为i和arr[i]位置的数据进行交换
					int tmp = arr[i];
					arr[i] = arr[arr[i]];
					arr[tmp] = tmp;		//交换时注意，不是arr[arr[i]]=tmp，由于arr[i]的值已经更新。
				}
			}
		}
		return -1;
	}
}
