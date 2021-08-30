package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User user = findByPassport(passport);
        if (user != null
                && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод производит поиск пользователя по номеру паспорта.
     * @param passport Номер паспорта.
     * @return Возвращает пользователя или null объект.
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод производит поиск счета по номеру паспорта пользователя и реквизитам счета.
     * @param passport Номер паспорта.
     * @param requisite Реквизиты счета.
     * @return Возвращает счет или null объект.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user  = findByPassport(passport);
        if (user == null) {
            return null;
        } else {
            return  users.get(user)
                        .stream()
                        .filter(r -> r.getRequisite().equals(requisite))
                        .findFirst()
                        .orElse(null);
        }
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
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account dstAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && dstAcc != null && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            dstAcc.setBalance(dstAcc.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
