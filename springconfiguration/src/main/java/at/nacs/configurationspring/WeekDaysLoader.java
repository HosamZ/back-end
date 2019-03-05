package at.nacs.configurationspring;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WeekDaysLoader {

    @Value("${daysOfWeek.load}")
    @Getter
    private List<String> days;

}
