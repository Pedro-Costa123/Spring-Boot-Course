package com.pedro.aopdemo.dao;

import com.pedro.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccounts();

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);

}
