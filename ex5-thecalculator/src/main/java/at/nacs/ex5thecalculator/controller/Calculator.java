package at.nacs.ex5thecalculator.controller;

import at.nacs.ex5thecalculator.model.Expression;
import at.nacs.ex5thecalculator.model.IllegalArgumentException;
import at.nacs.ex5thecalculator.model.Operator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Calculator {

    @Bean
    Operator multiplicatition;

    @Bean
    Operator division() {
        return new Operator() {
        }
    }

    @Bean


    public double calculate(Expression expression) throws IllegalArgumentException {
        if (  ) {
            throw new IllegalArgumentException();
        }

        return 0;
    }
}
