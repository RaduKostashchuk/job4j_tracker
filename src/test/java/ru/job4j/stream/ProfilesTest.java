package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenGet2Addresses() {
        List<Profile> list = List.of(
                new Profile(new Address("Moscow", "Arbat", 23, 12)),
                new Profile(new Address("Rostov", "Lenina", 21, 77))
        );
        List<Address> result = Profiles.collect(list);
        List<Address> expected = List.of(
                new Address("Moscow", "Arbat", 23, 12),
                new Address("Rostov", "Lenina", 21, 77)
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenEnmpty() {
        List<Profile> list = new ArrayList<>();
        List<Address> result = Profiles.collect(list);
        assertTrue(result.isEmpty());
    }
}