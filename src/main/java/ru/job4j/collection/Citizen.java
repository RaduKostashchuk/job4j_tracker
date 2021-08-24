package ru.job4j.collection;

import java.util.Objects;

public class Citizen {
    private String username;
    private String passport;

    public Citizen(String username, String passport) {
        this.username = username;
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Citizen citizen = (Citizen) o;
        return Objects.equals(passport, citizen.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
