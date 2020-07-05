package com.dm.linklist;

public class JosephCircle {
	
	// 约瑟夫环问题  循环链表经典题
	// 设有编号为1，2，……，n的n(n>0)个人围成一个圈，从第1个人开始报数，报到m时停止报数，报m的人出圈，
	// 再从他的下一个人起重新报数，报到m时停止报数，报m的出圈，……，
	// 如此下去，直到所有人全部出圈为止。当任意给定n和m后，设计算法求n个人出圈的次序。
	
	// 循环链表实现
	public static void main(String[] args) {

		// 测试数据
		int[] array = {1,3,2,5,4,8};// 13258->1328->132->12->2  ===》出来4-》5-》8-》3-》2
		int n = 5;
		
		// 初始化头结点便于生成循环链表（让尾节点指向他形成循环链表）
		LinkNode<Integer> head = new LinkNode<Integer>(array[0]);
		// 初始化当前节点（移动当前节点，生成单向链表）
		LinkNode<Integer> cur = head; 
		// 形成单向链表
		for(int i=1;i<array.length;i++){
			cur.next = new LinkNode<Integer>(array[i]);
			cur = cur.next;
		}
		
		// 形成循环链表
		cur.next = head;
		
		// 约瑟夫问题核心代码
		while(cur != cur.next){
			// （cur移到当前节点位置）
			for(int i=0;i<n-1;i++){
				cur=cur.next;
			}
			System.out.println("出来："+cur.next.data);
			// 删除当前节点
			cur.next = cur.next.next;
		}
		System.out.println("剩下："+cur.data);

	}
	
	
}

class LinkNode<T>{
	
	public T data;
	
	public LinkNode<T> next;
	
	LinkNode(T data){
		this.data = data;
	}
}
