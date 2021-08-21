package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenListContainsDublicate() {
        List<Order> list = new ArrayList<>();
        list.add(new Order("1", "order 1"));
        list.add(new Order("2", "order 2"));
        list.add(new Order("1", "order 1"));
        HashMap<String, Order> map = OrderConvert.process(list);
        assertEquals(map.size(), 2);
    }
}