package at.nacs.configurationspring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WeekDaysLoaderTest {


    @Autowired
    WeekDaysLoader weekDaysLoader;

    @Test
    void testDaysSize() {
        List<String> days = weekDaysLoader.getDays();

        assertEquals(2, days.size());
    }

    @Test
    void testDaysOrder() {
        List<String> days = weekDaysLoader.getDays();

        String actualDaysOrder = days.stream()
                .collect(Collectors.joining(", "));
        String expectedDays = "day1, day2";

        assertEquals(expectedDays, actualDaysOrder);

    }
}