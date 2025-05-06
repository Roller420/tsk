package ru.roller.sbundo.ConcurrentBank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ConcurrentBank {

    private List<BankAccount> bankAccounts = new ArrayList<BankAccount>();

    public BankAccount createAccount(double amount) {
        BigDecimal bigDecimal = BigDecimal.valueOf(amount);
        BankAccount account = new BankAccount(bigDecimal);
        bankAccounts.add(account);
        return account;
    }

    public synchronized void transfer(BankAccount from, BankAccount to, double amount) {
        from.withdraw(amount);
        to.deposit(amount);
    }

    public double getTotalBalance () {
        return bankAccounts.stream().map(BankAccount::getBalance).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
    }
}

