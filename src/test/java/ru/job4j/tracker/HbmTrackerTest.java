package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HbmTrackerTest {
        private final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder().configure().build();
        private final SessionFactory sf =
                new MetadataSources(registry).buildMetadata().buildSessionFactory();

    @After
    public void cleanup() {
        Session session = sf.openSession();
        session.beginTransaction();
        session.createQuery("from Item", Item.class).list().forEach(session::remove);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void whenAdd1ThenGet1() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("name");
        tracker.add(item);
        List<Item> result = tracker.findAll();
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getName(), is("name"));
    }

    @Test
    public void whenUpdateThenGetUpdatedById() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("name");
        Item itemUpdated = new Item("updated");
        tracker.add(item);
        tracker.replace(item.getId(), itemUpdated);
        List<Item> result = tracker.findAll();
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getName(), is("updated"));
    }

    @Test
    public void whenDeleteThenGetEmptyList() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("name");
        tracker.add(item);
        tracker.delete(item.getId());
        List<Item> result = tracker.findAll();
        assertThat(result.size(), is(0));
    }

    @Test
    public void whenFindByNameThenGetListOf2() {
        HbmTracker tracker = new HbmTracker();
        Item item1 = new Item("name");
        Item item2 = new Item("name");
        tracker.add(item1);
        tracker.add(item2);
        List<Item> result = tracker.findByName("name");
        assertThat(result.size(), is(2));
    }

    @Test
    public void whenFindByIdThenGetOne() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("name");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is("name"));
    }

}