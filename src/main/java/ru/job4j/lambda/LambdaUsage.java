package ru.job4j.lambda;

import java.util.*;

public class LambdaUsage {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("jksdghfshjkfh", "hkbdfk"));
        Comparator<String> comp = (left, right) -> {
            System.out.println("We are comparing string1 length = "
                            + left.length() + " and string2 length = " + right.length()
                            + " in descending order.");
            return Integer.compare(right.length(), left.length());
        };
        list.sort(comp);
        System.out.println(list);

    }
}
