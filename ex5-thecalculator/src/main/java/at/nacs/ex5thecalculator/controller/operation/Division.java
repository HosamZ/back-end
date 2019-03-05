package at.nacs.ex5thecalculator.controller.operation;

import at.nacs.ex5thecalculator.model.Expression;
import at.nacs.ex5thecalculator.model.Operation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Division implements Operation {
    @Override
    public boolean matches(Expression expression) {
        return "/".equals(expression.getSymbol());
    }

    @Override
    public double apply(Expression expression) {
        if (expression.getNumber2() == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return expression.getNumber1() / expression.getNumber2();
    }
}
