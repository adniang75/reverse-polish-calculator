package com.alassaneniang.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName( "Operand Stack" )
class OperandStackTest {

    BigDecimal value1;
    BigDecimal value2;
    BigDecimal value3;
    BigDecimal value4;
    private OperandStack stack;

    @BeforeEach
    void setUp () {
        stack = new OperandStack();
        value1 = BigDecimal.valueOf( 12 );
        value2 = BigDecimal.valueOf( 22 );
        value3 = BigDecimal.valueOf( 52 );
        value4 = BigDecimal.valueOf( 45 );
    }

    @Test
    @DisplayName( "New Operand Stack returns zero" )
    void testNewOperandStackPeekReturnsZero () {
        assertThat( stack.peek() ).isEqualTo( BigDecimal.ZERO );
    }

    @Test
    @DisplayName( "Pushing value onto the stack" )
    void testPushingValueOntoStack () {
        stack.push( value1 );
        assertThat( stack.peek() ).isEqualTo( value1 );
    }

    @Test
    @DisplayName( "Replacing top of stack with new value" )
    void testReplacingTopOfStack () {
        stack.push( value1 );
        stack.replaceTop( value2 );
        assertThat( stack.peek() ).isEqualTo( value2 );
    }

    @Test
    @DisplayName( "Replacing top of an empty stack with new value" )
    void testReplacingTopWithEmptyStack () {
        stack.replaceTop( value3 );
        assertThat( stack.peek() ).isEqualTo( value3 );
    }

    @Test
    @DisplayName( "Popping value from the stack" )
    void testPoppingValueFromStack () {
        stack.push( value4 );
        stack.push( value3 );
        stack.pop();
        assertThat( stack.peek() ).isEqualTo( value4 );
    }

    @Test
    @DisplayName( "Popping value from an empty stack" )
    void testPoppingFromAnEmptyStack () {
        stack.pop();
        assertThat( stack.peek() ).isEqualTo( BigDecimal.ZERO );
    }
}
