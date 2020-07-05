package com.dm.stack;

import java.util.Scanner;

/**
 * @ClassName OperationStack 數學表達式求值
 * @Description TODO
 * @Author dm
 * @Date 2019/11/23 15:53
 * @Version 1.0
 **/
public class OperationStack {

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.next();
            System.out.println(operation(s));
        }
    }

    public static String operation(String s){
        MyStack<Character> number = new ArrayStack<Character>(20);
        MyStack<Character> symbol = new ArrayStack<Character>(20);
        char c[] = s.toCharArray();
        for(char x : c){

        }

        return null;
    }
}
