package com.dm.stack;

import java.util.Scanner;

/**
 * @ClassName BracketsStack
 * @Description TODO 括號匹配
 * @Author dm
 * @Date 2019/11/23 15:02
 * @Version 1.0
 **/
public class BracketsStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.next();
            System.out.println(isOk(s));
        }
    }

    public static boolean isOk(String s){
        MyStack<Character> brackets = new ArrayStack<Character>(20);
        char c[] = s.toCharArray();
        Character top;
        for(char x : c){
            switch (x){
                case '{':
                case '(':
                case '[':
                    brackets.push(x);
                    break;
                case ']':
                    top = brackets.pop();
                    if(top == null) return false;
                    if(top == '['){
                        break;
                    }else{
                        return false;
                    }
                case ')':
                    top = brackets.pop();
                    if(top == null) return false;
                    if(top == '('){
                        break;
                    }else{
                        return false;
                    }
                case '}':
                    top = brackets.pop();
                    if(top == null) return false;
                    if(top == '{'){
                        break;
                    }else{
                        return false;
                    }
                default:
                    break;
            }
        }
        return brackets.isEmpty();
    }

}
