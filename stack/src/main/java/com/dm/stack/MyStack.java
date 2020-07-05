package com.dm.stack;

/**
 * @ClassName MyStack
 * @Description TODO 栈
 * @Author dm
 * @Date 2019/11/23 14:18
 * @Version 1.0
 **/
public interface MyStack<T> {

    MyStack<T> push(T item);

    T pop();

    int size();

    boolean isEmpty();
}
