package com.jay.calculator.expressions;

import com.jay.calculator.OrderGroup;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Jay Yang
 * @date 2022/2/9
 */
public class DivideExpression extends CalculableExpression {

    private final CalculableExpression first;

    private final CalculableExpression second;

    public DivideExpression(CalculableExpression first, CalculableExpression second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public BigDecimal calculate() {
        return first.calculate()
                .divide(second.calculate(), 30, RoundingMode.HALF_UP)
                .stripTrailingZeros();
    }

    /**
     * @author Jay Yang
     * @date 2022/2/9
     */
    public static class DivideSymbol extends SymbolExpression<DivideExpression> {

        @Override
        public OrderGroup order() {
            return OrderGroup.MULTIPLY_DIVIDE;
        }

        @Override
        public String symbol() {
            return "/";
        }

        @Override
        public DivideExpression shrink() {

            DivideExpression divideExpression = new DivideExpression(
                    (CalculableExpression) this.prev, (CalculableExpression) this.next);
            join(divideExpression, this.next.next);
            join(this.prev.prev, divideExpression);

            return divideExpression;
        }

    }
}
