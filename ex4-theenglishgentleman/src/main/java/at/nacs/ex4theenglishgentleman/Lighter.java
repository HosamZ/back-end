package at.nacs.ex4theenglishgentleman;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Data
public class Lighter {

    public void light(Cigar cigar) {
        cigar.setLit(true);
    }
}