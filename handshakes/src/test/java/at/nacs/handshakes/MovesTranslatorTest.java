package at.nacs.handshakes;

import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MovesTranslatorTest {

    @Autowired
    MovesTranslator movesTranslator;

    @ParameterizedTest
    @CsvSource({
            "12, move2",
            "31, move3",
            "15, move5",
            "61, move6",
            "91, move9",
    })
    void testRightTranslateValues(int price, String expected) {
        Optional<String> actual = movesTranslator.translateToMoves(price);

        assertEquals(expected,actual.get());
    }
    @ParameterizedTest
    @CsvSource({
            "11, Optional.empty",
            "101010,Optional.empty ",
    })
    void testWrongTranslations(int price,String expected){
        Optional<String> actual = movesTranslator.translateToMoves(price);

        assertEquals(expected,actual);
    }
}