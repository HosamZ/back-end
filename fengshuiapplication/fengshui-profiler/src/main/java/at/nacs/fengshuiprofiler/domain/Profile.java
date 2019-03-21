package at.nacs.fengshuiprofiler.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class Profile {
    private final LocalDate birthday;
    private final String sign;
}
