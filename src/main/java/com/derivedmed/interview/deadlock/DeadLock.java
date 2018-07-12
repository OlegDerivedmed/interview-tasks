package com.derivedmed.interview.deadlock;

import lombok.Data;

public class DeadLock {

    public static void main(String[] args) {
        var acc1 = new Account();
        var acc2 = new Account();

        new Thread(() -> {
            try {
                Transfer.transfer(acc1, acc2, 400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                Transfer.transfer(acc2, acc1, 400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

@Data
class Account {
    int balance;
}

class Transfer {

    static void transfer(Account a, Account b, int summ) throws InterruptedException {
        synchronized (a) {
            Thread.sleep(1000);
            synchronized (b) {
                a.setBalance(a.getBalance() - summ);
                b.setBalance(b.getBalance() + summ);
            }
        }
    }
}
