package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestJunit {

    @Test
    public void testAssertEquals() {
        //given
        int firstNum = 5;
        int secondNum = 20;

        //when
        int result = firstNum * secondNum;

        //then
        Assertions.assertEquals(100, result);
        Assertions.assertNotEquals(50, result);
    }


}
