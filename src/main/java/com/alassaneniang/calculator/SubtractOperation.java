package com.alassaneniang.calculator;

import java.math.BigDecimal;

public class SubtractOperation extends BinaryOperation {

    @Override
    public BigDecimal calculate ( BigDecimal value1, BigDecimal value2 ) {
        return value2.subtract( value1 );
    }

}
