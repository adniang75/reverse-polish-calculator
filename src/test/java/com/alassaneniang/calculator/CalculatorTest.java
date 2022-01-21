package com.alassaneniang.calculator;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName( "Reverse Polish Calculator Tests" )
@TestClassOrder( ClassOrderer.OrderAnnotation.class )
class CalculatorTest {

    Calculator calculator;
    BigDecimal value1;
    BigDecimal value2;
    BigDecimal value3;

    @BeforeEach
    void setUp () {
        calculator = new Calculator();
        value1 = BigDecimal.valueOf( 12 );
        value2 = BigDecimal.valueOf( 22 );
        value3 = BigDecimal.valueOf( 52 );
    }

    @Nested
    @DisplayName( "New calculator" )
    @Order( 1 )
    class NewCalculatorTest {

        @Test
        @DisplayName( "New calculator has an accumulator of zero" )
        void testNewCalculatorHasAnAccumulatorOfZero () {
            assertThat( calculator.getAccumulator() ).isEqualTo( BigDecimal.ZERO );
        }

        @Test
        @DisplayName( "Setting the value of an accumulator" )
        void testSettingAccumulatorValue () {
            calculator.setAccumulator( value1 );
            assertThat( calculator.getAccumulator() ).isEqualTo( value1 );
        }
    }

    @Nested
    @DisplayName( "Calculator with 3 values" )
    @Order( 2 )
    class CalculatorWithThreeValuesTest {

        @BeforeEach
        void setUp () {
            calculator.setAccumulator( value1 );
            calculator.enter();
            calculator.setAccumulator( value2 );
            calculator.enter();
            calculator.setAccumulator( value3 );
        }

        @Test
        @DisplayName( "Accumulator after pushing 3 values" )
        void testAccumulatorAfterPushingThreeValues () {
            assertThat( calculator.getAccumulator() ).isEqualTo( value3 );
        }

        @Test
        void testAccumulatorAfterASingleDrop () {
            calculator.drop();
            assertThat( calculator.getAccumulator() ).isEqualTo( value2 );
        }

        @Test
        void testAccumulatorAfterATwoDrop () {
            calculator.drop();
            calculator.drop();
            assertThat( calculator.getAccumulator() ).isEqualTo( value1 );
        }

    }

}
