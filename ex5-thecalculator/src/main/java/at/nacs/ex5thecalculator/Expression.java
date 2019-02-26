package at.nacs.ex5thecalculator;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Expression {

    private final Double number1;
    private final Double number2;
    private final String symbol;

}