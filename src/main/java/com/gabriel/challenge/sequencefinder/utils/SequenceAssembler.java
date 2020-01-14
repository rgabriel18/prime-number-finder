package com.gabriel.challenge.sequencefinder.utils;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SequenceAssembler {

    @Autowired
    PrimeFinder primeFinder;

    @Autowired
    ListUtils listUtils;

    private String longestSequence = "";

    public String getLongestPrimeSequence(String originalSequence) {
        String decimalSequence = originalSequence.split("\\.")[1];

        LinkedList<String> remainingNumbers = new LinkedList<>(Arrays.asList(decimalSequence.split("")));

        while (!remainingNumbers.isEmpty()) {
            reccurringAddToSequenceIfPrime(remainingNumbers, new LinkedList<>());
            listUtils.removeFirst(remainingNumbers);
        }

        return longestSequence;
    }

    private void reccurringAddToSequenceIfPrime(List<String> remainingNumbers, List<String> usedNumbers) {
        List<String> currentNumbers = new ArrayList<>();

        for (int i = 0; (i < 4 && !remainingNumbers.isEmpty()); i++) {
            currentNumbers.add(listUtils.removeFirst(remainingNumbers));
        }
        usedNumbers.addAll(currentNumbers);


        while (!currentNumbers.isEmpty()) {
            if (primeFinder.isPrime(listUtils.listToString(currentNumbers))) {
                reccurringAddToSequenceIfPrime(remainingNumbers, usedNumbers);
            }
            listUtils.removeLast(usedNumbers);
            remainingNumbers.add(0, listUtils.removeLast(currentNumbers));
        }


        String currenteSequence = listUtils.listToString(usedNumbers);

        if (currenteSequence.length() > longestSequence.length()) {
            longestSequence = currenteSequence;
        }
    }
}
