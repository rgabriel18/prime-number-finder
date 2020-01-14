package com.gabriel.challenge.sequencefinder.utils;

import java.util.List;

public class ListUtils {

    String listToString(List<String> list) {
        StringBuilder joinedString = new StringBuilder();
        for (String s : list) {
            joinedString.append(s);
        }
        return joinedString.toString();
    }

    String removeFirst(List<String> list) {
        return list.remove(0);
    }

    String removeLast(List<String> list) {
        return list.remove(list.size() - 1);
    }

}
