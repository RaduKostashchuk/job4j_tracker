package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;

public class PhoneDictionaryTest {

        @Test
        public void whenFindByName() {
            var phones = new PhoneDictionary();
            phones.add(
                    new Person("Petr", "Arsentev", "Bryansk", "534872")
            );
            ArrayList<Person> persons = phones.find("Petr");
            assertThat(persons.get(0).getSurname(), is("Arsentev"));
        }

    @Test
    public void whenNotFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "Bryansk", "534872")
        );
        ArrayList<Person> persons = phones.find("Ivan");
        assertThat(persons.size(), is(0));
    }
}