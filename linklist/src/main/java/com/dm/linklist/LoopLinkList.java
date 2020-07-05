package com.dm.linklist;

/**
 * @ClassName LoopLinkList
 * @Description TODO 循环链表（约瑟夫环问题）
 * @Author dm
 * @Date 2019/11/21 22:50
 * @Version 1.0
 **/
public class LoopLinkList {

    private ListNode head;

    public void insert(int data){

    }

}

class LoopNode{

    int value;

    ListNode next;

    LoopNode(int value){
        this.value = value;
        this.next = null;
    }
}