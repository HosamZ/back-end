package at.nacs.configurationspring;

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
class BookShopLoaderTest {

    @Autowired
    BookShopLoader bookShopLoader;

    @ParameterizedTest
    @CsvSource({
            "harrypotter,3",
            "foundation, 2",
            "lordoftherings, 4",
    })
    void booksCopies(String bookName, int booksCopies) {
        Map<String, Integer> books = bookShopLoader.getBooks();

        assertThat(books, IsMapContaining.hasEntry(bookName, booksCopies));

    }

    @Test
    void getBooksSize() {
        Map<String, Integer> books = bookShopLoader.getBooks();

        assertEquals(3, books.size());
    }

    @Test
    void testWrongBookValue() {
        Map<String, Integer> books = bookShopLoader.getBooks();

        assertThat(books, not(IsMapContaining.hasEntry("Game of thrones", 100)));
    }
}