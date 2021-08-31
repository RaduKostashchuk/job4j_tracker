package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        var result = new ArrayList<Person>();
        Predicate<Person> searchName = (person) -> person.getName().contains(key);
        Predicate<Person> searchSurname = (person) -> person.getSurname().contains(key);
        Predicate<Person> searchPhone = (person) -> person.getPhone().contains(key);
        Predicate<Person> searchAddress = (person) -> person.getAddress().contains(key);
        Predicate<Person> combine = (person) -> searchName.or(searchSurname)
                            .or(searchPhone).or(searchAddress).test(person);
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
