package ru.job4j.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> temp = new LinkedHashSet<>();
        for (String str : deps) {
            String toAdd = "";
            for (String el : str.split("/")) {
                toAdd += el + "/";
                temp.add(toAdd.substring(0, toAdd.length() - 1));
            }
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
