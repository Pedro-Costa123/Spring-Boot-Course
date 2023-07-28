package com.pedro.aopdemo.dao;

import com.pedro.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();
        Account account = new Account("Name", "Level");
        Account account1 = new Account("Name - 1", "Level - 1");
        Account account2 = new Account("Name - 2", "Level - 2");
        accounts.add(account);
        accounts.add(account1);
        accounts.add(account2);
        return accounts;
    }

    @Override
    public void addAccount(Account account, boolean vipFlap) {
        System.out.println(getClass() + " ADDING AN ACCOUNT");

    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " doWork()");
        return true;
    }

    public String getName() {
        System.out.println(getClass() + " getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " setServiceCode()");
        this.serviceCode = serviceCode;
    }

}
