package coffeebeanproblem.controller;

import coffeebeanproblem.model.CoffeeBean;
import lombok.experimental.UtilityClass;

import java.util.Queue;

@UtilityClass
public class MakingADecision {

    public CoffeeBean getOneBeanOutOfTwo(Queue<CoffeeBean> beans) {
        if (beans.poll().equals(beans.poll())) {
            return CoffeeBean.builder().color("black").build();
        }
        return CoffeeBean.builder().color("white").build();
    }
}