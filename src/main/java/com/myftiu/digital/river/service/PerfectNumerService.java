package com.myftiu.digital.river.service;

import com.myftiu.digital.river.exception.PerfectNumberException;

/**
 * Created by myftiu
 */


public interface PerfectNumerService {

    boolean isPerfect(long nbr) throws PerfectNumberException;

    long[] findPerfectInRange(int start, long end) throws PerfectNumberException;
}
