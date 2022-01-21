package com.alassaneniang.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName( "Operations" )
class OperationTest {

    BigDecimal value1;
    BigDecimal value2;
    private Calculator calculator;

    @BeforeEach
    void setUp () {
        calculator = new Calculator();
        value1 = BigDecimal.valueOf( 12 );
        value2 = BigDecimal.valueOf( 22 );
        calculator.setAccumulator( value1 );
        calculator.enter();
        calculator.setAccumulator( value2 );
    }

    @Test
    @DisplayName( "Addition execution" )
    void testAddExecution () {
        calculator.execute( "+" );
        assertThat( calculator.getAccumulator() )
                .isEqualTo( value1.add( value2 ) );
    }

    @Test
    @DisplayName( "Subtraction execution" )
    void testSubtractExecution () {
        calculator.execute( "-" );
        assertThat( calculator.getAccumulator() )
                .isEqualTo( value1.subtract( value2 ) );
    }
}
