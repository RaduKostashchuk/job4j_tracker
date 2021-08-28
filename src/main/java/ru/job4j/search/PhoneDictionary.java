package ru.job4j.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> searchName = (person) -> person.getName().contains(key);
        Predicate<Person> searchSurname = (person) -> person.getSurname().contains(key);
        Predicate<Person> searchPhone = (person) -> person.getPhone().contains(key);
        Predicate<Person> searchAddress = (person) -> person.getName().contains(key);
        Predicate<Person> combine = (person) ->
                searchName.test(person) || searchSurname.test(person)
                || searchPhone.test(person) || searchAddress.test(person);
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
