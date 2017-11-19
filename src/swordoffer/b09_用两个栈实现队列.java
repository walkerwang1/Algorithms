package swordoffer;

import java.util.Stack;

/*
 * 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，
 * 分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 */
public class b09_用两个栈实现队列 {
	
	public static void main(String[] args) {
		QueueWithTwoStack queue = new QueueWithTwoStack();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
	}
	
	/*
	 * 【思路】一个栈专门负责入栈，一个栈专门负责出栈
	 */
	private static class QueueWithTwoStack{
		
		public static Stack<Integer> stackPush;		//只负责入栈
		public static Stack<Integer> stackPop;		//只负责出栈
		
		public QueueWithTwoStack() {
			stackPush = new Stack<>();
			stackPop  = new Stack<>();
		}
		
		/*
		 * 在队列尾部插入结点
		 */
		public void add(int data) {
			stackPush.push(data);
		}
		
		/*
		 * 在队列头部删除结点
		 */
		public int poll() {
			if (stackPop.empty() && stackPush.empty()) {	//两个栈都为空
				throw new RuntimeException("Queue is empty.");
			} else if (stackPop.empty()) {
				//stackPop为空，则将stackPush中的元素倒入stackPop
				while(!stackPush.empty()){
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.pop();
		}
		
		/*
		 * 取队列头部结点，不从队列中移除结点
		 */
		public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
	}

}
