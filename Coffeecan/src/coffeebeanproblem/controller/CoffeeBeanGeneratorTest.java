package coffeebeanproblem.controller;

import coffeebeanproblem.model.CoffeeBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoffeeBeanGeneratorTest {

    @Test
    void testNotNull() {
        Queue<CoffeeBean> coffeeBeans = CoffeeBeanGenerator.generateBeans(10);
        CoffeeBean actual = MakingADecision.getOneBeanOutOfTwo(coffeeBeans);
        Assertions.assertNotNull(actual);
    }
}