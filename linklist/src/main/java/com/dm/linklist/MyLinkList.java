package com.dm.linklist;

/**
 * @ClassName MyLinkList
 * @Description TODO 单链表
 * @Author dm
 * @Date 2019/11/21 21:44
 * @Version 1.0
 **/
public class MyLinkList {

    private ListNode head;
    private int size = 0;

    /**
     * Description: 插入链表的头
     *
     * @param:
     * @return:
     * @auther: dm
     * @date: 2019/11/21 21:48
     */
    public void insertHead(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Description: 插入链表中间
     *
     * @param:
     * @return:
     * @auther: dm
     * @date: 2019/11/21 21:48
     */
    public void insertNth(int data,int position){
        if(position == 0){
            insertHead(data);
        }else{
            ListNode cur = head;
            for(int i = 1;i < position;i++){
                cur = cur.next;
            }
            ListNode newNode = new ListNode(data);
            newNode.next = cur.next;
            cur.next = newNode;
        }
    }

    /**
     * Description: 删除头部节点
     *
     * @param:
     * @return:
     * @auther: dm
     * @date: 2019/11/21 21:49
     */
    public void deleteHead(){
        head = head.next;
    }

    /**
     * Description: 删除中间节点
     *
     * @param:
     * @return:
     * @auther: dm
     * @date: 2019/11/21 21:49
     */
    public void deleteNth(int position){
        if(position == 0){
            deleteHead();
        }else{
            ListNode cur = head;
            for(int i = 1;i < position;i++){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
    }

    /**
     * Description:查找
     *
     * @param:
     * @return:
     * @auther: dm
     * @date: 2019/11/21 22:12
     */
    public void find(int data){
        ListNode cur = head;
        while(cur != null){
            if(cur.value == data){
                System.out.println(cur.value);
            }
            cur = cur.next;
        }
    }
    /**
     * Description:遍历
     *
     * @param:
     * @return:
     * @auther: dm
     * @date: 2019/11/21 22:10
     */
    public void print(){
        ListNode cur = head;
        while(cur != null){
            System.out.println(cur.value);
            cur = cur.next;
        }
    }
}

class ListNode{

    int value;

    ListNode next;

    ListNode(int value){
        this.value = value;
        this.next = null;
    }
}
