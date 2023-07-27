package com.pedro.aopdemo.dao;

import com.pedro.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount(Account account, boolean vipFlap) {
        System.out.println(getClass() + " ADDING AN ACCOUNT");

    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " doWork()");
        return true;
    }
}
