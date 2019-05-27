package coffeebeanproblem.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CoffeeBean {
    private String color;
}