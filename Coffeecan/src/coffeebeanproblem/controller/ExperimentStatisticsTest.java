package coffeebeanproblem.controller;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
@Log
class ExperimentStatisticsTest {

    @Test
    void receiveExperiment() {
        long getWhite = ExperimentStatistics.getWhiteBeansNumber();
        long getBlack = ExperimentStatistics.getBlackBeansNumber();
        log.info("White beans : " + getWhite);
        log.info("Black beans : " + getBlack);
    }
}