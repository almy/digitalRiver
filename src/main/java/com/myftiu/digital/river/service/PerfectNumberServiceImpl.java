package com.myftiu.digital.river.service;

import com.google.common.primitives.Longs;
import com.myftiu.digital.river.exception.PerfectNumberException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myftiu
 */
@Service
public class PerfectNumberServiceImpl implements PerfectNumerService {

    private static final Logger logger = LoggerFactory.getLogger(PerfectNumberServiceImpl.class);

    /**
     *
     * @param number
     * @return true if the number is perfect, false otherwise
     * @throws PerfectNumberException
     */
    public boolean isPerfect(long number) throws PerfectNumberException {
        if (number < 0) {
            logger.error("wrong arguments were passed {}", number);
            throw new PerfectNumberException("argument must not be negative");
        }
        if (number % 2 == 1) {
            logger.info("an odd number was found");
            return false;
        }

        int factorSum = 1;

        /* we can iterate up to the square root of n */
        for (int factor=2; factor*factor<=number; factor++) {
            if (number % factor == 0) {
                // a  factor is found therefore it will be added to the sum
                factorSum += factor;
                long otherFactor = number / factor;
                /*
                 we have to make sure that we don't add same number twice
                 like 6 in case of 6x6
                */

                if (otherFactor != factor)
                    factorSum += otherFactor;
            }
        }
        return (factorSum == number);
    }






    @Override
    public long[] findPerfectInRange(int start, long end) throws PerfectNumberException {

        if(start < 0 || end < 0) {
            logger.error("start number or end number were not as expected ");
            throw new PerfectNumberException("arguments must not be negative");
        }

        if(end < start) {
            logger.error("start number is lower than end were not as expected ");
            throw new PerfectNumberException("end number must not be higher than start number");
        }

        List<Integer> perfectNumbersRange = new ArrayList<Integer>();
        for(int i = start; i<=end; i++) {
            if(isPerfect(i)) {
                logger.info("a new perfect number was found {}", i);
                perfectNumbersRange.add(i);
            }
        }


        return Longs.toArray(perfectNumbersRange);
    }
}
