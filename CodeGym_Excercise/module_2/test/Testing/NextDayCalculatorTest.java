package Testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    @Test
    void nextDayTest0() {
        int day = 28;
        int month = 2;
        int year = 2016;
        int[] expected = {29,2,2016};
        int[] result = NextDayCalculator.NextDay(day, month, year);
        assertArrayEquals(expected, result);
    }

    @Test
    void nextDayTest1() {
        int day = 31;
        int month = 1;
        int year = 2018;
        int[] expected = {1,2,2018};
        int[] result = NextDayCalculator.NextDay(day, month, year);
        assertArrayEquals(expected, result);
    }

    @Test
    void nextDayTest2() {
        int day = 31;
        int month = 12;
        int year = 2012;
        int[] expected = {1,1,2013};
        int[] result = NextDayCalculator.NextDay(day, month, year);
        assertArrayEquals(expected, result);
    }

    @Test
    void nextDayTest3() {
        int day = 30;
        int month = 4;
        int year = 2012;
        int[] expected = {1,5,2012};
        int[] result = NextDayCalculator.NextDay(day, month, year);
        assertArrayEquals(expected, result);
    }
    @Test
    void nextDayTest4() {
        int day = 28;
        int month = 2;
        int year = 2018;
        int[] expected = {1,3,2018};
        int[] result = NextDayCalculator.NextDay(day, month, year);
        assertArrayEquals(expected, result);
    }
    @Test
    void nextDayTest5() {
        int day = 31;
        int month = 12;
        int year = 2012;
        int[] expected = {1,1,2013};
        int[] result = NextDayCalculator.NextDay(day, month, year);
        assertArrayEquals(expected, result);
    }

}