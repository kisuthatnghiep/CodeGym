package Testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    void fizzBuzzTest1() {
        int number = 35;
        String expected = "FizzBuzz";
        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected,result);
    }
    @Test
    void fizzBuzzTest2() {
        int number = 101;
        String expected = "101";
        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected,result);
    }
    @Test
    void fizzBuzzTest3() {
        int number = 31;
        String expected = "Fizz";
        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected,result);
    }
    @Test
    void fizzBuzzTest4() {
        int number = 53;
        String expected = "FizzBuzz";
        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected,result);
    }
    @Test
    void fizzBuzzTest5() {
        int number = 52;
        String expected = "Buzz";
        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected,result);
    }
    @Test
    void fizzBuzzTest6() {
        int number = -2;
        String expected = "-2";
        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected,result);
    }
}