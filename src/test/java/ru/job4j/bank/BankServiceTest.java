package ru.job4j.bank;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434"), is(Optional.of(user)));
    }

    @Test
    public void whenNotRewriteUser() {
        User user1 = new User("3434", "Petr Arsentev");
        User user2 = new User("3434", "Egor Arsentev");
        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addUser(user2);
        assertThat(bank.findByPassport("3434").get().getUsername(), is(user1.getUsername()));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("34", "5546"), is(Optional.empty()));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").get().getBalance(), is(150D));
    }

    @Test
    public void transferMoney1() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").get().getBalance(), is(200D));
    }

    @Test
    public void transferMoney2() {
        User user1 = new User("3434", "Petr Arsentev");
        User user2 = new User("3435", "Ivan Petrov");
        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccount(user1.getPassport(), new Account("5546", 150D));
        bank.addAccount(user2.getPassport(), new Account("113", 50D));
        bank.transferMoney(user1.getPassport(), "5546", user2.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user2.getPassport(), "113").get().getBalance(), is(200D));
    }
}