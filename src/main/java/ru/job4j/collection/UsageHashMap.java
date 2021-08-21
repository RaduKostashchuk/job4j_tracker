package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageHashMap {
    public static void main(String[] args) {
        Map<String, String> hashmap = new HashMap<>();
        hashmap.put("test@mail.ru", "Ivanov Ivan Ivanovich");
        hashmap.put("my@bk.ru", "Petrov Andrey Sergeevich");
        hashmap.put("mailbox@host.ru", "Petrov Aleksandr Petrovich");
        for (String key : hashmap.keySet()) {
            System.out.println(key + " : " + hashmap.get(key));
        }
    }
}
