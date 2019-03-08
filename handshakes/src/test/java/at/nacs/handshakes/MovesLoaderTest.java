package at.nacs.handshakes;

import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MovesLoaderTest {

    @Autowired
    MovesLoader movesLoader;

    @ParameterizedTest
    @CsvSource({
            "2, thumb touches back",
            "3, little finger grab",
            "5, tickles over palm",
            "6, bro knock",
            "9, thousand knuckles",
    })
    void testMovesCorrectValues(Integer moveNumber, String moveName) {
        Map<Integer, String> moves = movesLoader.getMoves();

        assertThat(moves, IsMapContaining.hasEntry(moveNumber, moveName));
    }

    @Test
    void testMovesTotalCount() {
        Map<Integer, String> moves = movesLoader.getMoves();

        assertEquals(5, moves.size());
    }

    @Test
    void testWrongBookValue() {
        Map<Integer, String> moves = movesLoader.getMoves();

        assertThat(moves, not(IsMapContaining.hasEntry(10, "Good bye")));
    }
}