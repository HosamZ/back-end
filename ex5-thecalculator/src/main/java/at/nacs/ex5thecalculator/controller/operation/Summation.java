package at.nacs.ex5thecalculator.controller.operation;

import at.nacs.ex5thecalculator.model.Expression;
import at.nacs.ex5thecalculator.model.Operator;
import org.springframework.stereotype.Component;

@Component
public class Summation implements Operator {
    @Override
    public boolean matches(Expression expression) {
        return "+".equals(expression.getSymbol());
    }

    @Override
    public double apply(Expression expression) {
        return expression.getNumber1() + expression.getNumber2();
    }
}