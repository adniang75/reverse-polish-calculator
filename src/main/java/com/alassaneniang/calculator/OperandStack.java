package com.alassaneniang.calculator;

import java.math.BigDecimal;
import java.util.Stack;

public class OperandStack {

    private final Stack<BigDecimal> stack = new Stack<>();

    public BigDecimal peek () {
        return stack.isEmpty() ? BigDecimal.ZERO : stack.peek();
    }

    public void push ( BigDecimal value ) {
        stack.push( value );
    }

    public void replaceTop ( BigDecimal value ) {
        if ( !stack.isEmpty() ) {
            stack.pop();
        }
        stack.push( value );
    }

    public void pop () {
        if ( !stack.isEmpty() ) {
            stack.pop();
        }
    }
}
