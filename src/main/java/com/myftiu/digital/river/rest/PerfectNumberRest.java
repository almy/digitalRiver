package com.myftiu.digital.river.rest;

import com.myftiu.digital.river.exception.PerfectNumberException;
import com.myftiu.digital.river.service.PerfectNumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by myftiu
 */


@RestController
@RequestMapping("/rest/v1/perfect")
public class PerfectNumberRest {

    @Autowired
    PerfectNumerService perfectNumerService;

    private static final Logger log = LoggerFactory.getLogger(PerfectNumberRest.class);

    @RequestMapping(value = "/validate/{nbr}", method = RequestMethod.GET, produces = "application/json")
    public boolean isPerfect(@PathVariable("nbr") long nbr) throws PerfectNumberException {
        log.info("finding whether the number {} is a perfect number" , nbr);
        return perfectNumerService.isPerfect(nbr);
    }


    @ExceptionHandler(PerfectNumberException.class)
    @RequestMapping(value = "/range/{start}/{end}", method = RequestMethod.GET, produces = "application/json")
    public long[] findPerfectInRange(@PathVariable("start")int start, @PathVariable("end") long end) throws PerfectNumberException {
        log.info("finding all the perfect numbers in the range from {} to {}" , start, end);
        return perfectNumerService.findPerfectInRange(start, end);
    }
}
