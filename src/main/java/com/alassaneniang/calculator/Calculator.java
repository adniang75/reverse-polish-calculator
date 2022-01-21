package com.alassaneniang.calculator;

import java.math.BigDecimal;
import java.util.Stack;

public class Calculator {

    private final Stack<BigDecimal> values = new Stack<>();

    public BigDecimal getAccumulator () {
        return this.values.isEmpty() ? BigDecimal.ZERO : this.values.peek();
    }

    public void setAccumulator ( BigDecimal value ) {
        if ( !this.values.isEmpty() ) {
            this.values.pop();
        }
        this.values.push( value );
    }

    public void enter () {
        this.values.push( getAccumulator() );
    }

    public void drop () {
        this.values.pop();
    }
}
