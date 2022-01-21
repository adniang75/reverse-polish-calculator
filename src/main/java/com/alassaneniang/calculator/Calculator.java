package com.alassaneniang.calculator;

import java.math.BigDecimal;

public class Calculator {

    private final OperandStack stack = new OperandStack();

    public BigDecimal getAccumulator () {
        return this.stack.peek();
    }

    public void setAccumulator ( BigDecimal value ) {
        this.stack.replaceTop( value );
    }

    public void enter () {
        this.stack.push( getAccumulator() );
    }

    public void drop () {
        this.stack.pop();
    }
}
