package at.nacs.ex5thecalculator.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.stereotype.Component;

@Value
@Builder
public class Expression {

    private double number1;
    private double number2;
    private String symbol;


}