package com.hfmodel.service;

import com.hfmodel.bean.Account;

import java.util.List;

public interface AccountService {

    Account findAccountById(Integer id);

    List<Account> findAll();

    boolean deleteAccount(Integer id);

    Integer updateAccount(Account account);

    void saveAccount(Account account);
}
