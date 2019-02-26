package at.nacs.ex5thecalculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Calculator {

    @Bean
    Operation division(){
        return new Operation() {
        }
    }

    @Bean
    Operation multiplicatition;

    @Bean


    public double calculate(Expression expression) {

        return 0;
    }
}
