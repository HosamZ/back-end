package at.nacs.ex5thecalculator.model;

public interface Operation {
    boolean matches(Expression expression);

    double apply(Expression expression);
}