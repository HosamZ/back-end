package coffeebeanproblem.view;

import coffeebeanproblem.controller.ExperimentStatistics;
import lombok.extern.java.Log;

@Log
public class App {
    public static void main(String[] args) {
      /*  Queue<CoffeeBean> coffeeBeans = CoffeeBeanGenerator.generateBeans(5);
        out.println("coffee beans number : " + coffeeBeans);
        CoffeeBean twoBeans = CoffeeBeanGenerator.getOneBeanOutOfTwo(coffeeBeans);
        out.println("picked two beans :  " + twoBeans);
        for (CoffeeBean coffeeBean : coffeeBeans) {
            CoffeeBeanGenerator.getOneBeanOutOfTwo(coffeeBeans);
        }
        */
        ExperimentStatistics.getBlackBeansNumber();
        log.severe("black Beans : " + ExperimentStatistics.getBlackBeansPercentage() + " %");
        log.severe("white Beans : " + ExperimentStatistics.getWhiteBeansPercentage() + " %");
    }
}