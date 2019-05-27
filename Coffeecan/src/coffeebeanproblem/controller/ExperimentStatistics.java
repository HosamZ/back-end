package coffeebeanproblem.controller;

import coffeebeanproblem.model.CoffeeBean;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

@UtilityClass
public class ExperimentStatistics {
    private Queue<CoffeeBean> coffeeBeans = CoffeeBeanGenerator.generateBeans(10);

    public long getWhiteBeansNumber() {
        long whiteCount = coffeeBeans.stream()
                .filter(e -> e.toString().contains("white"))
                .count();
        return whiteCount;
    }

    public long getBlackBeansNumber() {
        long blackCount = coffeeBeans.stream()
                .filter(e -> e.toString().contains("black"))
                .count();
        return blackCount;
    }

    public List<Long> getBlackBeansPercentage() {
        return coffeeBeans.stream()
                .filter(e -> e.toString().contains("black"))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .map(e -> getBlackBeansNumber() * 100 / coffeeBeans.size())
                .collect(Collectors.toList());
    }
    public List<Long> getWhiteBeansPercentage() {
        return coffeeBeans.stream()
                .filter(e -> e.toString().contains("white"))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .map(e -> getWhiteBeansNumber() * 100 / coffeeBeans.size())
                .collect(Collectors.toList());
    }
}