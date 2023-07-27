package com.pedro.aopdemo.dao;

import com.pedro.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

}
