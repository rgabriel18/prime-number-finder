package com.gabriel.challenge.sequencefinder.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class PrimeFinder {

    private Map<Integer, Integer> primeMap = new LinkedHashMap<>();

    public PrimeFinder() {
        primeMap.put(2, 2);
        for (int i = 3; i <= 9973; i = i + 2) {
            addToMapIfPrime(i);
        }
    }

    private void addToMapIfPrime(Integer newNumber) {
        double numberRoot = Math.sqrt(newNumber);
        boolean shouldAdd = true;
        for (Map.Entry<Integer, Integer> entry : primeMap.entrySet()) {
            if (newNumber % entry.getValue() == 0) {
                shouldAdd = false;
                break;
            } else if (numberRoot < entry.getValue()) {
                break;
            }
        }

        if (shouldAdd) primeMap.put(newNumber, newNumber);
    }

    boolean isPrime(String s) {
        return primeMap.containsKey(Integer.valueOf(s));
    }

}
