package coffeebeanproblem.controller;

import coffeebeanproblem.model.CoffeeBean;
import lombok.experimental.UtilityClass;

import java.util.Queue;

@UtilityClass
public class OneExperiment {

    public CoffeeBean doExperiment(int beans) {
        Queue<CoffeeBean> beansAsQueue = CoffeeBeanGenerator.generateBeans(beans);
        CoffeeBean coffeeBean = MakingADecision.getOneBeanOutOfTwo(beansAsQueue);
        if (beansAsQueue.size() >= 2) {
            return  coffeeBean;
        }
        return coffeeBean;
    }

}