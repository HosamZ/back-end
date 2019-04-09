package verifiers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckerTest {

    private Verifier checker = new LengthVerifier();


    @ParameterizedTest
    @CsvSource({
            "hosaM123,true",
            "sssssss,false",
            "hossam123,true",
            "null,false"
    })
    void checkPasswordLength(String password, boolean expected) {
        boolean actual = checker.verify(password);

        assertEquals(expected, actual);
    }
//    @ParameterizedTest
//    @CsvSource({
//            ",false",
//            "sssssssss,true",
//            "hossam123,true"
//    })
//    void checkNullCase(String password, boolean expected) {
//        boolean actual = Checker.checkNull(password);
//
//        assertEquals(expected, actual);
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "hosassss,false",
//            "111111111,false",
//            "hossaM,true"
//    })
//    void checkUppercase(String password, boolean expected) {
//        boolean actual = Checker.checkUppercase(password);
//
//        assertEquals(expected, actual);
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "hosaM123,true",
//            "SSSSS,false",
//            "hossam123,true"
//    })
//    void checkLowercase(String password, boolean expected) {
//        boolean actual = Checker.checkLowercase(password);
//
//        assertEquals(expected, actual);
//    }
//    @Test
//    void testNullCase(){
//        String password = null;
//
//        boolean actual = Checker.checkNull(password);
//        boolean expected = false;
//
//        assertEquals(expected,actual);
}