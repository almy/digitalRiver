package com.myftiu.digital.river.unit;

import com.myftiu.digital.river.exception.PerfectNumberException;
import com.myftiu.digital.river.service.PerfectNumberServiceImpl;
import com.myftiu.digital.river.service.PerfectNumerService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by myftiu
 */


public class PerfectNumberTest {

    private static final PerfectNumerService perfectNumerService = new PerfectNumberServiceImpl();
    @Rule
    public ExpectedException expectedException = ExpectedException.none();



    @Test
    public void shouldReturnTrueOnCheck() throws PerfectNumberException {

        //given
        int perfectNumber = 28;

        //when
        boolean result = perfectNumerService.isPerfect(perfectNumber);

        //then
        assertTrue(result);
    }


    @Test
    public void shouldReturnFalseOnCheck() throws PerfectNumberException {
        //given
        int perfectNumber = 49;

        //when
        boolean result = perfectNumerService.isPerfect(perfectNumber);

        //then
        assertFalse(result);
    }


    @Test
    public void shouldReturnAnArrayOfPerfectNumbers() throws PerfectNumberException {

        //given
        int start = 1;
        int end = 8128;

        long[] result = perfectNumerService.findPerfectInRange(start, end);

        //then
        assertArrayEquals(result, new long[]{6, 28, 496, 8128});
    }


    @Test
    public void shouldThrowException() throws PerfectNumberException {
        //given
        int perfectNumber = -1;

        //when
        expectedException.expect(PerfectNumberException.class);
        expectedException.expectMessage("argument must not be negative");
          perfectNumerService.isPerfect(perfectNumber);

        //then


    }

    @Test
    public void shouldThrowValidationException() throws PerfectNumberException {

        //given
        int end = 1;
        int start = 8128;

        expectedException.expect(PerfectNumberException.class);
        expectedException.expectMessage("end number must not be higher than start number");
        perfectNumerService.findPerfectInRange(start, end);

        //then


    }

}
