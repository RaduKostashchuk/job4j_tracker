package ru.job4j.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> temp = new LinkedHashSet<>();
        for (String el : deps) {
            temp.add(el.split("/")[0]);
            temp.add(el);
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
