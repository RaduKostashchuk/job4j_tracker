package ru.job4j.collection;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class PassportOfficeTest {

    @Test
    public void whenAdd() {
        Citizen citizen = new Citizen("Ivan Grigoriev", "3445-232455");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get("3445-232455"), is(citizen));
    }

    @Test
    public void whenAddFail() {
        Citizen citizen = new Citizen("Ivan Grigoriev", "3445-232455");
        Citizen fakeCitizen = new Citizen("Semen Grigoriev", "3445-232455");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        boolean result = office.add(fakeCitizen);
        assertThat(result, is(false));
    }
}