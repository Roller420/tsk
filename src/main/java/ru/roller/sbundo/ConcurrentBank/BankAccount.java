package ru.roller.sbundo.ConcurrentBank;

import java.math.BigDecimal;
import java.util.UUID;

public class BankAccount {
    private BigDecimal balance = BigDecimal.ZERO;
    private UUID id;

    public BankAccount(BigDecimal balance) {
        this.balance = balance;
        this.id = UUID.randomUUID();
    }

    public synchronized void deposit(double amount) {
        balance = balance.add(BigDecimal.valueOf(amount));
    }

    public synchronized void withdraw(double amount) {
        balance = balance.subtract(BigDecimal.valueOf(amount));
    }

    public synchronized BigDecimal getBalance() {
        return balance;
    }
}
