package at.nacs.cup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class CupTest {

    @Autowired
    Cup cup;

    @Test
    void isHasCoin() {
        boolean hasCoin = cup.isHasCoin();

        assertThat(hasCoin).isFalse();
    }

//    @Test
//    void setHasCoin() {
//        cup.setHasCoin(true);
//
//    }
}