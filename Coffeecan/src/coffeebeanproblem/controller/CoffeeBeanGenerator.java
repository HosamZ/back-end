package coffeebeanproblem.controller;

import coffeebeanproblem.model.CoffeeBean;
import lombok.experimental.UtilityClass;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

@UtilityClass
public class CoffeeBeanGenerator {
    private Random random = new Random();

    public Queue<CoffeeBean> generateBeans(int amountOfBeans) {
        return IntStream.generate(() -> 0)
                .limit(amountOfBeans)
                .mapToObj(toRandom())
                .map(toColor())
                .map(toCoffeeBean())
                .collect(toCollection(LinkedList::new));

    }

    private static IntFunction<Boolean> toRandom() {
        return n -> random.nextBoolean();
    }

    private static Function<Boolean, String> toColor() {
        return b -> b ? "white" : "black";
    }

    private Function<String, CoffeeBean> toCoffeeBean() {
        return color -> CoffeeBean.builder().color(color).build();
    }
}