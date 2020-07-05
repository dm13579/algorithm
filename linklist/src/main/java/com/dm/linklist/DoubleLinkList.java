package com.dm.linklist;

/**
 * @ClassName DoubleLinkList
 * @Description TODO 双向链表
 * @Author dm
 * @Date 2019/11/21 22:15
 * @Version 1.0
 **/
public class DoubleLinkList {

    private DNode head;
    private DNode tail;

    DoubleLinkList() {
        this.head = null;
        this.tail = null;
    }

    public void insertHead(int data){
        DNode newNode = new DNode(data);
        if(head == null){
            tail = newNode;
        }else{
            newNode.next = head;
            head.pre = newNode;
        }
        head = newNode;
    }

    public void deleteHead(){
        if(head.next == null){		//就一个点
            tail = null;
        }else{
            head.next.pre = null;
        }
        head = head.next;
    }

    public void deleteKey(int data){
        DNode current = head;
        while (current.value != data) {
            current = current.next;
        }
        if (current == head) {// 指向下个就表示删除第一个
            deleteHead();
        } else {
            current.pre.next = current.next;
            if(current == tail){		//删除的是尾部
                tail = current.pre;
                current.pre = null;
            }else{
                current.next.pre = current.pre;
            }
        }

    }
}

class DNode{

    int value;
    DNode next;
    DNode pre;

    DNode(int value){
        this.value = value;
        this.next = null;
        this.pre = null;
    }

}
