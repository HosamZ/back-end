package coffeebeanproblem.controller;

import coffeebeanproblem.model.CoffeeBean;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@UtilityClass
public class ExperimentsRecorder {

    public void repeat(int experimentsTimer, int amountOfBeans) {

        for (int times = 0; times < experimentsTimer; times++) {
            CoffeeBean bean = OneExperiment.doExperiment(amountOfBeans);
            System.out.println(bean);
        }

        try {
            CoffeeBean bean = OneExperiment.doExperiment(amountOfBeans);
            File resultsFile = new File("/home/hosam/programming/Coffeecan/src/coffeebeanproblem/resources/results.txt");

            FileWriter fileWriter = new FileWriter(resultsFile);
            for (int times = 0; times < experimentsTimer; times++) {
                fileWriter.append("\n" + String.valueOf(bean));
            }
            fileWriter.close();
        } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }
    }

    public void whiteBlackBeansEncounter() {
//        PrintWriter out = new PrintWriter("coffeebeanproblem/resources/results.txt");
    }
}