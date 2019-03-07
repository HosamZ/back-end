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
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MovesTranslatorTest {

    @Autowired
    MovesTranslator movesTranslator;

    @ParameterizedTest
    @CsvSource({
            "1, move1",
            "2, move2",
            "12, move1 move2",
            "21, move2 move1",
            "72717, move2 move1"
    })
    void testRightTranslateValues(int price, String moves) {
        List<String> actual = movesTranslator.translateToMoves(price);
        List<String> expected = List.of(moves.split(" "));

        assertEquals(expected,actual);
    }
    @Test
    void testWrongTranslations(){
        List<String> actual = movesTranslator.translateToMoves(33);

        assertTrue(actual.isEmpty());
    }
}