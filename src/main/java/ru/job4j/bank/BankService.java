package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковского сервиса:
 * содержитт базу данных о пользователях и счетах,
 * методы поиска и добавления пользователей и счетов.
 * @author KOSTASHCHUK RADU
 * @version 1.0
 */
public class BankService {
    /**
     *  Базой данных банковского сервиса является коллекция типа HasMap.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в базу данных.
     * @param user Пользователь, которрый добавляется в базу данных.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет счет в базу данных.
     * @param passport Номер паспорта пользователя, к которому добавляется счет.
     * @param account Номер счета.
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()
                && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Метод производит поиск пользователя по номеру паспорта.
     * @param passport Номер паспорта.
     * @return Возвращает пользователя или null объект.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод производит поиск счета по номеру паспорта пользователя и реквизитам счета.
     * @param passport Номер паспорта.
     * @param requisite Реквизиты счета.
     * @return Возвращает счет или null объект.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(u -> users.get(u).stream()
                .filter(a -> a.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод осуществляет перевод средств между счетами.
     * @param srcPassport Номер паспорта пользователя, у которого будут списаны средства.
     * @param srcRequisite Реквизиты исходного счета списания.
     * @param destPassport Номер паспорта пользователя, которому осуществляется перевод.
     * @param destRequisite Реквизиты счета назначения.
     * @param amount Количество переводимых средств.
     * @return Метод возвращает true, если перевод оказался успешным и false, в случае неудачи.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAcc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dstAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc.isPresent() && dstAcc.isPresent() && srcAcc.get().getBalance() >= amount) {
            srcAcc.get().setBalance(srcAcc.get().getBalance() - amount);
            dstAcc.get().setBalance(dstAcc.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
