package at.nacs.fengshuiprofiler.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Match {

    private final Profile profile1;
    private final Profile profile2;
        private final String signCompatibility;
    private final String loveCompatibility;
}
