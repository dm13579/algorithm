package com.dm.stack;

/**
 * @ClassName Array
 * @Description TODO
 * @Author dm
 * @Date 2019/11/23 14:20
 * @Version 1.0
 **/
public class ArrayStack<T> implements MyStack<T> {

    private T [] a = (T[]) new Object[1];

    private int n = 0;

    public ArrayStack(int cap) {
        a = (T[]) new Object[cap];
    }

    @Override
    public MyStack<T> push(T item) {

        judgeSize();
        a[n++] = item;

        return null;
    }

    @Override
    public T pop() {

        T item = a[--n];
        a[n] = null;
        return item;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        if(n == 0){
            return true;
        }
        return false;
    }

    private void judgeSize(){
        if(n >= a.length){
            resize(2 * a.length);
        }else if(n > 0 && n <= a.length / 2){
            resize(a.length / 2);
        }
    }
    private void resize(int size){
        T[] temp = (T[]) new Object[size];
        for(int i=0;i<n;i++){
            temp[i] = a[i];
        }
        a = temp;
    }
}
