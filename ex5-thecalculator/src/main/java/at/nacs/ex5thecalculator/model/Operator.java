package at.nacs.ex5thecalculator.model;

public interface Operator {
    boolean matches(Expression expression);

    double apply(Expression expression);
}