package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles
                .stream().map(Profile::getAddress)
                .sorted(this::compare)
                .distinct()
                .collect(Collectors.toList());
    }

    private int compare(Address addr1, Address addr2) {
        int result = addr1.getCity().compareTo(addr2.getCity());
        if (result != 0) {
            return result;
        }
        result = addr1.getStreet().compareTo(addr2.getStreet());
        if (result != 0) {
            return result;
        }
        result = Integer.compare(addr1.getHome(), addr2.getHome());
        if (result != 0) {
            return result;
        }
        return Integer.compare(addr1.getApartment(), addr2.getApartment());
    }
}