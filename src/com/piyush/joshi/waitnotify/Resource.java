package com.piyush.joshi.waitnotify;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Resource {

    Stack<String> stack = new Stack<>();

    public void pushEntry(String entry){
        stack.push(entry);
    }
}
