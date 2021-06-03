package com.lqq.demo.dataStructure;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Stack;

/**
 * @ClassName StackTest
 * @Description TODO
 * @Author jiebai
 * @Date 2021/5/12 17:43
 * @Version 1.0
 **/
public class StackTest {

    public static boolean isValid(String s){
        // 括号之间的对应规则
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (mappings.containsKey(chars[i])) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != mappings.get(chars[i])) {
                    return false;
                }
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime() / 1000);

    }
}
