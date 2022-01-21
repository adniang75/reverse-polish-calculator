package com.alassaneniang.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName( "Reverse Polish Calculator Tests" )
class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp () {
        calculator = new Calculator();
    }

    @Test
    @DisplayName( "New calculator has an accumulator of zero" )
    void testNewCalculatorHasAnAccumulatorOfZer () {
        assertThat( calculator.getAccumulator() ).isEqualTo( BigDecimal.ZERO );
    }

    @Test
    @DisplayName( "Setting the value of an accumulator" )
    void testSettingAccumulatorValue () {
        BigDecimal value = BigDecimal.valueOf( 23 );
        calculator.setAccumulator( value );
        assertThat( calculator.getAccumulator() ).isEqualTo( value );
    }

    @Test
    @DisplayName( "Entering and dropping values" )
    void testEnteringAndDroppingValues () {
        BigDecimal value1 = BigDecimal.valueOf( 12 );
        BigDecimal value2 = BigDecimal.valueOf( 22 );
        BigDecimal value3 = BigDecimal.valueOf( 52 );
        calculator.setAccumulator( value1 );
        calculator.enter();
        calculator.setAccumulator( value2 );
        calculator.enter();
        calculator.setAccumulator( value3 );
        assertThat( calculator.getAccumulator() ).isEqualTo( value3 );
        calculator.drop();
        assertThat( calculator.getAccumulator() ).isEqualTo( value2 );
        calculator.drop();
        assertThat( calculator.getAccumulator() ).isEqualTo( value1 );
    }
}
